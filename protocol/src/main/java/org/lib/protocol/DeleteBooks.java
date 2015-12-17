/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.protocol;

import java.util.Collection;
import org.lib.business.LibraryFacade;
import org.lib.model.MyBook;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public class DeleteBooks extends Command {

    private final Collection<MyBook> books;

    public DeleteBooks(Collection<MyBook> books) {
        this.books = books;
    }

    @Override
    public String execute(LibraryFacade f) throws LibException {
        f.deleteBooks(books);
        return OK;
    }

}
