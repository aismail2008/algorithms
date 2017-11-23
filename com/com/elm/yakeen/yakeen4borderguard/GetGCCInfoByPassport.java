
package com.elm.yakeen.yakeen4borderguard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getGCCInfoByPassport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getGCCInfoByPassport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GCCInfoByPassportRequest" type="{http://yakeen4borderguard.yakeen.elm.com/}gccInfoByPassportRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getGCCInfoByPassport", propOrder = {
    "gccInfoByPassportRequest"
})
public class GetGCCInfoByPassport {

    @XmlElement(name = "GCCInfoByPassportRequest")
    protected GccInfoByPassportRequest gccInfoByPassportRequest;

    /**
     * Gets the value of the gccInfoByPassportRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GccInfoByPassportRequest }
     *     
     */
    public GccInfoByPassportRequest getGCCInfoByPassportRequest() {
        return gccInfoByPassportRequest;
    }

    /**
     * Sets the value of the gccInfoByPassportRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GccInfoByPassportRequest }
     *     
     */
    public void setGCCInfoByPassportRequest(GccInfoByPassportRequest value) {
        this.gccInfoByPassportRequest = value;
    }

}
