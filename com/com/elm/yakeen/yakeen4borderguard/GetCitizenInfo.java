
package com.elm.yakeen.yakeen4borderguard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCitizenInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCitizenInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CitizenInfoRequest" type="{http://yakeen4borderguard.yakeen.elm.com/}citizenInfoRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCitizenInfo", propOrder = {
    "citizenInfoRequest"
})
public class GetCitizenInfo {

    @XmlElement(name = "CitizenInfoRequest")
    protected CitizenInfoRequest citizenInfoRequest;

    /**
     * Gets the value of the citizenInfoRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CitizenInfoRequest }
     *     
     */
    public CitizenInfoRequest getCitizenInfoRequest() {
        return citizenInfoRequest;
    }

    /**
     * Sets the value of the citizenInfoRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CitizenInfoRequest }
     *     
     */
    public void setCitizenInfoRequest(CitizenInfoRequest value) {
        this.citizenInfoRequest = value;
    }

}
