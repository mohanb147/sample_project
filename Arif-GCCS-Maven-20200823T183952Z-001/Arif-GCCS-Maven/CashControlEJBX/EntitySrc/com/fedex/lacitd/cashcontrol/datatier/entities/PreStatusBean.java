/**
 * @(#)PreStatusBean.java			Tue Aug 02 15:38:50 VET 2005
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
 * This bean map to the pre_status table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import com.fedex.lacitd.cashcontrol.datatier.exception.*;
import java.util.*;
import javax.ejb.*;

public abstract class PreStatusBean implements EntityBean {

    private EntityContext _ctx;
    public PreStatusBean() {
    }
    /**
     * Set the value of statusIdNbr
     * @param statusIdNbr - Integer of statusIdNbr
     */
    public abstract void setStatusIdNbr(Integer statusIdNbr);

    /**
     * Get the value of statusIdNbr
     * @return statusIdNbr - Integer of statusIdNbr
     */
    public abstract Integer getStatusIdNbr();

    /**
     * Set the value of statusDesc
     * @param statusDesc - String of statusDesc
     */
    public abstract void setStatusDesc(String statusDesc);

    /**
     * Get the value of statusDesc
     * @return statusDesc - String of statusDesc
     */
    public abstract String getStatusDesc();

    /**
     * Set the value of prePgFlg
     * @param prePgFlg - int of prePgFlg
     */
    public abstract void setPrePgFlg(int prePgFlg);

    /**
     * Get the value of prePgFlg
     * @return prePgFlg - int of prePgFlg
     */
    public abstract int getPrePgFlg();

    /**
     * This is the initialization method that corresponds to the
     * create() method in the Home interface
     */
    public java.lang.Integer ejbCreate(Integer statusIdNbr, String statusDesc, int prePgFlg)
        throws CreateException {
        setStatusIdNbr(statusIdNbr);
        setStatusDesc(statusDesc);
        setPrePgFlg(prePgFlg);
        return null;
    }

    /**
     * Called after ejbCreate().  Now the Bean can retrieve its EJBObject from it context
     */
    public void ejbPostCreate(Integer statusIdNbr, String statusDesc, int prePgFlg)
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
