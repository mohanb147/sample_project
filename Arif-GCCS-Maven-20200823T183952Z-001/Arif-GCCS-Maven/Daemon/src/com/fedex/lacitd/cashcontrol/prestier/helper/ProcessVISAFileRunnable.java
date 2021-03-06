/**
 * ProcessVISAFileRunnable.java
 *
 * Created on 20 de diciembre de 2002, 16:02
 */

package com.fedex.lacitd.cashcontrol.prestier.helper;

import com.enterprisedt.net.ftp.FTPTransferType;
import com.enterprisedt.net.ftp.FTPException;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.PrepPoaBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.AdminBizDelegate;
import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.PrepaidVISAFileVO;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.EmployeeVO;
import com.fedex.lacitd.common.gccsftp.FTPClient;
import com.maverick.sftp.SftpStatusException;

import javax.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * @author  ccardenas
 * 
 */
public class ProcessVISAFileRunnable implements java.lang.Runnable, java.io.Serializable {
    private String[] files=new String[0];    
    
    /** Holds value of property prop. */
    private ServletContext servletCtx;
    
    /** Holds value of property thread. */
    private java.lang.Thread thread;
    
    /** Creates a new instance of InCageExceptionsRunnable */
    public ProcessVISAFileRunnable() {
    }
    
    public void run() {
            Iterator iterFiles=null;
            Properties prop=null;
            FTPClient clt=null;
            PrepPoaBizDelegate biz=null;
            while(!"STOP_THREAD".equals(thread.getName())){

                try{
                	System.out.println("here we are in the process visa thread------ 1");
                	prop=new Properties();
                    prop=Utils.getProperties("P");
                    clt=new FTPClient(prop.getProperty("rod.prepaid.VISAFile.ftpServer"));
                    clt.login(prop.getProperty("rod.prepaid.VISAFile.ftpUserName"),prop.getProperty("rod.prepaid.VISAFile.ftpPwd"));
                    clt.setType(FTPTransferType.BINARY);
                    System.out.println("here we are in the process visa thread------ 2");
                    biz=new PrepPoaBizDelegate();
                    for(int idx=0;idx<files.length;idx++){
                    	 //files[idx].toLowerCase().indexOf("visadtl")<0 to exclude file coming from mainfram that has name visadtl 
                         if(files[idx].toLowerCase().indexOf(".txt")!=-1 && files[idx].toLowerCase().indexOf("visadtl")<0){
                        	 System.out.println("here we are in the process visa thread------ 3");
                             try
                             {
                            	 System.out.println("here we are in the process visa thread------ 4");
                                 BufferedReader br=new BufferedReader(new StringReader(new String(clt.get(prop.getProperty("rod.prepaid.VISAFile.dir")+"/"+files[idx]))));

                                 Collection colAwbs=parseString(br);

                                 Collection notFound=biz.processVISAFile(colAwbs);
                                 System.out.println("processVISAFile complete"); 
                                 if(!notFound.isEmpty()){
                                	 System.out.println("here we are in the process visa thread------ 5");
                                     Collection results=new ArrayList();
                                     PrepNotCheckedScanProc procScan=new PrepNotCheckedScanProc();
                                     procScan.processLastScans(notFound,results);
                                     System.out.println("Before applyPrepNotCheckedScans");                                     
                                     biz.applyPrepNotCheckedScans(results);
                                     System.out.println("After applyPrepNotCheckedScans ");
                                 }
                             }
                             catch(SftpStatusException e)
                             {
                            	 //do nothing since we split into few smaller files                            	 
                             }
                             catch(Exception e)
                             {       
                            	 System.out.println("here we are in the process visa thread------ 6 err");
                            	 e.printStackTrace();
                                 Constants.logger.debug(Utils.stackTraceToString(e));
                                 notifyError( files[ idx], Utils.stackTraceToString(e));
                             }

                             /***moving the file to processed****/
                             clt.rename(prop.getProperty("rod.prepaid.VISAFile.dir")+"/"+files[idx],prop.getProperty("rod.prepaid.VISAFile.processedDir")+"/"+files[idx]+new Date().toString().replace(' ','_').replace(':','_'));
                         }
                    }
                }catch(Exception e){
                     Constants.logger.debug(Utils.stackTraceToString(e));
                     e.printStackTrace();
                     try{
                        Thread.sleep(Constants.VISAFileProcTaskInterval);
                     }catch(InterruptedException ie){e.printStackTrace();}
                }

               files=new String[0];
                
               try{ 
                   clt.chdir(prop.getProperty("rod.prepaid.VISAFile.dir"));
                   files=clt.dir();
                   Constants.logger.debug("found files="+files.length);
                   clt.quit();
                   clt=null;
                   biz=null;    

                   Thread.sleep(Constants.VISAFileProcTaskInterval);                                      
               }catch(Exception e){
            	   e.printStackTrace();
                     Constants.logger.debug(Utils.stackTraceToString(e));
                     try{
                        Thread.sleep(Constants.VISAFileProcTaskInterval);
                     }catch(InterruptedException ie){ie.printStackTrace();}                       
               }   
            }//Close While
    }

