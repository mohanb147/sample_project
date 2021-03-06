/**
 * @(#)RodFileProcLogLocalHome.java			Tue Aug 02 15:38:49 VET 2005
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
 * This bean map to the rod_file_proc_log table
 * 
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.entities;

import com.fedex.lacitd.cashcontrol.datatier.common.*;
import java.util.*;
import javax.ejb.*;

public interface RodFileProcLogLocalHome extends EJBLocalHome {

    public RodFileProcLogLocal findByPrimaryKey(java.lang.Integer primaryKey)
        throws FinderException;

    public java.util.Collection findAllRodFileProcLogs()
        throws FinderException;

    public RodFileProcLogLocal create(String fileNm, String locationCd, Date processDt, int statusCd, String message, String errorDtlDesc, int awbQty, double totalLocalAmt, double totalUsdAmt)
        throws CreateException;

}
