package eu.pp.test.rest;

import eu.pp.test.mapstruct.PersonFrom;
import eu.pp.test.mapstruct.PersonMapperI;
import eu.pp.test.mapstruct.PersonTo;
import eu.pp.test.rest.HelperBeanI;
import eu.pp.test.util.Test;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;

@Stateless( name="HelperBean", mappedName="HelperBean" )
@LocalBean
//@Data
//@NoArgsConstructor
public class HelperBean implements HelperBeanI {

    private final String version = "0.0.12";
    private final String version2 = "0.0.10";

    @Inject
    private PersonMapperI personMapper;

    public HelperBean() {
    }

    @Override
    public String getVersion() {
        Test t = new Test( 5, "a") ;
        t.setOla( "yyyy777");
        return version + " " + t.getOla();
    }

    @Override
    public String getPerson() {
        PersonFrom pf = new PersonFrom();
        pf.setName( "Ala" );
        pf.setLastName( "Ola" );
        pf.setAge( 11 );
        pf.setBirthDate( new Date() );
        PersonTo pt = personMapper.toPersonTo( pf );
        return pt.toString();

    }
}
