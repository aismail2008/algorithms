
package com.elm.yakeen.yakeen4borderguard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getGCCInfoByPassportResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getGCCInfoByPassportResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GCCInfoByPassportResult" type="{http://yakeen4borderguard.yakeen.elm.com/}gccInfoByPassportResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getGCCInfoByPassportResponse", propOrder = {
    "gccInfoByPassportResult"
})
public class GetGCCInfoByPassportResponse {

    @XmlElement(name = "GCCInfoByPassportResult")
    protected GccInfoByPassportResult gccInfoByPassportResult;

    /**
     * Gets the value of the gccInfoByPassportResult property.
     * 
     * @return
     *     possible object is
     *     {@link GccInfoByPassportResult }
     *     
     */
    public GccInfoByPassportResult getGCCInfoByPassportResult() {
        return gccInfoByPassportResult;
    }

    /**
     * Sets the value of the gccInfoByPassportResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GccInfoByPassportResult }
     *     
     */
    public void setGCCInfoByPassportResult(GccInfoByPassportResult value) {
        this.gccInfoByPassportResult = value;
    }

}
