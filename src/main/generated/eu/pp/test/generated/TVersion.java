
package eu.pp.test.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class TVersion
    extends JAXBElement<Object>
{

    protected final static QName NAME = new QName("eu.pp.test.testWS", "versionCall");

    public TVersion(Object value) {
        super(NAME, ((Class) Object.class), null, value);
    }

    public TVersion() {
        super(NAME, ((Class) Object.class), null, null);
    }

}
