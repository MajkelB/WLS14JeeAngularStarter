package eu.pp.test.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu.pp.test.util.Util;
import weblogic.logging.NonCatalogLogger;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;



@RequestScoped
@Path("/api")
public class RestWS {

    final NonCatalogLogger logger = new NonCatalogLogger( "WLSApp" );

    @EJB
    private HelperBean hb;


    @GET
    @Path("test")
    @Produces("text/plain")
    public String test() {
        return "test";
    }


    @GET
    @Path("version")
    @Produces("text/plain")
    public String adapterVersion() {
        return hb.getVersion();
    }

    @GET
    @Path("person")
    @Produces("text/plain")
    public String getPerson() {
        return hb.getPerson();
    }

    @GET
    @Path("personJSON")
    @Produces("application/json")
    public String getJSONPerson() {
        try {
            return Util.getJson( hb.getPerson() );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
