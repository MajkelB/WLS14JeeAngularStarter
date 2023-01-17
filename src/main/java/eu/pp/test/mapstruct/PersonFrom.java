package eu.pp.test.mapstruct;

import lombok.Data;

import java.util.Date;

@Data
public class PersonFrom {

    private String name;
    private String lastName;
    private Date birthDate;
    private int age;

}
