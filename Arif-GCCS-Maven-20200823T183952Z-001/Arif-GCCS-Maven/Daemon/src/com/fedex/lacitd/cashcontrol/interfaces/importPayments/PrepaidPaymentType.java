//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.2-b15-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.08.02 at 12:04:00 VET 
//


package com.fedex.lacitd.cashcontrol.interfaces.importPayments;


/**
 * Java content class for anonymous complex type.
 * <p>The following schema fragment specifies the expected content contained within this java content object. (defined at file:/C:/jwsdp-1.3/jaxb/bin/DataFeedOut.xsd line 87)
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}awb" minOccurs="0"/>
 *         &lt;element ref="{}awb_dt" minOccurs="0"/>
 *         &lt;element ref="{}courier_id" minOccurs="0"/>
 *         &lt;element ref="{}cust_name" minOccurs="0"/>
 *         &lt;element ref="{}chk_agent_id" minOccurs="0"/>
 *         &lt;element ref="{}pymt_dt" minOccurs="0"/>
 *         &lt;element ref="{}pymt_tot_amt" minOccurs="0"/>
 *         &lt;element ref="{}pymt_cash_amt" minOccurs="0"/>
 *         &lt;element ref="{}pymt_doc_amt" minOccurs="0"/>
 *         &lt;element ref="{}pymt_doc_nbr" minOccurs="0"/>
 *         &lt;element ref="{}pymt_doc_type" minOccurs="0"/>
 *         &lt;element ref="{}pymt_curr_cd" minOccurs="0"/>
 *         &lt;element ref="{}exch_rate" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="num" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 */
public interface PrepaidPaymentType {


    /**
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getAwb();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setAwb(java.lang.String value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigDecimal}
     */
    java.math.BigDecimal getPymtDocAmt();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.math.BigDecimal}
     */
    void setPymtDocAmt(java.math.BigDecimal value);

    /**
     * 
     */
    int getCourierId();

    /**
     * 
     */
    void setCourierId(int value);

    /**
     * 
     */
    int getChkAgentId();

    /**
     * 
     */
    void setChkAgentId(int value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.util.Calendar}
     */
    java.util.Calendar getPymtDt();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.util.Calendar}
     */
    void setPymtDt(java.util.Calendar value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigDecimal}
     */
    java.math.BigDecimal getPymtCashAmt();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.math.BigDecimal}
     */
    void setPymtCashAmt(java.math.BigDecimal value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.util.Calendar}
     */
    java.util.Calendar getAwbDt();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.util.Calendar}
     */
    void setAwbDt(java.util.Calendar value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getCustName();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setCustName(java.lang.String value);

    /**
     * 
     */
    int getPymtDocType();

    /**
     * 
     */
    void setPymtDocType(int value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getPymtDocNbr();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setPymtDocNbr(java.lang.String value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigDecimal}
     */
    java.math.BigDecimal getPymtTotAmt();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.math.BigDecimal}
     */
    void setPymtTotAmt(java.math.BigDecimal value);

    /**
     * 
     */
    int getNum();

    /**
     * 
     */
    void setNum(int value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String}
     */
    java.lang.String getPymtCurrCd();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    void setPymtCurrCd(java.lang.String value);

    /**
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigDecimal}
     */
    java.math.BigDecimal getExchRate();

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link java.math.BigDecimal}
     */
    void setExchRate(java.math.BigDecimal value);

}
