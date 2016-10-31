package org.lib.protocol;

import java.io.Serializable;
import org.lib.business.LibraryFacadeInterface;
import org.lib.utils.LibException;

public abstract class Command implements Serializable {
    
    public static final Ok OK = new Ok();
    
    public abstract Object execute(LibraryFacadeInterface f) throws LibException;
    
}
