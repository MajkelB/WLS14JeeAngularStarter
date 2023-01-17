package eu.pp.test.soap;

import eu.pp.test.generated.*;

import javax.jws.WebService;
import javax.xml.ws.BindingType;


@WebService(portName = "testWS", serviceName = "eu.pp.test.testWS", targetNamespace = "eu.pp.test.testWS", wsdlLocation = "/descriptors/testWS.wsdl", endpointInterface = "eu.pp.test.soap.TestWS")
@BindingType("http://schemas.xmlsoap.org/wsdl/soap/http")
public class SOAPTestWSImpl implements TestWS {

    private final TResponse RESPONSE_OK;

    public SOAPTestWSImpl() {
        RESPONSE_OK = new ObjectFactory().createTResponse();
        RESPONSE_OK.setCode( 0 );
        RESPONSE_OK.setText( "OK" );
    }

    @Override
    public TResponse version(Object body) {
        return RESPONSE_OK;
    }

    @Override
    public TResponse simpleTestWS(TParameterRequest body) {
        return RESPONSE_OK;
    }

    @Override
    public TResponse dbTestWS(TParameterRequest body) {
        return RESPONSE_OK;
    }

    @Override
    public TResponse callTestWS(TServiceRequest body) {
        return RESPONSE_OK;
    }
}