    private Collection parseString(BufferedReader br) throws Exception {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Collection result=new ArrayList();
        String buf;
        try
        {
            while((buf=br.readLine())!=null)
            {
                try
                {
                	if(buf.contains(",")){ //if contains , then it is CSV file
                		 PrepaidVISAFileVO pvf=new PrepaidVISAFileVO();
                		 String tempVISA[]= buf.split(",");
                		 pvf.setAwbNbr(tempVISA[0]);
                         pvf.setOrigLocation(tempVISA[1]);
                         pvf.setOrigCountry(tempVISA[2]);
                         pvf.setShipDate(sdf.parse(tempVISA[3]));
                         try{
                             pvf.setProduct(Integer.parseInt(tempVISA[4]));
                         }catch(Exception e){
                             pvf.setProduct(0);
                         }         
                         
                         try{
                        	 pvf.setNumberPkgs(Integer.parseInt(tempVISA[5]));
                         }catch(Exception e){
                             pvf.setNumberPkgs(0);
                         }  
                         
                         try{
                        	 pvf.setWeight(Double.parseDouble(tempVISA[6]));
                         }catch(Exception e){
                             pvf.setWeight(0);
                         }  
                                                 
                         result.add(pvf);        
                	}else{
                    //if("X".equalsIgnoreCase(buf.substring(71,72).trim())){ //<---- GCCS 3.3 - BR2.11.52945.1.003
                        PrepaidVISAFileVO pvf=new PrepaidVISAFileVO();
                        pvf.setAwbNbr(buf.substring(0,12).trim());
                        pvf.setOrigLocation(buf.substring(13,18).trim());
                        pvf.setOrigCountry(buf.substring(43,45).trim());
                        pvf.setShipDate(sdf.parse(buf.substring(34,42).trim()));
                        try{
                            pvf.setProduct(Integer.parseInt(buf.substring(51,53).trim()));
                        }catch(Exception e){
                            pvf.setProduct(0);
                        }                        
                        pvf.setNumberPkgs(Integer.parseInt(buf.substring(54,62).trim()));
                        pvf.setWeight(Double.parseDouble(buf.substring(63,70).trim()));
                        result.add(pvf);            
                    }//end if
                }
                catch(Exception e)
                {
                    Constants.logger.debug("Error parsing VISA File:\n"+Utils.stackTraceToString(e));
                    throw e;
                }
            }
        }
        catch(Exception e)
        {
            Constants.logger.debug("Fatal Error parsing VISA File:\n"+Utils.stackTraceToString(e));

            throw e;
        }

        return result;
    }  
    
    /** Getter for property prop.
     * @return Value of property prop.
     */
    public ServletContext getServletCtx() {
        return this.servletCtx;
    }    

    /** Setter for property prop.
     * @param
     *  
     */
    public void setServletCtx(ServletContext servletCtx) {
        this.servletCtx = servletCtx;
    }
    
    /** Getter for property thread.
     * @return Value of property thread.
     */
    public java.lang.Thread getThread() {
        return this.thread;
    }
    
    /** Setter for property thread.
     * @param thread New value of property thread.
     */
    public void setThread(java.lang.Thread thread) {
        this.thread = thread;
    }

    private void notifyError(String fileNm, String errorMessage){
    	try{
    		AdminBizDelegate adminBiz=new AdminBizDelegate();

            //Notify to Admins
            Iterator admins=adminBiz.getAdminEmployees(null).iterator();
    		String to="";
            String bodyMessage;

            while(admins.hasNext()){
    			EmployeeVO evo=(EmployeeVO)admins.next();
                if(evo.getEmail()!=null){
    			    to=to+evo.getEmail()+",";
                }
    		}

            EmailSender1 es=new EmailSender1();
    		HashMap hm=new HashMap();
    		hm.put("TO:",to);
    		hm.put("Subject:","VISA IMPORT FILE");
            bodyMessage="An exception ocurred in importing the visa file to GCCS. File Name: " + fileNm + "\n\n" +
                        "Please check this problem.\n\n CashControl System. \n\n Exception Details: \n" +
                        errorMessage;
            hm.put("Body:",bodyMessage);

            es.setEmails(hm);
            es.send();
    	}catch(Exception e){
    		Constants.logger.debug("Exception ocurred in notifyError() method from ProcessVISAFileRunnable: \n"+Utils.stackTraceToString(e));
    	}
    }
}
