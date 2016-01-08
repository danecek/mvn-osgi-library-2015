package org.lib.protocol;

import javax.xml.bind.annotation.XmlRootElement;
import org.lib.business.LibraryFacadeInterface;
import org.lib.utils.LibException;

@XmlRootElement
public class Logout extends Command {

    public Logout() {
    }

    @Override
    public Object execute(LibraryFacadeInterface f) throws LibException {
        throw new RuntimeException();
    }

}
