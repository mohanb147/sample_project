//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.2-b15-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.06.03 at 04:46:07 CLT 
//


package com.fedex.lacitd.cashcontrol.interfaces.clearance;


/**
 * Java content class for recAmount element declaration.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/C:/Trabajo/CashControlWSP/CCS/CCS/schema/RODXML.xsd line 10)
 * <p>
 * <pre>
 * &lt;element name="recAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 * </pre>
 * 
 */
public interface RecAmount
    extends javax.xml.bind.Element
{


    /**
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigDecimal}
     */
    java.math.BigDecimal getValue();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.math.BigDecimal}
     */
    void setValue(java.math.BigDecimal value);

}
