
package eu.pp.test.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "eu.pp.test.testWS", targetNamespace = "eu.pp.test.testWS", wsdlLocation = "file:/dane/projekty/WLSTest/src/main/resources/descriptors/testWS.wsdl")
public class EuPpTestTestWS
    extends Service
{

    private final static URL EUPPTESTTESTWS_WSDL_LOCATION;
    private final static WebServiceException EUPPTESTTESTWS_EXCEPTION;
    private final static QName EUPPTESTTESTWS_QNAME = new QName("eu.pp.test.testWS", "eu.pp.test.testWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/dane/projekty/WLSTest/src/main/resources/descriptors/testWS.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        EUPPTESTTESTWS_WSDL_LOCATION = url;
        EUPPTESTTESTWS_EXCEPTION = e;
    }

    public EuPpTestTestWS() {
        super(__getWsdlLocation(), EUPPTESTTESTWS_QNAME);
    }

    public EuPpTestTestWS(WebServiceFeature... features) {
        super(__getWsdlLocation(), EUPPTESTTESTWS_QNAME, features);
    }

    public EuPpTestTestWS(URL wsdlLocation) {
        super(wsdlLocation, EUPPTESTTESTWS_QNAME);
    }

    public EuPpTestTestWS(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, EUPPTESTTESTWS_QNAME, features);
    }

    public EuPpTestTestWS(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EuPpTestTestWS(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TestWS
     */
    @WebEndpoint(name = "testWS")
    public TestWS getTestWS() {
        return super.getPort(new QName("eu.pp.test.testWS", "testWS"), TestWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TestWS
     */
    @WebEndpoint(name = "testWS")
    public TestWS getTestWS(WebServiceFeature... features) {
        return super.getPort(new QName("eu.pp.test.testWS", "testWS"), TestWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (EUPPTESTTESTWS_EXCEPTION!= null) {
            throw EUPPTESTTESTWS_EXCEPTION;
        }
        return EUPPTESTTESTWS_WSDL_LOCATION;
    }

}
