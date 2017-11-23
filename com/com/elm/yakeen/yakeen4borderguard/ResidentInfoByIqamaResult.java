
package com.elm.yakeen.yakeen4borderguard;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for residentInfoByIqamaResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="residentInfoByIqamaResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateOfBirthG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="englishFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="englishLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="englishSecondName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="englishThirdName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gender" type="{http://yakeen4borderguard.yakeen.elm.com/}gender" minOccurs="0"/>
 *         &lt;element name="iqamaExpiryDateH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iqamaIssueDateH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iqamaIssuePlaceDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isWanted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lifeStatus" type="{http://yakeen4borderguard.yakeen.elm.com/}lifeStatus" minOccurs="0"/>
 *         &lt;element name="logId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nationalityDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="occupationDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passportExpiryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secondName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="securityRecordListList" type="{http://yakeen4borderguard.yakeen.elm.com/}securityRecordList2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sponsorMoiNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sponsorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="thirdName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "residentInfoByIqamaResult", propOrder = {
    "dateOfBirthG",
    "englishFirstName",
    "englishLastName",
    "englishSecondName",
    "englishThirdName",
    "firstName",
    "gender",
    "iqamaExpiryDateH",
    "iqamaIssueDateH",
    "iqamaIssuePlaceDesc",
    "isWanted",
    "lastName",
    "lifeStatus",
    "logId",
    "nationalityDesc",
    "occupationDesc",
    "passportExpiryDate",
    "secondName",
    "securityRecordListList",
    "sponsorMoiNumber",
    "sponsorName",
    "thirdName"
})
public class ResidentInfoByIqamaResult {

    protected String dateOfBirthG;
    protected String englishFirstName;
    protected String englishLastName;
    protected String englishSecondName;
    protected String englishThirdName;
    protected String firstName;
    @XmlSchemaType(name = "string")
    protected Gender gender;
    protected String iqamaExpiryDateH;
    protected String iqamaIssueDateH;
    protected String iqamaIssuePlaceDesc;
    protected String isWanted;
    protected String lastName;
    @XmlSchemaType(name = "string")
    protected LifeStatus lifeStatus;
    protected int logId;
    protected String nationalityDesc;
    protected String occupationDesc;
    protected String passportExpiryDate;
    protected String secondName;
    @XmlElement(nillable = true)
    protected List<SecurityRecordList2> securityRecordListList;
    protected String sponsorMoiNumber;
    protected String sponsorName;
    protected String thirdName;

    /**
     * Gets the value of the dateOfBirthG property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfBirthG() {
        return dateOfBirthG;
    }

    /**
     * Sets the value of the dateOfBirthG property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfBirthG(String value) {
        this.dateOfBirthG = value;
    }

    /**
     * Gets the value of the englishFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishFirstName() {
        return englishFirstName;
    }

    /**
     * Sets the value of the englishFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishFirstName(String value) {
        this.englishFirstName = value;
    }

    /**
     * Gets the value of the englishLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishLastName() {
        return englishLastName;
    }

    /**
     * Sets the value of the englishLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishLastName(String value) {
        this.englishLastName = value;
    }

    /**
     * Gets the value of the englishSecondName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishSecondName() {
        return englishSecondName;
    }

    /**
     * Sets the value of the englishSecondName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishSecondName(String value) {
        this.englishSecondName = value;
    }

    /**
     * Gets the value of the englishThirdName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishThirdName() {
        return englishThirdName;
    }

    /**
     * Sets the value of the englishThirdName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishThirdName(String value) {
        this.englishThirdName = value;
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
     * Gets the value of the iqamaExpiryDateH property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIqamaExpiryDateH() {
        return iqamaExpiryDateH;
    }

    /**
     * Sets the value of the iqamaExpiryDateH property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIqamaExpiryDateH(String value) {
        this.iqamaExpiryDateH = value;
    }

    /**
     * Gets the value of the iqamaIssueDateH property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIqamaIssueDateH() {
        return iqamaIssueDateH;
    }

    /**
     * Sets the value of the iqamaIssueDateH property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIqamaIssueDateH(String value) {
        this.iqamaIssueDateH = value;
    }

    /**
     * Gets the value of the iqamaIssuePlaceDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIqamaIssuePlaceDesc() {
        return iqamaIssuePlaceDesc;
    }

    /**
     * Sets the value of the iqamaIssuePlaceDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIqamaIssuePlaceDesc(String value) {
        this.iqamaIssuePlaceDesc = value;
    }

    /**
     * Gets the value of the isWanted property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsWanted() {
        return isWanted;
    }

    /**
     * Sets the value of the isWanted property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsWanted(String value) {
        this.isWanted = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the lifeStatus property.
     * 
     * @return
     *     possible object is
     *     {@link LifeStatus }
     *     
     */
    public LifeStatus getLifeStatus() {
        return lifeStatus;
    }

    /**
     * Sets the value of the lifeStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link LifeStatus }
     *     
     */
    public void setLifeStatus(LifeStatus value) {
        this.lifeStatus = value;
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
     * Gets the value of the passportExpiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassportExpiryDate() {
        return passportExpiryDate;
    }

    /**
     * Sets the value of the passportExpiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassportExpiryDate(String value) {
        this.passportExpiryDate = value;
    }

    /**
     * Gets the value of the secondName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * Sets the value of the secondName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondName(String value) {
        this.secondName = value;
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
     * {@link SecurityRecordList2 }
     * 
     * 
     */
    public List<SecurityRecordList2> getSecurityRecordListList() {
        if (securityRecordListList == null) {
            securityRecordListList = new ArrayList<SecurityRecordList2>();
        }
        return this.securityRecordListList;
    }

    /**
     * Gets the value of the sponsorMoiNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSponsorMoiNumber() {
        return sponsorMoiNumber;
    }

    /**
     * Sets the value of the sponsorMoiNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSponsorMoiNumber(String value) {
        this.sponsorMoiNumber = value;
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
     * Gets the value of the thirdName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThirdName() {
        return thirdName;
    }

    /**
     * Sets the value of the thirdName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThirdName(String value) {
        this.thirdName = value;
    }

}
