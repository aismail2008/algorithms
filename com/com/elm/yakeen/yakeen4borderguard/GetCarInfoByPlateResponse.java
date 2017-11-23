
package com.elm.yakeen.yakeen4borderguard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCarInfoByPlateResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCarInfoByPlateResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CarInfoByPlateResult" type="{http://yakeen4borderguard.yakeen.elm.com/}carInfoByPlateResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCarInfoByPlateResponse", propOrder = {
    "carInfoByPlateResult"
})
public class GetCarInfoByPlateResponse {

    @XmlElement(name = "CarInfoByPlateResult")
    protected CarInfoByPlateResult carInfoByPlateResult;

    /**
     * Gets the value of the carInfoByPlateResult property.
     * 
     * @return
     *     possible object is
     *     {@link CarInfoByPlateResult }
     *     
     */
    public CarInfoByPlateResult getCarInfoByPlateResult() {
        return carInfoByPlateResult;
    }

    /**
     * Sets the value of the carInfoByPlateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarInfoByPlateResult }
     *     
     */
    public void setCarInfoByPlateResult(CarInfoByPlateResult value) {
        this.carInfoByPlateResult = value;
    }

}
