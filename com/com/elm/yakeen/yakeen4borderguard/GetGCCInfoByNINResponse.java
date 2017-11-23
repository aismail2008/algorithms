
package com.elm.yakeen.yakeen4borderguard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getGCCInfoByNINResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getGCCInfoByNINResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GCCInfoByNINResult" type="{http://yakeen4borderguard.yakeen.elm.com/}gccInfoByNINResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getGCCInfoByNINResponse", propOrder = {
    "gccInfoByNINResult"
})
public class GetGCCInfoByNINResponse {

    @XmlElement(name = "GCCInfoByNINResult")
    protected GccInfoByNINResult gccInfoByNINResult;

    /**
     * Gets the value of the gccInfoByNINResult property.
     * 
     * @return
     *     possible object is
     *     {@link GccInfoByNINResult }
     *     
     */
    public GccInfoByNINResult getGCCInfoByNINResult() {
        return gccInfoByNINResult;
    }

    /**
     * Sets the value of the gccInfoByNINResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GccInfoByNINResult }
     *     
     */
    public void setGCCInfoByNINResult(GccInfoByNINResult value) {
        this.gccInfoByNINResult = value;
    }

}
