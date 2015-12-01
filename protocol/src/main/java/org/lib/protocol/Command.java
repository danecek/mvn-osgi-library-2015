/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.protocol;

import org.lib.business.LibraryFacade;

/**
 *
 * @author danecek
 */
public abstract class Command {
    
    abstract void execute(LibraryFacade f);
    
}
