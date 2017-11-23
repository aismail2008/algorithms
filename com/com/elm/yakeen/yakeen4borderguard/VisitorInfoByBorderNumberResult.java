
package com.elm.yakeen.yakeen4borderguard;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for visitorInfoByBorderNumberResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="visitorInfoByBorderNumberResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="familyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gender" type="{http://yakeen4borderguard.yakeen.elm.com/}gender" minOccurs="0"/>
 *         &lt;element name="grandFatherName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lifeStatusCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="logId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nationalityDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="occupationDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passportNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="seconedName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="securityRecordListList" type="{http://yakeen4borderguard.yakeen.elm.com/}securityRecordList3" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sponsorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sponsorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="visaExpiryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="visaIssueDateH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="visaNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "visitorInfoByBorderNumberResult", propOrder = {
    "familyName",
    "firstName",
    "gender",
    "grandFatherName",
    "lifeStatusCode",
    "logId",
    "nationalityDesc",
    "occupationDesc",
    "passportNumber",
    "seconedName",
    "securityRecordListList",
    "sponsorId",
    "sponsorName",
    "visaExpiryDate",
    "visaIssueDateH",
    "visaNumber"
})
public class VisitorInfoByBorderNumberResult {

    protected String familyName;
    protected String firstName;
    @XmlSchemaType(name = "string")
    protected Gender gender;
    protected String grandFatherName;
    protected int lifeStatusCode;
    protected int logId;
    protected String nationalityDesc;
    protected String occupationDesc;
    protected String passportNumber;
    protected String seconedName;
    @XmlElement(nillable = true)
    protected List<SecurityRecordList3> securityRecordListList;
    protected String sponsorId;
    protected String sponsorName;
    protected String visaExpiryDate;
    protected String visaIssueDateH;
    protected String visaNumber;

    /**
     * Gets the value of the familyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * Sets the value of the familyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamilyName(String value) {
        this.familyName = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link Gender }
     *     
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link Gender }
     *     
     */
    public void setGender(Gender value) {
        this.gender = value;
    }

    /**
     * Gets the value of the grandFatherName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrandFatherName() {
        return grandFatherName;
    }

    /**
     * Sets the value of the grandFatherName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrandFatherName(String value) {
        this.grandFatherName = value;
    }

    /**
     * Gets the value of the lifeStatusCode property.
     * 
     */
    public int getLifeStatusCode() {
        return lifeStatusCode;
    }

    /**
     * Sets the value of the lifeStatusCode property.
     * 
     */
    public void setLifeStatusCode(int value) {
        this.lifeStatusCode = value;
    }

    /**
     * Gets the value of the logId property.
     * 
     */
    public int getLogId() {
        return logId;
    }

    /**
     * Sets the value of the logId property.
     * 
     */
    public void setLogId(int value) {
        this.logId = value;
    }

    /**
     * Gets the value of the nationalityDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationalityDesc() {
        return nationalityDesc;
    }

    /**
     * Sets the value of the nationalityDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationalityDesc(String value) {
        this.nationalityDesc = value;
    }

    /**
     * Gets the value of the occupationDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOccupationDesc() {
        return occupationDesc;
    }

    /**
     * Sets the value of the occupationDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccupationDesc(String value) {
        this.occupationDesc = value;
    }

    /**
     * Gets the value of the passportNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassportNumber() {
        return passportNumber;
    }

    /**
     * Sets the value of the passportNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassportNumber(String value) {
        this.passportNumber = value;
    }

    /**
     * Gets the value of the seconedName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeconedName() {
        return seconedName;
    }

    /**
     * Sets the value of the seconedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeconedName(String value) {
        this.seconedName = value;
    }

    /**
     * Gets the value of the securityRecordListList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the securityRecordListList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSecurityRecordListList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SecurityRecordList3 }
     * 
     * 
     */
    public List<SecurityRecordList3> getSecurityRecordListList() {
        if (securityRecordListList == null) {
            securityRecordListList = new ArrayList<SecurityRecordList3>();
        }
        return this.securityRecordListList;
    }

    /**
     * Gets the value of the sponsorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSponsorId() {
        return sponsorId;
    }

    /**
     * Sets the value of the sponsorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSponsorId(String value) {
        this.sponsorId = value;
    }

    /**
     * Gets the value of the sponsorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSponsorName() {
        return sponsorName;
    }

    /**
     * Sets the value of the sponsorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSponsorName(String value) {
        this.sponsorName = value;
    }

    /**
     * Gets the value of the visaExpiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisaExpiryDate() {
        return visaExpiryDate;
    }

    /**
     * Sets the value of the visaExpiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisaExpiryDate(String value) {
        this.visaExpiryDate = value;
    }

    /**
     * Gets the value of the visaIssueDateH property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisaIssueDateH() {
        return visaIssueDateH;
    }

    /**
     * Sets the value of the visaIssueDateH property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisaIssueDateH(String value) {
        this.visaIssueDateH = value;
    }

    /**
     * Gets the value of the visaNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisaNumber() {
        return visaNumber;
    }

    /**
     * Sets the value of the visaNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisaNumber(String value) {
        this.visaNumber = value;
    }

}
