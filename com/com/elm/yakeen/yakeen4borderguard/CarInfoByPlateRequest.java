
package com.elm.yakeen.yakeen4borderguard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for carInfoByPlateRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="carInfoByPlateRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chargeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plateNumber" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="plateText1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plateText2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plateText3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plateType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="referenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "carInfoByPlateRequest", propOrder = {
    "chargeCode",
    "password",
    "plateNumber",
    "plateText1",
    "plateText2",
    "plateText3",
    "plateType",
    "referenceNumber",
    "userName"
})
public class CarInfoByPlateRequest {

    protected String chargeCode;
    protected String password;
    protected short plateNumber;
    protected String plateText1;
    protected String plateText2;
    protected String plateText3;
    protected short plateType;
    protected String referenceNumber;
    protected String userName;

    /**
     * Gets the value of the chargeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeCode() {
        return chargeCode;
    }

    /**
     * Sets the value of the chargeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeCode(String value) {
        this.chargeCode = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the plateNumber property.
     * 
     */
    public short getPlateNumber() {
        return plateNumber;
    }

    /**
     * Sets the value of the plateNumber property.
     * 
     */
    public void setPlateNumber(short value) {
        this.plateNumber = value;
    }

    /**
     * Gets the value of the plateText1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlateText1() {
        return plateText1;
    }

    /**
     * Sets the value of the plateText1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlateText1(String value) {
        this.plateText1 = value;
    }

    /**
     * Gets the value of the plateText2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlateText2() {
        return plateText2;
    }

    /**
     * Sets the value of the plateText2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlateText2(String value) {
        this.plateText2 = value;
    }

    /**
     * Gets the value of the plateText3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlateText3() {
        return plateText3;
    }

    /**
     * Sets the value of the plateText3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlateText3(String value) {
        this.plateText3 = value;
    }

    /**
     * Gets the value of the plateType property.
     * 
     */
    public short getPlateType() {
        return plateType;
    }

    /**
     * Sets the value of the plateType property.
     * 
     */
    public void setPlateType(short value) {
        this.plateType = value;
    }

    /**
     * Gets the value of the referenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * Sets the value of the referenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceNumber(String value) {
        this.referenceNumber = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

}
