
package com.elm.yakeen.yakeen4borderguard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getVisitorInfoByBorderNumber complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getVisitorInfoByBorderNumber">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisitorInfoByBorderNumberRequest" type="{http://yakeen4borderguard.yakeen.elm.com/}visitorInfoByBorderNumberRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getVisitorInfoByBorderNumber", propOrder = {
    "visitorInfoByBorderNumberRequest"
})
public class GetVisitorInfoByBorderNumber {

    @XmlElement(name = "VisitorInfoByBorderNumberRequest")
    protected VisitorInfoByBorderNumberRequest visitorInfoByBorderNumberRequest;

    /**
     * Gets the value of the visitorInfoByBorderNumberRequest property.
     * 
     * @return
     *     possible object is
     *     {@link VisitorInfoByBorderNumberRequest }
     *     
     */
    public VisitorInfoByBorderNumberRequest getVisitorInfoByBorderNumberRequest() {
        return visitorInfoByBorderNumberRequest;
    }

    /**
     * Sets the value of the visitorInfoByBorderNumberRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link VisitorInfoByBorderNumberRequest }
     *     
     */
    public void setVisitorInfoByBorderNumberRequest(VisitorInfoByBorderNumberRequest value) {
        this.visitorInfoByBorderNumberRequest = value;
    }

}
