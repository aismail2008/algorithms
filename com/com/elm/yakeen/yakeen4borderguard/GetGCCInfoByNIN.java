
package com.elm.yakeen.yakeen4borderguard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getGCCInfoByNIN complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getGCCInfoByNIN">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GCCInfoByNINRequest" type="{http://yakeen4borderguard.yakeen.elm.com/}gccInfoByNINRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getGCCInfoByNIN", propOrder = {
    "gccInfoByNINRequest"
})
public class GetGCCInfoByNIN {

    @XmlElement(name = "GCCInfoByNINRequest")
    protected GccInfoByNINRequest gccInfoByNINRequest;

    /**
     * Gets the value of the gccInfoByNINRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GccInfoByNINRequest }
     *     
     */
    public GccInfoByNINRequest getGCCInfoByNINRequest() {
        return gccInfoByNINRequest;
    }

    /**
     * Sets the value of the gccInfoByNINRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GccInfoByNINRequest }
     *     
     */
    public void setGCCInfoByNINRequest(GccInfoByNINRequest value) {
        this.gccInfoByNINRequest = value;
    }

}
