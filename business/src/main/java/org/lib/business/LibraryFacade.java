/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.business;

import java.util.Collection;
import org.lib.integration.DAOFactory;
import org.lib.model.MyBook;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public class LibraryFacade {

    public static LibraryFacade instance = new LibraryFacade();

    private LibraryFacade() {
    }

    public void createBook(MyBook book) throws LibException {
        DAOFactory.service().getMyBookDAO().create(book);
    }

    public void createBook(String title, String author) throws LibException {
        DAOFactory.service().getMyBookDAO().create(title, author);
    }

    public Collection<MyBook> getAllBooks() throws LibException {
        return DAOFactory.service().getMyBookDAO().getAll();
    }

}
