//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.2-b15-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.08.02 at 12:04:00 VET 
//


package com.fedex.lacitd.cashcontrol.interfaces.importPayments;


/**
 * Java content class for oac_payment element declaration.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/C:/jwsdp-1.3/jaxb/bin/DataFeedOut.xsd line 107)
 * <p>
 * <pre>
 * &lt;element name="oac_payment">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element ref="{}oac_dt" minOccurs="0"/>
 *           &lt;element ref="{}courier_id" minOccurs="0"/>
 *           &lt;element ref="{}pymt_dt" minOccurs="0"/>
 *           &lt;element ref="{}pymt_doc_amt" minOccurs="0"/>
 *           &lt;element ref="{}pymt_doc_nbr" minOccurs="0"/>
 *           &lt;element ref="{}pymt_doc_type" minOccurs="0"/>
 *           &lt;element ref="{}pymt_curr_cd" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;attribute name="num" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 */
public interface OacPayment
    extends javax.xml.bind.Element, com.fedex.lacitd.cashcontrol.interfaces.importPayments.OacPaymentType
{


}