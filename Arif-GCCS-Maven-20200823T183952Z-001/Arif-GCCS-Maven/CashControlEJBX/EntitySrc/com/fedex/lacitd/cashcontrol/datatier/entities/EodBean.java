/**
 * @(#)EodBean.java			Tue Aug 02 15:38:50 VET 2005
 * 
 * FedEx
 * Cash Control
 * 
 * FedEx
 * Santiago, Chile
 * 
 * Copyright (c) 2001 FedEx, All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of FedEx. ("Confidential Information").
 * 
 * Visit our website at http://www.fedex.com for more information
 * 
 * This bean map to the eod table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class EodBean implements EntityBean {

    private EntityContext _ctx;
    public EodBean() {
    }
    /**
     * Set the value of eodId
     * @param eodId - Integer of eodId
     */
    public abstract void setEodId(Integer eodId);

    /**
     * Get the value of eodId
     * @return eodId - Integer of eodId
     */
    public abstract Integer getEodId();

    /**
     * Set the value of locationCd
     * @param locationCd - String of locationCd
     */
    public abstract void setLocationCd(String locationCd);

    /**
     * Get the value of locationCd
     * @return locationCd - String of locationCd
     */
    public abstract String getLocationCd();

    /**
     * Set the value of eodDt
     * @param eodDt - Date of eodDt
     */
    public abstract void setEodDt(Date eodDt);

    /**
     * Get the value of eodDt
     * @return eodDt - Date of eodDt
     */
    public abstract Date getEodDt();

    /**
     * Set the value of employeeId
     * @param employeeId - String of employeeId
     */
    public abstract void setEmployeeId(String employeeId);

    /**
     * Get the value of employeeId
     * @return employeeId - String of employeeId
     */
    public abstract String getEmployeeId();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(String locationCd, Date eodDt, String employeeId)
        throws CreateException {
        setLocationCd(locationCd);
        setEodDt(eodDt);
        setEmployeeId(employeeId);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(String locationCd, Date eodDt, String employeeId)
        throws CreateException {
    }

    /**
     * Called by Container.  Associates this Bean instance with a particular context environment.
     */
    public void setEntityContext(EntityContext ctx) {
        _ctx = ctx;
    }

    /**
     * Called by Container.  Disassociates this Bean instance with a particular 
     * context.  Once done, we can query the Context for environment information
     */
    public void unsetEntityContext() {
        _ctx = null;
    }

    /**
     * Called by Container.  Implementation can acquire needed resources
     */
    public void ejbActivate() {
    }

    /**
     * Called by Container.  Releases held resources for passivation
     */
    public void ejbPassivate() {
    }

    /**
     * Called by Container.  Updates the entity bean instance to reflect 
     * the current value stored in the database.
     */
    public void ejbLoad() {
    }

    /**
     * Called by Container.  Updates the database to reflect the current values 
     * of this in-memory Entity Bean instance representation.
     */
    public void ejbStore() {
    }

    /**
     * EJB Container calls this method right before it remove the Entity bean 
     * from the database.  Corresponds to when client calls home.remove().
     */
    public void ejbRemove() {
    }

}
