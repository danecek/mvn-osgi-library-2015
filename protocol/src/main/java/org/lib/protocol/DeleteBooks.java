/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.protocol;

import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import org.lib.business.LibraryFacade;
import org.lib.model.MyBook;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
@XmlRootElement
public class DeleteBooks extends Command {

    private Collection<MyBook> books;

    public DeleteBooks() {
    }

    public DeleteBooks(Collection<MyBook> books) {
        this.books = books;
    }

    @Override
    public Ok execute(LibraryFacade f) throws LibException {
        f.deleteBooks(getBooks());
        return OK;
    }

    /**
     * @return the books
     */
    public Collection<MyBook> getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(Collection<MyBook> books) {
        this.books = books;
    }

}
