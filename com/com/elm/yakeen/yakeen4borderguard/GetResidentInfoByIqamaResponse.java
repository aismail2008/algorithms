
package com.elm.yakeen.yakeen4borderguard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getResidentInfoByIqamaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getResidentInfoByIqamaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResidentInfoByIqamaResult" type="{http://yakeen4borderguard.yakeen.elm.com/}residentInfoByIqamaResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getResidentInfoByIqamaResponse", propOrder = {
    "residentInfoByIqamaResult"
})
public class GetResidentInfoByIqamaResponse {

    @XmlElement(name = "ResidentInfoByIqamaResult")
    protected ResidentInfoByIqamaResult residentInfoByIqamaResult;

    /**
     * Gets the value of the residentInfoByIqamaResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResidentInfoByIqamaResult }
     *     
     */
    public ResidentInfoByIqamaResult getResidentInfoByIqamaResult() {
        return residentInfoByIqamaResult;
    }

    /**
     * Sets the value of the residentInfoByIqamaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResidentInfoByIqamaResult }
     *     
     */
    public void setResidentInfoByIqamaResult(ResidentInfoByIqamaResult value) {
        this.residentInfoByIqamaResult = value;
    }

}
