
package com.elm.yakeen.yakeen4borderguard;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.elm.yakeen.yakeen4borderguard package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCarInfoByPlate_QNAME = new QName("http://yakeen4borderguard.yakeen.elm.com/", "getCarInfoByPlate");
    private final static QName _GetVisitorInfoByBorderNumber_QNAME = new QName("http://yakeen4borderguard.yakeen.elm.com/", "getVisitorInfoByBorderNumber");
    private final static QName _GetCitizenInfoResponse_QNAME = new QName("http://yakeen4borderguard.yakeen.elm.com/", "getCitizenInfoResponse");
    private final static QName _GetGCCInfoByPassport_QNAME = new QName("http://yakeen4borderguard.yakeen.elm.com/", "getGCCInfoByPassport");
    private final static QName _GetCitizenInfo_QNAME = new QName("http://yakeen4borderguard.yakeen.elm.com/", "getCitizenInfo");
    private final static QName _GetGCCInfoByNIN_QNAME = new QName("http://yakeen4borderguard.yakeen.elm.com/", "getGCCInfoByNIN");
    private final static QName _GetGCCInfoByPassportResponse_QNAME = new QName("http://yakeen4borderguard.yakeen.elm.com/", "getGCCInfoByPassportResponse");
    private final static QName _GetCarInfoByPlateResponse_QNAME = new QName("http://yakeen4borderguard.yakeen.elm.com/", "getCarInfoByPlateResponse");
    private final static QName _GetResidentInfoByIqamaResponse_QNAME = new QName("http://yakeen4borderguard.yakeen.elm.com/", "getResidentInfoByIqamaResponse");
    private final static QName _GetResidentInfoByIqama_QNAME = new QName("http://yakeen4borderguard.yakeen.elm.com/", "getResidentInfoByIqama");
    private final static QName _Yakeen4BorderGuardFault_QNAME = new QName("http://yakeen4borderguard.yakeen.elm.com/", "Yakeen4BorderGuardFault");
    private final static QName _GetGCCInfoByNINResponse_QNAME = new QName("http://yakeen4borderguard.yakeen.elm.com/", "getGCCInfoByNINResponse");
    private final static QName _GetVisitorInfoByBorderNumberResponse_QNAME = new QName("http://yakeen4borderguard.yakeen.elm.com/", "getVisitorInfoByBorderNumberResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.elm.yakeen.yakeen4borderguard
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCitizenInfoResponse }
     * 
     */
    public GetCitizenInfoResponse createGetCitizenInfoResponse() {
        return new GetCitizenInfoResponse();
    }

    /**
     * Create an instance of {@link GetGCCInfoByPassport }
     * 
     */
    public GetGCCInfoByPassport createGetGCCInfoByPassport() {
        return new GetGCCInfoByPassport();
    }

    /**
     * Create an instance of {@link GetCitizenInfo }
     * 
     */
    public GetCitizenInfo createGetCitizenInfo() {
        return new GetCitizenInfo();
    }

    /**
     * Create an instance of {@link GetCarInfoByPlate }
     * 
     */
    public GetCarInfoByPlate createGetCarInfoByPlate() {
        return new GetCarInfoByPlate();
    }

    /**
     * Create an instance of {@link GetVisitorInfoByBorderNumber }
     * 
     */
    public GetVisitorInfoByBorderNumber createGetVisitorInfoByBorderNumber() {
        return new GetVisitorInfoByBorderNumber();
    }

    /**
     * Create an instance of {@link Yakeen4BorderGuardFault }
     * 
     */
    public Yakeen4BorderGuardFault createYakeen4BorderGuardFault() {
        return new Yakeen4BorderGuardFault();
    }

    /**
     * Create an instance of {@link GetGCCInfoByNINResponse }
     * 
     */
    public GetGCCInfoByNINResponse createGetGCCInfoByNINResponse() {
        return new GetGCCInfoByNINResponse();
    }

    /**
     * Create an instance of {@link GetVisitorInfoByBorderNumberResponse }
     * 
     */
    public GetVisitorInfoByBorderNumberResponse createGetVisitorInfoByBorderNumberResponse() {
        return new GetVisitorInfoByBorderNumberResponse();
    }

    /**
     * Create an instance of {@link GetGCCInfoByNIN }
     * 
     */
    public GetGCCInfoByNIN createGetGCCInfoByNIN() {
        return new GetGCCInfoByNIN();
    }

    /**
     * Create an instance of {@link GetGCCInfoByPassportResponse }
     * 
     */
    public GetGCCInfoByPassportResponse createGetGCCInfoByPassportResponse() {
        return new GetGCCInfoByPassportResponse();
    }

    /**
     * Create an instance of {@link GetCarInfoByPlateResponse }
     * 
     */
    public GetCarInfoByPlateResponse createGetCarInfoByPlateResponse() {
        return new GetCarInfoByPlateResponse();
    }

    /**
     * Create an instance of {@link GetResidentInfoByIqamaResponse }
     * 
     */
    public GetResidentInfoByIqamaResponse createGetResidentInfoByIqamaResponse() {
        return new GetResidentInfoByIqamaResponse();
    }

    /**
     * Create an instance of {@link GetResidentInfoByIqama }
     * 
     */
    public GetResidentInfoByIqama createGetResidentInfoByIqama() {
        return new GetResidentInfoByIqama();
    }

    /**
     * Create an instance of {@link CommonErrorObject }
     * 
     */
    public CommonErrorObject createCommonErrorObject() {
        return new CommonErrorObject();
    }

    /**
     * Create an instance of {@link ResidentInfoByIqamaResult }
     * 
     */
    public ResidentInfoByIqamaResult createResidentInfoByIqamaResult() {
        return new ResidentInfoByIqamaResult();
    }

    /**
     * Create an instance of {@link GccInfoByNINRequest }
     * 
     */
    public GccInfoByNINRequest createGccInfoByNINRequest() {
        return new GccInfoByNINRequest();
    }

    /**
     * Create an instance of {@link CarInfoByPlateRequest }
     * 
     */
    public CarInfoByPlateRequest createCarInfoByPlateRequest() {
        return new CarInfoByPlateRequest();
    }

    /**
     * Create an instance of {@link SecurityRecordList }
     * 
     */
    public SecurityRecordList createSecurityRecordList() {
        return new SecurityRecordList();
    }

    /**
     * Create an instance of {@link GccInfoByNINResult }
     * 
     */
    public GccInfoByNINResult createGccInfoByNINResult() {
        return new GccInfoByNINResult();
    }

    /**
     * Create an instance of {@link VisitorInfoByBorderNumberRequest }
     * 
     */
    public VisitorInfoByBorderNumberRequest createVisitorInfoByBorderNumberRequest() {
        return new VisitorInfoByBorderNumberRequest();
    }

    /**
     * Create an instance of {@link CitizenInfoRequest }
     * 
     */
    public CitizenInfoRequest createCitizenInfoRequest() {
        return new CitizenInfoRequest();
    }

    /**
     * Create an instance of {@link ResidentInfoByIqamaRequest }
     * 
     */
    public ResidentInfoByIqamaRequest createResidentInfoByIqamaRequest() {
        return new ResidentInfoByIqamaRequest();
    }

    /**
     * Create an instance of {@link GccInfoByPassportResult }
     * 
     */
    public GccInfoByPassportResult createGccInfoByPassportResult() {
        return new GccInfoByPassportResult();
    }

    /**
     * Create an instance of {@link VisitorInfoByBorderNumberResult }
     * 
     */
    public VisitorInfoByBorderNumberResult createVisitorInfoByBorderNumberResult() {
        return new VisitorInfoByBorderNumberResult();
    }

    /**
     * Create an instance of {@link SecurityRecordList3 }
     * 
     */
    public SecurityRecordList3 createSecurityRecordList3() {
        return new SecurityRecordList3();
    }

    /**
     * Create an instance of {@link GccInfoByPassportRequest }
     * 
     */
    public GccInfoByPassportRequest createGccInfoByPassportRequest() {
        return new GccInfoByPassportRequest();
    }

    /**
     * Create an instance of {@link SecurityRecordList2 }
     * 
     */
    public SecurityRecordList2 createSecurityRecordList2() {
        return new SecurityRecordList2();
    }

    /**
     * Create an instance of {@link CarInfoByPlateResult }
     * 
     */
    public CarInfoByPlateResult createCarInfoByPlateResult() {
        return new CarInfoByPlateResult();
    }

    /**
     * Create an instance of {@link CitizenInfoResult }
     * 
     */
    public CitizenInfoResult createCitizenInfoResult() {
        return new CitizenInfoResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCarInfoByPlate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yakeen4borderguard.yakeen.elm.com/", name = "getCarInfoByPlate")
    public JAXBElement<GetCarInfoByPlate> createGetCarInfoByPlate(GetCarInfoByPlate value) {
        return new JAXBElement<GetCarInfoByPlate>(_GetCarInfoByPlate_QNAME, GetCarInfoByPlate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVisitorInfoByBorderNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yakeen4borderguard.yakeen.elm.com/", name = "getVisitorInfoByBorderNumber")
    public JAXBElement<GetVisitorInfoByBorderNumber> createGetVisitorInfoByBorderNumber(GetVisitorInfoByBorderNumber value) {
        return new JAXBElement<GetVisitorInfoByBorderNumber>(_GetVisitorInfoByBorderNumber_QNAME, GetVisitorInfoByBorderNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitizenInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yakeen4borderguard.yakeen.elm.com/", name = "getCitizenInfoResponse")
    public JAXBElement<GetCitizenInfoResponse> createGetCitizenInfoResponse(GetCitizenInfoResponse value) {
        return new JAXBElement<GetCitizenInfoResponse>(_GetCitizenInfoResponse_QNAME, GetCitizenInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGCCInfoByPassport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yakeen4borderguard.yakeen.elm.com/", name = "getGCCInfoByPassport")
    public JAXBElement<GetGCCInfoByPassport> createGetGCCInfoByPassport(GetGCCInfoByPassport value) {
        return new JAXBElement<GetGCCInfoByPassport>(_GetGCCInfoByPassport_QNAME, GetGCCInfoByPassport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCitizenInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yakeen4borderguard.yakeen.elm.com/", name = "getCitizenInfo")
    public JAXBElement<GetCitizenInfo> createGetCitizenInfo(GetCitizenInfo value) {
        return new JAXBElement<GetCitizenInfo>(_GetCitizenInfo_QNAME, GetCitizenInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGCCInfoByNIN }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yakeen4borderguard.yakeen.elm.com/", name = "getGCCInfoByNIN")
    public JAXBElement<GetGCCInfoByNIN> createGetGCCInfoByNIN(GetGCCInfoByNIN value) {
        return new JAXBElement<GetGCCInfoByNIN>(_GetGCCInfoByNIN_QNAME, GetGCCInfoByNIN.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGCCInfoByPassportResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yakeen4borderguard.yakeen.elm.com/", name = "getGCCInfoByPassportResponse")
    public JAXBElement<GetGCCInfoByPassportResponse> createGetGCCInfoByPassportResponse(GetGCCInfoByPassportResponse value) {
        return new JAXBElement<GetGCCInfoByPassportResponse>(_GetGCCInfoByPassportResponse_QNAME, GetGCCInfoByPassportResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCarInfoByPlateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yakeen4borderguard.yakeen.elm.com/", name = "getCarInfoByPlateResponse")
    public JAXBElement<GetCarInfoByPlateResponse> createGetCarInfoByPlateResponse(GetCarInfoByPlateResponse value) {
        return new JAXBElement<GetCarInfoByPlateResponse>(_GetCarInfoByPlateResponse_QNAME, GetCarInfoByPlateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResidentInfoByIqamaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yakeen4borderguard.yakeen.elm.com/", name = "getResidentInfoByIqamaResponse")
    public JAXBElement<GetResidentInfoByIqamaResponse> createGetResidentInfoByIqamaResponse(GetResidentInfoByIqamaResponse value) {
        return new JAXBElement<GetResidentInfoByIqamaResponse>(_GetResidentInfoByIqamaResponse_QNAME, GetResidentInfoByIqamaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResidentInfoByIqama }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yakeen4borderguard.yakeen.elm.com/", name = "getResidentInfoByIqama")
    public JAXBElement<GetResidentInfoByIqama> createGetResidentInfoByIqama(GetResidentInfoByIqama value) {
        return new JAXBElement<GetResidentInfoByIqama>(_GetResidentInfoByIqama_QNAME, GetResidentInfoByIqama.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Yakeen4BorderGuardFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yakeen4borderguard.yakeen.elm.com/", name = "Yakeen4BorderGuardFault")
    public JAXBElement<Yakeen4BorderGuardFault> createYakeen4BorderGuardFault(Yakeen4BorderGuardFault value) {
        return new JAXBElement<Yakeen4BorderGuardFault>(_Yakeen4BorderGuardFault_QNAME, Yakeen4BorderGuardFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGCCInfoByNINResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yakeen4borderguard.yakeen.elm.com/", name = "getGCCInfoByNINResponse")
    public JAXBElement<GetGCCInfoByNINResponse> createGetGCCInfoByNINResponse(GetGCCInfoByNINResponse value) {
        return new JAXBElement<GetGCCInfoByNINResponse>(_GetGCCInfoByNINResponse_QNAME, GetGCCInfoByNINResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVisitorInfoByBorderNumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yakeen4borderguard.yakeen.elm.com/", name = "getVisitorInfoByBorderNumberResponse")
    public JAXBElement<GetVisitorInfoByBorderNumberResponse> createGetVisitorInfoByBorderNumberResponse(GetVisitorInfoByBorderNumberResponse value) {
        return new JAXBElement<GetVisitorInfoByBorderNumberResponse>(_GetVisitorInfoByBorderNumberResponse_QNAME, GetVisitorInfoByBorderNumberResponse.class, null, value);
    }

}
