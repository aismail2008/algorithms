
package com.elm.yakeen.yakeen4borderguard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getVisitorInfoByBorderNumberResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getVisitorInfoByBorderNumberResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisitorInfoByBorderNumberResult" type="{http://yakeen4borderguard.yakeen.elm.com/}visitorInfoByBorderNumberResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getVisitorInfoByBorderNumberResponse", propOrder = {
    "visitorInfoByBorderNumberResult"
})
public class GetVisitorInfoByBorderNumberResponse {

    @XmlElement(name = "VisitorInfoByBorderNumberResult")
    protected VisitorInfoByBorderNumberResult visitorInfoByBorderNumberResult;

    /**
     * Gets the value of the visitorInfoByBorderNumberResult property.
     * 
     * @return
     *     possible object is
     *     {@link VisitorInfoByBorderNumberResult }
     *     
     */
    public VisitorInfoByBorderNumberResult getVisitorInfoByBorderNumberResult() {
        return visitorInfoByBorderNumberResult;
    }

    /**
     * Sets the value of the visitorInfoByBorderNumberResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link VisitorInfoByBorderNumberResult }
     *     
     */
    public void setVisitorInfoByBorderNumberResult(VisitorInfoByBorderNumberResult value) {
        this.visitorInfoByBorderNumberResult = value;
    }

}
