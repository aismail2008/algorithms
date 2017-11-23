
package com.elm.yakeen.yakeen4borderguard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCarInfoByPlate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCarInfoByPlate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CarInfoByPlateRequest" type="{http://yakeen4borderguard.yakeen.elm.com/}carInfoByPlateRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCarInfoByPlate", propOrder = {
    "carInfoByPlateRequest"
})
public class GetCarInfoByPlate {

    @XmlElement(name = "CarInfoByPlateRequest")
    protected CarInfoByPlateRequest carInfoByPlateRequest;

    /**
     * Gets the value of the carInfoByPlateRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CarInfoByPlateRequest }
     *     
     */
    public CarInfoByPlateRequest getCarInfoByPlateRequest() {
        return carInfoByPlateRequest;
    }

    /**
     * Sets the value of the carInfoByPlateRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarInfoByPlateRequest }
     *     
     */
    public void setCarInfoByPlateRequest(CarInfoByPlateRequest value) {
        this.carInfoByPlateRequest = value;
    }

}
