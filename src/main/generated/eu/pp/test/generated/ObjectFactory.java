
package eu.pp.test.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.pp.test.generated package. 
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

    private final static QName _SimpleTestCall_QNAME = new QName("eu.pp.test.testWS", "simpleTestCall");
    private final static QName _DbTestCall_QNAME = new QName("eu.pp.test.testWS", "dbTestCall");
    private final static QName _ServiceCall_QNAME = new QName("eu.pp.test.testWS", "serviceCall");
    private final static QName _TestResult_QNAME = new QName("eu.pp.test.testWS", "testResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.pp.test.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TParameterRequest }
     * 
     */
    public TParameterRequest createTParameterRequest() {
        return new TParameterRequest();
    }

    /**
     * Create an instance of {@link TServiceRequest }
     * 
     */
    public TServiceRequest createTServiceRequest() {
        return new TServiceRequest();
    }

    /**
     * Create an instance of {@link TResponse }
     * 
     */
    public TResponse createTResponse() {
        return new TResponse();
    }

    /**
     * Create an instance of {@link TService }
     * 
     */
    public TService createTService() {
        return new TService();
    }

    /**
     * Create an instance of {@link TServiceResponse }
     * 
     */
    public TServiceResponse createTServiceResponse() {
        return new TServiceResponse();
    }

    /**
     * Create an instance of {@link TVersion }
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link TVersion }
     */
    @XmlElementDecl(namespace = "eu.pp.test.testWS", name = "versionCall")
    public TVersion createTVersion(Object value) {
        return new TVersion(value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TParameterRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TParameterRequest }{@code >}
     */
    @XmlElementDecl(namespace = "eu.pp.test.testWS", name = "simpleTestCall")
    public JAXBElement<TParameterRequest> createSimpleTestCall(TParameterRequest value) {
        return new JAXBElement<TParameterRequest>(_SimpleTestCall_QNAME, TParameterRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TParameterRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TParameterRequest }{@code >}
     */
    @XmlElementDecl(namespace = "eu.pp.test.testWS", name = "dbTestCall")
    public JAXBElement<TParameterRequest> createDbTestCall(TParameterRequest value) {
        return new JAXBElement<TParameterRequest>(_DbTestCall_QNAME, TParameterRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TServiceRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TServiceRequest }{@code >}
     */
    @XmlElementDecl(namespace = "eu.pp.test.testWS", name = "serviceCall")
    public JAXBElement<TServiceRequest> createServiceCall(TServiceRequest value) {
        return new JAXBElement<TServiceRequest>(_ServiceCall_QNAME, TServiceRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TResponse }{@code >}
     */
    @XmlElementDecl(namespace = "eu.pp.test.testWS", name = "testResult")
    public JAXBElement<TResponse> createTestResult(TResponse value) {
        return new JAXBElement<TResponse>(_TestResult_QNAME, TResponse.class, null, value);
    }

}
