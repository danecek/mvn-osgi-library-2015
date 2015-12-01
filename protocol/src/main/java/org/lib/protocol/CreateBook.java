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
public class CreateBook extends Command {

    String title;
    String author;

    @Override
    void execute(LibraryFacade f) {
        f.createBook(title, author);
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
