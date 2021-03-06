package com.fedex.lacitd.cashcontrol.biztier.facades;

import com.fedex.lacitd.cashcontrol.biztier.common.Constants;
import com.fedex.lacitd.cashcontrol.biztier.common.CreditCardPymtTableVO;
import com.fedex.lacitd.cashcontrol.biztier.common.DepositSlipTableVO;
import com.fedex.lacitd.cashcontrol.biztier.exception.FacadeException;
import com.fedex.lacitd.cashcontrol.datatier.common.ServiceLocator;
//import com.fedex.lacitd.cashcontrol.common.ServiceLocator;

import com.fedex.lacitd.cashcontrol.datatier.controller.*;
import com.fedex.lacitd.cashcontrol.datatier.dao.CommonOpsDaoLocal;
import com.fedex.lacitd.cashcontrol.datatier.dao.CommonOpsDaoLocalHome;
import com.fedex.lacitd.cashcontrol.datatier.entities.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.ServiceLocatorException;
import com.fedex.lacitd.cashcontrol.datatier.valueobject.*;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * Created 18/11/2003 15:58:50
 * Code generated by the Sun ONE Studio EJB Builder
 *
 * @author ccardenas
 */

public class CommonOpsFacadeBean implements javax.ejb.SessionBean {

    private javax.ejb.SessionContext context;

    /**
     * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
     */
    public void setSessionContext(javax.ejb.SessionContext aContext) {
        context = aContext;
    }


    /**
     * @see javax.ejb.SessionBean#ejbActivate()
     */
    public void ejbActivate() {

    }


    /**
     * @see javax.ejb.SessionBean#ejbPassivate()
     */
    public void ejbPassivate() {

    }


    /**
     * @see javax.ejb.SessionBean#ejbRemove()
     */
    public void ejbRemove() {

    }


    /**
     * See section 7.10.3 of the EJB 2.0 specification
     */
    public void ejbCreate() {

    }

