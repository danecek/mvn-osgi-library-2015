/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.protocol;

import org.lib.business.LibraryFacade;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public class Logout extends Command {

    @Override
    public Object execute(LibraryFacade f) throws LibException {
        throw new RuntimeException();
    }

}
