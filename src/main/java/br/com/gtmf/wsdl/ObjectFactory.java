
package br.com.gtmf.wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.gtmf.wsdl package. 
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

    private final static QName _Write_QNAME = new QName("http://gtmf.com.br/", "write");
    private final static QName _Login_QNAME = new QName("http://gtmf.com.br/", "login");
    private final static QName _WriteResponse_QNAME = new QName("http://gtmf.com.br/", "writeResponse");
    private final static QName _LogoutResponse_QNAME = new QName("http://gtmf.com.br/", "logoutResponse");
    private final static QName _ChangeLocation_QNAME = new QName("http://gtmf.com.br/", "changeLocation");
    private final static QName _Logout_QNAME = new QName("http://gtmf.com.br/", "logout");
    private final static QName _WriteTo_QNAME = new QName("http://gtmf.com.br/", "writeTo");
    private final static QName _StartRadarResponse_QNAME = new QName("http://gtmf.com.br/", "startRadarResponse");
    private final static QName _ListNearlyClientsResponse_QNAME = new QName("http://gtmf.com.br/", "listNearlyClientsResponse");
    private final static QName _WriteToResponse_QNAME = new QName("http://gtmf.com.br/", "writeToResponse");
    private final static QName _ChangeLocationResponse_QNAME = new QName("http://gtmf.com.br/", "changeLocationResponse");
    private final static QName _ListNearlyClients_QNAME = new QName("http://gtmf.com.br/", "listNearlyClients");
    private final static QName _StopRadar_QNAME = new QName("http://gtmf.com.br/", "stopRadar");
    private final static QName _StopRadarResponse_QNAME = new QName("http://gtmf.com.br/", "stopRadarResponse");
    private final static QName _LoginResponse_QNAME = new QName("http://gtmf.com.br/", "loginResponse");
    private final static QName _StartRadar_QNAME = new QName("http://gtmf.com.br/", "startRadar");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.gtmf.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StopRadarResponse }
     * 
     */
    public StopRadarResponse createStopRadarResponse() {
        return new StopRadarResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link StartRadar }
     * 
     */
    public StartRadar createStartRadar() {
        return new StartRadar();
    }

    /**
     * Create an instance of {@link WriteToResponse }
     * 
     */
    public WriteToResponse createWriteToResponse() {
        return new WriteToResponse();
    }

    /**
     * Create an instance of {@link ChangeLocationResponse }
     * 
     */
    public ChangeLocationResponse createChangeLocationResponse() {
        return new ChangeLocationResponse();
    }

    /**
     * Create an instance of {@link ListNearlyClients }
     * 
     */
    public ListNearlyClients createListNearlyClients() {
        return new ListNearlyClients();
    }

    /**
     * Create an instance of {@link StopRadar }
     * 
     */
    public StopRadar createStopRadar() {
        return new StopRadar();
    }

    /**
     * Create an instance of {@link Logout }
     * 
     */
    public Logout createLogout() {
        return new Logout();
    }

    /**
     * Create an instance of {@link WriteTo }
     * 
     */
    public WriteTo createWriteTo() {
        return new WriteTo();
    }

    /**
     * Create an instance of {@link StartRadarResponse }
     * 
     */
    public StartRadarResponse createStartRadarResponse() {
        return new StartRadarResponse();
    }

    /**
     * Create an instance of {@link ListNearlyClientsResponse }
     * 
     */
    public ListNearlyClientsResponse createListNearlyClientsResponse() {
        return new ListNearlyClientsResponse();
    }

    /**
     * Create an instance of {@link Write }
     * 
     */
    public Write createWrite() {
        return new Write();
    }

    /**
     * Create an instance of {@link WriteResponse }
     * 
     */
    public WriteResponse createWriteResponse() {
        return new WriteResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link ChangeLocation }
     * 
     */
    public ChangeLocation createChangeLocation() {
        return new ChangeLocation();
    }

    /**
     * Create an instance of {@link LogoutResponse }
     * 
     */
    public LogoutResponse createLogoutResponse() {
        return new LogoutResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Write }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gtmf.com.br/", name = "write")
    public JAXBElement<Write> createWrite(Write value) {
        return new JAXBElement<Write>(_Write_QNAME, Write.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gtmf.com.br/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gtmf.com.br/", name = "writeResponse")
    public JAXBElement<WriteResponse> createWriteResponse(WriteResponse value) {
        return new JAXBElement<WriteResponse>(_WriteResponse_QNAME, WriteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gtmf.com.br/", name = "logoutResponse")
    public JAXBElement<LogoutResponse> createLogoutResponse(LogoutResponse value) {
        return new JAXBElement<LogoutResponse>(_LogoutResponse_QNAME, LogoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeLocation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gtmf.com.br/", name = "changeLocation")
    public JAXBElement<ChangeLocation> createChangeLocation(ChangeLocation value) {
        return new JAXBElement<ChangeLocation>(_ChangeLocation_QNAME, ChangeLocation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gtmf.com.br/", name = "logout")
    public JAXBElement<Logout> createLogout(Logout value) {
        return new JAXBElement<Logout>(_Logout_QNAME, Logout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteTo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gtmf.com.br/", name = "writeTo")
    public JAXBElement<WriteTo> createWriteTo(WriteTo value) {
        return new JAXBElement<WriteTo>(_WriteTo_QNAME, WriteTo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartRadarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gtmf.com.br/", name = "startRadarResponse")
    public JAXBElement<StartRadarResponse> createStartRadarResponse(StartRadarResponse value) {
        return new JAXBElement<StartRadarResponse>(_StartRadarResponse_QNAME, StartRadarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListNearlyClientsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gtmf.com.br/", name = "listNearlyClientsResponse")
    public JAXBElement<ListNearlyClientsResponse> createListNearlyClientsResponse(ListNearlyClientsResponse value) {
        return new JAXBElement<ListNearlyClientsResponse>(_ListNearlyClientsResponse_QNAME, ListNearlyClientsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteToResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gtmf.com.br/", name = "writeToResponse")
    public JAXBElement<WriteToResponse> createWriteToResponse(WriteToResponse value) {
        return new JAXBElement<WriteToResponse>(_WriteToResponse_QNAME, WriteToResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeLocationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gtmf.com.br/", name = "changeLocationResponse")
    public JAXBElement<ChangeLocationResponse> createChangeLocationResponse(ChangeLocationResponse value) {
        return new JAXBElement<ChangeLocationResponse>(_ChangeLocationResponse_QNAME, ChangeLocationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListNearlyClients }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gtmf.com.br/", name = "listNearlyClients")
    public JAXBElement<ListNearlyClients> createListNearlyClients(ListNearlyClients value) {
        return new JAXBElement<ListNearlyClients>(_ListNearlyClients_QNAME, ListNearlyClients.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopRadar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gtmf.com.br/", name = "stopRadar")
    public JAXBElement<StopRadar> createStopRadar(StopRadar value) {
        return new JAXBElement<StopRadar>(_StopRadar_QNAME, StopRadar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopRadarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gtmf.com.br/", name = "stopRadarResponse")
    public JAXBElement<StopRadarResponse> createStopRadarResponse(StopRadarResponse value) {
        return new JAXBElement<StopRadarResponse>(_StopRadarResponse_QNAME, StopRadarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gtmf.com.br/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartRadar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gtmf.com.br/", name = "startRadar")
    public JAXBElement<StartRadar> createStartRadar(StartRadar value) {
        return new JAXBElement<StartRadar>(_StartRadar_QNAME, StartRadar.class, null, value);
    }

}