    private BankAccLocalHome getBankAccLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (BankAccLocalHome) service.getEJBLocalHome("BankAccEJB.BankAccLocalHome");
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getBankAccLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    public void addCCBatchComment(int ccpId, String newComment) throws FacadeException {
        try {
            CreditCardPaymentController ccCon = new CreditCardPaymentController();
            CreditCardPaymentVO ccVO = ccCon.getCreditCardPayment(new Integer(ccpId));

            ccVO.setComments((ccVO.getComments() == null ? "" : ccVO.getComments()) + newComment);
            ccCon.updateCreditCardPayment(ccVO);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in addCCBatchComment() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public java.util.Collection getCreditCardPaymentsBatchs(String locationCodePk) throws FacadeException {
        try {
            return getCommonOpsDaoLocal().getCreditCardPaymentsBatchs(locationCodePk);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCreditCardPaymentsBatchs() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public int existsEmployeeLocation(String loc, String emp) throws FacadeException {
        try {
            return getCommonOpsDaoLocal().existsEmployeeLocation(loc, emp);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in existsEmployeeLocation() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void addDepositSlipComment(int depSlipId, String newComment) throws FacadeException {
        try {
            DepositSlipController depCon = new DepositSlipController();
            DepositSlipVO depVO = depCon.getDepositSlip(new Integer(depSlipId));

            depVO.setComments((depVO.getComments() == null ? "" : depVO.getComments()) + newComment);
            depCon.updateDepositSlip(depVO);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in addDepositSlipComment() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public boolean closeCouriers(String checkInEmpCodePk, String locationCodePk, Collection employeeSummaries) throws FacadeException {
        try {
            boolean allOk = true;
            CommonOpsDaoLocal dao = getCommonOpsDaoLocal();
            Iterator iterEmp = employeeSummaries.iterator();
            while (iterEmp.hasNext()) {
                String ec = (String) iterEmp.next();

                if (!dao.closeCourier(checkInEmpCodePk, locationCodePk, ec)) {
                    allOk = false;
                }
            }
            return allOk;
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in closeCouriers() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public java.util.Collection getBankAccByLocation(String locationCodePk) throws FacadeException {
        try {
            return getCommonOpsDaoLocal().getBankAccByLocation(locationCodePk);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getBankAccByLocation() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getEmployeesWithPayments(String location) throws FacadeException {
        try {
            return getCommonOpsDaoLocal().getEmployeesWithPayments(location);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getEmployeesWithPayments() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public java.util.Hashtable getDepositSlipReport(String locationCodePk, Integer pageNumber) throws FacadeException {
        try {
            return getCommonOpsDaoLocal().getDepositSlipReport(locationCodePk, pageNumber);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getDepositSlipReport() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    private DepositSlipLocalHome getDepositSlipLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (DepositSlipLocalHome) service.getEJBLocalHome("DepositSlipEJB.DepositSlipLocalHome");
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getDepositSlipLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    private EmployeeLocalHome getEmployeeLocalHome() {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            return (EmployeeLocalHome) service.getEJBLocalHome("EmployeeEJB.EmployeeLocalHome");
        }
        catch (ServiceLocatorException ex) {
            String errorMsg = "Error occurred in getEmployeeLocalHome() method when lookup the local home interface";
            throw new EJBException(errorMsg, ex);
        }
    }

    public Collection getPaymentsSummaryByEmp(String location) throws FacadeException {
        try {
            return getCommonOpsDaoLocal().getPaymentsSummaryByEmp(location);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getPaymentsSummaryByEmp() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public int processEndOfDay(String locationCodePk, String employeeCodePk) throws FacadeException {
        try {
            return getCommonOpsDaoLocal().processEndOfDay(locationCodePk, employeeCodePk);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in processEndOfDay() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public int openEndOfDay(String locationCodePk, String employeeCodePk, int openDeposits) throws FacadeException {
        try {
            return getCommonOpsDaoLocal().openEndOfDay(locationCodePk, employeeCodePk, openDeposits);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in openEndOfDay() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void saveCCBatch(Collection ccb, java.lang.String employeeId, java.util.Date dt) throws FacadeException {
        try {
            Iterator iterCcb = ccb.iterator();
            CreditCardPaymentController ccbCon = new CreditCardPaymentController();
            while (iterCcb.hasNext()) {
                CreditCardPymtTableVO ccbChangesVO = (CreditCardPymtTableVO) iterCcb.next();
                CreditCardPaymentVO ccbVO = ccbCon.getCreditCardPayment(new Integer(ccbChangesVO.getCreditCardPymtId()));

                ccbVO.setEmployeeId(employeeId);
                ccbVO.setTotalReimbursed(ccbChangesVO.getTotalReimbursed());
                ccbVO.setPaymentDocNbr(ccbChangesVO.getPaymentDocNbr());
                ccbVO.setStatusId(ccbChangesVO.getStatusId());

                if (ccbVO.getStatusId() == 1) {
                    ccbVO.setDepositSlipId(createDepoSlipCredCardBatch(ccbVO, employeeId, dt));
                }

                ccbCon.updateCreditCardPayment(ccbVO);

            }
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in saveCCBatch() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void saveDepositSlip(Collection depos, java.lang.String employeeId) throws FacadeException {
        try {
            Iterator iterDepos = depos.iterator();
            DepositSlipController depCon = new DepositSlipController();
            while (iterDepos.hasNext()) {
                DepositSlipTableVO depChangesVO = (DepositSlipTableVO) iterDepos.next();
                DepositSlipVO depVO = depCon.getDepositSlip(new Integer(depChangesVO.getDepositSlipCd()));

                depVO.setEmployeeId(employeeId);
                depVO.setBankAccountCd(new Integer(depChangesVO.getBankAccountCd()));
                depVO.setActualAmt(depChangesVO.getActualAmt());
                depVO.setBankAmt(depChangesVO.getBankAmt());
                depVO.setDepositSlipNbr(depChangesVO.getDepositSlipNbr());
                depVO.setStatusId(depChangesVO.getStatusId());
                depVO.setCloseDt(depChangesVO.getCloseDt());
                depVO.setDepoDt(depChangesVO.getDepoDt());
                depVO.setBankDepoDt(depChangesVO.getBankDepoDt());

                depCon.updateDepositSlip(depVO);
            }
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in saveDepositSlip() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    private int createDepoSlipCredCardBatch(CreditCardPaymentVO ccbVO, String empId, java.util.Date dt) throws FacadeException {
        try {
            LocationVO lVO = new LocationController().getLocation(ccbVO.getLocationCd());

            DepositSlipLocal local = null;

            if ("CHK".equals(ccbVO.getPaymentType())) {
                local = getDepositSlipLocalHome().create(
                        dt,
                        null,
                        ccbVO.getTotalReimbursed(),
                        getBankAccLocalHome().findByPrimaryKey(new Integer(lVO.getLocalDefaultAcc())),
                        getEmployeeLocalHome().findByPrimaryKey(empId),
                        ccbVO.getCurrencyCd(),
                        "CCARD",
                        1,
                        ccbVO.getLocationCd(),
                        0,
                        null,
                        ccbVO.getTotalReimbursed(),
                        0,
                        null,
                        null,
                        null,
                        null,
                        ccbVO.getEodId(),
                        0,
                        ""
                );
            } else {
                local = getDepositSlipLocalHome().create(
                        dt,
                        null,
                        ccbVO.getTotalReimbursed(),
                        getBankAccLocalHome().findByPrimaryKey(new Integer(lVO.getLocalDefaultAcc())),
                        getEmployeeLocalHome().findByPrimaryKey(empId),
                        ccbVO.getCurrencyCd(),
                        "EFT",
                        2,
                        ccbVO.getLocationCd(),
                        1,
                        null,
                        ccbVO.getTotalReimbursed(),
                        ccbVO.getTotalReimbursed(),
                        null,
                        dt,
                        dt,
                        dt,
                        ccbVO.getEodId(),
                        0,
                        ""
                );

            }

            getCommonOpsDaoLocal().assignBankReference(local.getDepositSlipCd().intValue());

            return local.getDepositSlipCd().intValue();

        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in createDepoSlipCredCardBatch() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    private CommonOpsDaoLocal getCommonOpsDaoLocal() throws ServiceLocatorException, CreateException {
        CommonOpsDaoLocalHome daoHome = (CommonOpsDaoLocalHome) ServiceLocator.getInstance().getEJBLocalHome(Constants.CommonOpsDaoEJB_Local);
        CommonOpsDaoLocal dao = daoHome.create();
        return dao;
    }

    public java.util.Collection saveDepTempl(DepTemplVO templVO, java.lang.String[] locs, java.lang.Integer[] paymentTypes) throws FacadeException {
        try {
            DepTemplController dtc = new DepTemplController();
            if (templVO != null && templVO.getTemplId() != null && templVO.getTemplId().intValue() != 0) {
                DepTemplVO fromDB = dtc.getDepTempl(templVO.getTemplId());
                fromDB.setTemplCd(templVO.getTemplCd());
                fromDB.setTemplDesc(templVO.getTemplDesc());
                fromDB.setCntRod(templVO.getCntRod());
                fromDB.setCntPrepaid(templVO.getCntPrepaid());
                fromDB.setCntPoa(templVO.getCntPoa());
                fromDB.setCntOther(templVO.getCntOther());
                fromDB.setCntGrnd(templVO.getCntGrnd());
                fromDB.setCntCod(templVO.getCntCod());
                fromDB.setCntFtc(templVO.getCntFtc());
                fromDB.setCurrencyType(templVO.getCurrencyType());
                fromDB.setCrcdReimbTypeCd(templVO.getCrcdReimbTypeCd());
                dtc.updateDepTempl(fromDB);
            } else {
                if (templVO != null) {
                    String curr = templVO.getCurrencyType();
                    templVO.setCurrencyType("LOCAL".equals(curr) || "USD".equals(curr) ? curr : null);
                    dtc.setDepTempl(templVO);
                    templVO = (DepTemplVO) dtc.getDepTemplDepTemplsbyCode(templVO.getTemplCd()).toArray()[0];
                }
            }

            Constants.logger.debug("\n **** templVO.getDepTemplPK() => " + templVO.getDepTemplPK());
            Integer templId = templVO.getTemplId();

            Iterator iterAnt = dtc.getLocations(templId).iterator();
            while (iterAnt.hasNext()) { //DELETING PRIOR LOCATIONS
                dtc.removeLocation(templId, ((LocationVO) iterAnt.next()).getLocationCd());
            }

            if (locs != null) {
                for (int i = 0; i < locs.length; i++) {
                    dtc.addLocation(templId, (String) locs[i]);
                }
            }

            Iterator iterAntPT = dtc.getPaymentTypes(templId).iterator();
            while (iterAntPT.hasNext()) { //DELETING PRIOR PAYMENT TYPES
                dtc.removePaymentType(templId, ((PaymentTypeVO) iterAntPT.next()).getPaymentTypeId());
            }

            for (int i = 0; i < paymentTypes.length; i++) {
                dtc.addPaymentType(templId, paymentTypes[i]);
            }

            Collection colErrors = getCommonOpsDaoLocal().validateTemplOverlaps(templId);
            Constants.logger.debug("\n **** colErrors size => " + colErrors.size());

            if (!colErrors.isEmpty()) context.setRollbackOnly();//SI HAY ERRORES......

            return colErrors;
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in saveDepTempl() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getExternalFilesImportingStatus(String empId) throws FacadeException {
        try {
            return getCommonOpsDaoLocal().getExternalFilesImportingStatus(empId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getExternalFilesImportingStatus() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void markWriteOff() throws FacadeException {
        try {
            getCommonOpsDaoLocal().markWriteOff();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in markWriteOff() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getDailyDtrcUpload(int dayOffSet) throws FacadeException {
        try {
            return getCommonOpsDaoLocal().getDailyDtrcUpload(dayOffSet);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getDailyDtrcUpload() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }


    public void saveErrorsPymtImpt(PymtImptLogVO plVO, Collection errorsDetail) throws FacadeException {
        try {
            ServiceLocator service = ServiceLocator.getInstance();
            //Get Home Interface
            PymtImptLogLocalHome plh = (PymtImptLogLocalHome) service.getEJBLocalHome("PymtImptLogEJB.PymtImptLogLocalHome");

            //Create and get local remote interface
            PymtImptLogLocal pll = plh.create(plVO.getImptFileNm(), plVO.getImptDt(), plVO.getLocationCd(), plVO.getStatusCd(), plVO.getMessage());

            //Now save detail if there is details
            if (errorsDetail.size() > 0) {
                PymtImptErrorDtlVO pied = null;
                PymtImptErrorDtlLocalHome piedLocalHome = (PymtImptErrorDtlLocalHome) service.getEJBLocalHome("PymtImptErrorDtlEJB.PymtImptErrorDtlLocalHome");
                Iterator it = errorsDetail.iterator();
                while (it.hasNext()) {
                    pied = (PymtImptErrorDtlVO) it.next();
                    PymtImptErrorDtlLocal bean = piedLocalHome.create(pied.getImptMessageDtl(), pied.getImptError(), pll);
                }
            }

        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in saveErrorsPymtImpt(PymtImptLogVO plVO, Collection errorsDetail) method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public PymtImptLogVO getImportingExternalLog(Integer logId) throws FacadeException {
        try {
            PymtImptLogController plc = new PymtImptLogController();
            return plc.getPymtImptLog(logId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getImportingExternalLog(Integer logId) method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void reassignPayments(String oldEmployee, String newEmployee, String oldLocation, String newLocation, String reassEmployee, boolean moveRec, boolean movePrep, boolean movePoa, boolean moveGrn) throws FacadeException {
        try {
            getCommonOpsDaoLocal().reassignPayments(oldEmployee, newEmployee, oldLocation, newLocation, reassEmployee, moveRec, movePrep, movePoa, moveGrn);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in reassignPayments(java.lang.String countryCd) method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getImportingExternalLogDetailsByLogId(Integer logId) throws FacadeException {
        try {
            PymtImptLogController plc = new PymtImptLogController();
            return plc.getPymtImptErrorDtls(logId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getImportingExternalLogDetailsByLogId(Integer logId) method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getComments(java.lang.String countryCd) throws FacadeException {
        try {
            return getCommonOpsDaoLocal().getComments(countryCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getComments(java.lang.String countryCd) method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getLocationCdByCountry(java.lang.String countryCd) throws FacadeException {
        try {
            Iterator iterLocs = new LocationController().getLocationByCountryCd(countryCd).iterator();
            Collection locCds = new ArrayList();

            while (iterLocs.hasNext()) {
                locCds.add(((LocationVO) iterLocs.next()).getLocationCd());
            }
            return locCds;
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getComments(java.lang.String countryCd) method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void openSpecificEndOfDay(String locationCd, String eodId) throws FacadeException {
        try {
            getCommonOpsDaoLocal().openSpecificEndOfDay(locationCd, eodId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in openSpecificEndOfDay() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void changePaymentsDate(String locationCd, String eodId, String toDt) throws FacadeException {
        try {
            getCommonOpsDaoLocal().changePaymentsDate(locationCd, eodId, toDt);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in changePaymentsDate() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void changeDepoPaymentsDate(String locationCd, int depoId, String dt) throws FacadeException {
        try {
            getCommonOpsDaoLocal().changeDepoPaymentsDate(locationCd, depoId, dt);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in changeDepoPaymentsDate() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getBatchesToAdmin(String locationCd, Date startDt, Date endDt) throws FacadeException {
        try {
            return getCommonOpsDaoLocal().getBatchesToAdmin(locationCd, startDt, endDt);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getBatchesToAdmin() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }


    public void quickClear(String locationCd) throws FacadeException {
        try {
            getCommonOpsDaoLocal().quickClear(locationCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in quickClear() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void quickCollectLaters(String locationCd) throws FacadeException {
        try {
            getCommonOpsDaoLocal().quickCollectLaters(locationCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in quickCollectLaters() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void moveToSYDX() throws FacadeException {
        try {
            getCommonOpsDaoLocal().moveToSYDX();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in moveToSYDX() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public int getSplitCountTable(String locationCd, String courier, String operation) throws FacadeException {
        try {
            return getCommonOpsDaoLocal().getSplitCountTable(locationCd, courier, operation);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getSplitCountTable(String locationCd, String courier, String operation) method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getMorePaymentsSummaryByEmp(String locationCd) throws FacadeException {
        try {
            return getCommonOpsDaoLocal().getMorePaymentsSummaryByEmp(locationCd);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getMorePaymentsSummaryByEmp(String locationCd) method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public java.util.HashMap getCreditCardPymt(String entityCd, Date startDate, Date endDate) throws FacadeException {
        try {
            return getCommonOpsDaoLocal().getCreditCardPymt(entityCd, startDate, endDate);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getCreditCardPymt() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public void saveCreditCardPymtLog(String employeeId, String entityCd, String locationCd, String startDateTxt, String endDateTxt) throws FacadeException {
        try {
            getCommonOpsDaoLocal().saveCreditCardPymtLog(employeeId, entityCd, locationCd, startDateTxt, endDateTxt);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in saveCreditCardPymtLog() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }

    }

    public Collection getEntities() throws FacadeException {
        try {
            return getCommonOpsDaoLocal().getEntities();
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getEntities() method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }

    public Collection getEntities(String employeeId) throws FacadeException {
        try {
            return getCommonOpsDaoLocal().getEntities(employeeId);
        } catch (Exception e) {
            String errorMsg = e.getClass().getName() + " occurred in getEntities(" + employeeId + ") method from CommonOpsFacadeBean class";
            throw new FacadeException(errorMsg, e);
        }
    }


}//Close CommonOpsFacadeBean class
