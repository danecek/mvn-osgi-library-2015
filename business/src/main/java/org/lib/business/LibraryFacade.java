/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.business;

import java.util.Collection;
import org.lib.integration.DAOFactory;
import org.lib.model.MyBook;

/**
 *
 * @author danecek
 */
public class LibraryFacade {

    public static LibraryFacade instance = new LibraryFacade();

    private LibraryFacade() {
    }

    public void createBook(MyBook book) {
        DAOFactory.service().getMyBookDAO().create(book);
    }

    public void createBook(String title, String author) {
        DAOFactory.service().getMyBookDAO().create(title, author);
    }

    public Collection<MyBook> getAllBooks() {
        return DAOFactory.service().getMyBookDAO().getAll();
    }

}
