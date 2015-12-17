/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.protocol;

import java.io.Serializable;
import org.lib.business.LibraryFacade;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public abstract class Command implements Serializable {
    
    public static final String OK = "ok";
    
    public abstract Object execute(LibraryFacade f) throws LibException;
    
}
