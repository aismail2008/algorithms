
package com.elm.yakeen.yakeen4borderguard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCitizenInfoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCitizenInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CitizenInfoResult" type="{http://yakeen4borderguard.yakeen.elm.com/}citizenInfoResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCitizenInfoResponse", propOrder = {
    "citizenInfoResult"
})
public class GetCitizenInfoResponse {

    @XmlElement(name = "CitizenInfoResult")
    protected CitizenInfoResult citizenInfoResult;

    /**
     * Gets the value of the citizenInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link CitizenInfoResult }
     *     
     */
    public CitizenInfoResult getCitizenInfoResult() {
        return citizenInfoResult;
    }

    /**
     * Sets the value of the citizenInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CitizenInfoResult }
     *     
     */
    public void setCitizenInfoResult(CitizenInfoResult value) {
        this.citizenInfoResult = value;
    }

}
