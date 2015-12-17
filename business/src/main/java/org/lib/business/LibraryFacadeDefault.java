/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.business;

import java.util.Collection;
import org.lib.integration.DAOFactory;
import org.lib.model.MyBook;
import org.lib.model.MyBookId;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public class LibraryFacadeDefault extends LibraryFacade {

    @Override
    public void createBook(String title, String author) throws LibException {
        DAOFactory.service().getMyBookDAO().create(title, author);
    }

    @Override
    public Collection<MyBook> getAllBooks() throws LibException {
        return DAOFactory.service().getMyBookDAO().getAll();
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public void deleteBooks(Collection<MyBook> books) throws LibException {
        for (MyBook book : books) {
            DAOFactory.service().getMyBookDAO().delete(book.getId());
        }
    }

}
