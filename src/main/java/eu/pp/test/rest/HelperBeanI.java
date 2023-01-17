package eu.pp.test.rest;

import javax.ejb.Local;

@Local
public interface HelperBeanI {

    String getVersion();

    String getPerson();

}
