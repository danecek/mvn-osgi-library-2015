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
public class CreateBook extends Command {

    private final String title;
    private final String author;

    public CreateBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public Object execute(LibraryFacade f) throws LibException {
        f.createBook(title, author);
        return OK;
    }

}
