package org.lib.protocol;

import java.io.Serializable;
import org.lib.business.LibraryFacade;
import org.lib.utils.LibException;

public abstract class Command implements Serializable {
    
    public static final Ok OK = new Ok();
    
    public abstract Object execute(LibraryFacade f) throws LibException;
    
}
