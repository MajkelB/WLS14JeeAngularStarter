package eu.pp.test.exception;

public class ConfigurationException extends TestWSException {

    public ConfigurationException( String s ) {
        super(s);
    }

    public ConfigurationException(int code, String s) {
        super(code, s);
    }
}