package eu.pp.test.mapstruct;


import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper( componentModel = "cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR )
public interface PersonMapperI {

    @Mapping(source = "pt.name2", target = "name")
    @Mapping(source = "pt.lastName2", target = "lastName")
    @Mapping(source = "pt.age2", target = "age")
    @Mapping(source = "pt.birthDate2", target = "birthDate")
    PersonFrom toPersonFrom( PersonTo pt );

    @Mapping(source = "pf.name", target = "name2")
    @Mapping(source = "pf.lastName", target = "lastName2")
    @Mapping(source = "pf.age", target = "age2")
    @Mapping(source = "pf.birthDate", target = "birthDate2")
    PersonTo toPersonTo( PersonFrom pf );

}
