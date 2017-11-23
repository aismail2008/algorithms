
package com.elm.yakeen.yakeen4borderguard;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for citizenInfoResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="citizenInfoResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateOfBirthG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="englishFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="englishLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="englishSecondName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="englishThirdName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="familyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fatherName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gender" type="{http://yakeen4borderguard.yakeen.elm.com/}gender" minOccurs="0"/>
 *         &lt;element name="grandFatherName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idExpiryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idIssueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idIssuePlace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idVersionNumber" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="isWanted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jobDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lifeStatus" type="{http://yakeen4borderguard.yakeen.elm.com/}lifeStatus" minOccurs="0"/>
 *         &lt;element name="logId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="securityRecordListList" type="{http://yakeen4borderguard.yakeen.elm.com/}securityRecordList" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subtribeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "citizenInfoResult", propOrder = {
    "dateOfBirthG",
    "englishFirstName",
    "englishLastName",
    "englishSecondName",
    "englishThirdName",
    "familyName",
    "fatherName",
    "firstName",
    "gender",
    "grandFatherName",
    "idExpiryDate",
    "idIssueDate",
    "idIssuePlace",
    "idVersionNumber",
    "isWanted",
    "jobDesc",
    "lifeStatus",
    "logId",
    "securityRecordListList",
    "subtribeName"
})
public class CitizenInfoResult {

    protected String dateOfBirthG;
    protected String englishFirstName;
    protected String englishLastName;
    protected String englishSecondName;
    protected String englishThirdName;
    protected String familyName;
    protected String fatherName;
    protected String firstName;
    @XmlSchemaType(name = "string")
    protected Gender gender;
    protected String grandFatherName;
    protected String idExpiryDate;
    protected String idIssueDate;
    protected String idIssuePlace;
    protected short idVersionNumber;
    protected String isWanted;
    protected String jobDesc;
    @XmlSchemaType(name = "string")
    protected LifeStatus lifeStatus;
    protected int logId;
    @XmlElement(nillable = true)
    protected List<SecurityRecordList> securityRecordListList;
    protected String subtribeName;

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
     * Gets the value of the fatherName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * Sets the value of the fatherName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFatherName(String value) {
        this.fatherName = value;
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
     * Gets the value of the idExpiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdExpiryDate() {
        return idExpiryDate;
    }

    /**
     * Sets the value of the idExpiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdExpiryDate(String value) {
        this.idExpiryDate = value;
    }

    /**
     * Gets the value of the idIssueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdIssueDate() {
        return idIssueDate;
    }

    /**
     * Sets the value of the idIssueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdIssueDate(String value) {
        this.idIssueDate = value;
    }

    /**
     * Gets the value of the idIssuePlace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdIssuePlace() {
        return idIssuePlace;
    }

    /**
     * Sets the value of the idIssuePlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdIssuePlace(String value) {
        this.idIssuePlace = value;
    }

    /**
     * Gets the value of the idVersionNumber property.
     * 
     */
    public short getIdVersionNumber() {
        return idVersionNumber;
    }

    /**
     * Sets the value of the idVersionNumber property.
     * 
     */
    public void setIdVersionNumber(short value) {
        this.idVersionNumber = value;
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
     * Gets the value of the jobDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobDesc() {
        return jobDesc;
    }

    /**
     * Sets the value of the jobDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobDesc(String value) {
        this.jobDesc = value;
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
     * {@link SecurityRecordList }
     * 
     * 
     */
    public List<SecurityRecordList> getSecurityRecordListList() {
        if (securityRecordListList == null) {
            securityRecordListList = new ArrayList<SecurityRecordList>();
        }
        return this.securityRecordListList;
    }

    /**
     * Gets the value of the subtribeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubtribeName() {
        return subtribeName;
    }

    /**
     * Sets the value of the subtribeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubtribeName(String value) {
        this.subtribeName = value;
    }

}
