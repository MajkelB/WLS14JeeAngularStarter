package eu.pp.test.exception;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class TestWSException extends Exception {

    private int code = -1;

    public TestWSException( String s ) {
        super(s);
    }

    public TestWSException( int code, String s ) {
        this(s);
        this.code = code;
    }

}