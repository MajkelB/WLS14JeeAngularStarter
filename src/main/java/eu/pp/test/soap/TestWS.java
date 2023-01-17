
package eu.pp.test.soap;

import eu.pp.test.generated.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "testWS", targetNamespace = "eu.pp.test.testWS")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TestWS {


    /**
     *
     * @param body
     * @return
     *     returns eu.pp.test.TResponse
     */
    @WebMethod(action = "version")
    @WebResult(name = "testResult", targetNamespace = "eu.pp.test.testWS", partName = "body")
    TResponse version(
        @WebParam(name = "versionCall", targetNamespace = "eu.pp.test.testWS", partName = "body")
        Object body);

    /**
     *
     * @param body
     * @return
     *     returns eu.pp.test.TResponse
     */
    @WebMethod(action = "simpleTestWS")
    @WebResult(name = "testResult", targetNamespace = "eu.pp.test.testWS", partName = "body")
    TResponse simpleTestWS(
        @WebParam(name = "simpleTestCall", targetNamespace = "eu.pp.test.testWS", partName = "body")
        TParameterRequest body);

    /**
     *
     * @param body
     * @return
     *     returns eu.pp.test.TResponse
     */
    @WebMethod(action = "dbTestWS")
    @WebResult(name = "testResult", targetNamespace = "eu.pp.test.testWS", partName = "body")
    TResponse dbTestWS(
        @WebParam(name = "dbTestCall", targetNamespace = "eu.pp.test.testWS", partName = "body")
        TParameterRequest body);

    /**
     *
     * @param body
     * @return
     *     returns eu.pp.test.TResponse
     */
    @WebMethod(action = "callTestWS")
    @WebResult(name = "testResult", targetNamespace = "eu.pp.test.testWS", partName = "body")
    TResponse callTestWS(
        @WebParam(name = "serviceCall", targetNamespace = "eu.pp.test.testWS", partName = "body")
        TServiceRequest body);

}