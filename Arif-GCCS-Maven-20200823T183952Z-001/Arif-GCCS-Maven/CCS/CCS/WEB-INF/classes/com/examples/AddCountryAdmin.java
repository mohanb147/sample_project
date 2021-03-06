/**
 * Created on Nov 12, 2004
 *
 */
package com.examples;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Properties;

import javax.naming.*;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.EmployeeProfile;
import com.fedex.lacitd.cashcontrol.common.Utils;
import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;
import com.fedex.lacitd.cashcontrol.biztier.bizdelegates.*;
import com.fedex.lacitd.cashcontrol.biztier.facades.*;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.CountryVO;
import com.fedex.lacitd.cashcontrol.prestier.helper.CountryToCompare;

/**
 * @author arturog
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AddCountryAdmin {

    public static void main(String[] args) {
        
        String employeeId = "488838";
        
        AdminFacade admin = null;
        Connection conn=null;
        ResultSet res = null;
        Collection paises=null;
        PreparedStatement cs=null;
        ResultSet rs=null;
        Properties prop=new Properties();
		prop.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
		//prop.put(Context.PROVIDER_URL, "t3://161.135.40.171:9999"); 
		prop.put(Context.PROVIDER_URL, "t3://lac-miawl01.corp.fedex.com:7020");
		        
		try{
            InitialContext c=new InitialContext(prop);
            DataSource ds=(DataSource)c.lookup("jdbc/CashControlDS");
            
            AdminFacadeHome adHome = (AdminFacadeHome)c.lookup(Constants.AdminFacadeEJB_Remote);
            admin = adHome.create();
            
            conn=ds.getConnection();
            
            //AdminBizDelegate abd = new AdminBizDelegate();
            
              paises = checkCountries(admin);
            
		}catch(Exception e)
		  {	   
			Constants.logger.debug(Utils.stackTraceToString(e));
		}
		  
			ArrayList  locations = null;
			Iterator paIt = paises.iterator();
			String country = null;
			
			try{
			    while(paIt.hasNext())
			    {   country		= ((CountryVO)paIt.next()).getCountryCd();
                	String  loc = null;
                	//System.out.println("\n Nro. Countries  = " + paises.size());
                	Constants.logger.debug("\n Nro. Countries  = " + paises.size());
                	
                	if(!"FF".equals(country))
                	{	Constants.logger.debug("\n Pais = " + country);
                		
                		cs = conn.prepareStatement("select min(e.loc_cd) from employee_location e, location l, country c " +
                		             				"where e.loc_cd=l.loc_cd and " +
                		                			"      l.cntry_cd=c.cntry_cd and " +
                		                			"      c.cntry_cd=? and " +
                		                			"      emp_id_nbr=?");
                		    	
                		cs.setString(1,country);
                		cs.setString(2,employeeId);
                		
                		rs=cs.executeQuery();
                		
                		rs.next();
                		
                		loc = rs.getString(1);
                		    
                		Constants.logger.debug("\n loc antes de insertar = " + loc);
                	
                			if(loc!=null && loc.trim().length()>0)
                			{  try{	
                				Constants.logger.debug("\n Voy a insertar con loc  = " + loc);
                		    		cs=conn.prepareStatement("INSERT INTO EMP_X_LOCATION_X_ROLE (role_id_nbr,loc_cd,emp_id_nbr) VALUES(?,?,?)");
                		    		cs.setInt(1,7);
                		    		cs.setString(2,loc);
                		    		cs.setString(3,employeeId);
                		    		cs.execute();
                				}catch(SQLException sqle){
                					Constants.logger.debug(Utils.stackTraceToString(sqle));
                				    continue;
                				}
                			}
                	}		
			    }
			}catch(Exception e)
			{	   Constants.logger.debug(Utils.stackTraceToString(e));
			}finally
				{ try{
				    cs.close();
				  }catch(Exception e){}
				  try{
				      conn.close();
				  }catch(Exception e){}
				}
			
    }
    
    /**
     * Method to check that the country list exist in the Session
     * @param request
     */
    public static Collection checkCountries(AdminFacade admin) 
    {	Collection countries = null;
    	AdminBizDelegate abd = new AdminBizDelegate();
        try{
            
	           countries = admin.getAllCountry();
        	
	           ArrayList countr=new ArrayList();
	           int large = 0;
	           if(countries.size()>0)
	           {  
	        	  
	        	   ArrayList<CountryVO> countryList = (ArrayList<CountryVO>)countries;
                   for (int i = 0; i < countryList.size(); i++) {
                 	  CountryVO con = countryList.get(i);
                 	  if(con.getCountryNm()!=null)
                       {   large = con.getCountryNm().length();
                          if(large>14)
                             con.setCountryNm(con.getCountryNm().substring(0, 13));
                       }else
                           con.setCountryNm("");

                       CountryToCompare comp = new CountryToCompare();
                       Collections.sort((ArrayList)countries, comp);
                     } 
	        	   
	        	  /* 
	              Iterator itCont = countries.iterator();
	              while(itCont.hasNext())
	              { CountryVO con=(CountryVO)itCont.next();
	                if(con.getCountryNm()!=null)
	                {   large = con.getCountryNm().length();
	                   if(large>14)
	                      con.setCountryNm(con.getCountryNm().substring(0, 13));
	                }else
	                    con.setCountryNm("");
	
	                CountryToCompare comp = new CountryToCompare();
	                Collections.sort((ArrayList)countries, comp);
	              }
	              */
	           }
	    }catch(Exception e)
	     {Constants.logger.debug(Utils.stackTraceToString(e));
	     }
	    return countries;
    }
}
