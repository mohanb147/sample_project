/**
 * @(#)DepositSlipException.java			Tue Aug 02 15:38:54 VET 2005
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
 * @author		Cristian C?enas
 * @version		1.0
 */
package com.fedex.lacitd.cashcontrol.datatier.exception;


public class DepositSlipException extends com.fedex.lacitd.cashcontrol.datatier.exception.NestedException {

    public DepositSlipException(String message, Exception originatingException) {
        super(message, originatingException);
    }
}
