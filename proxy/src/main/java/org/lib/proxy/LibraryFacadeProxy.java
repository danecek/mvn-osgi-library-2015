/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.proxy;

import org.lib.protocol.DeleteBooks;
import java.util.Collection;
import org.lib.business.LibraryFacade;
import org.lib.connection.Connection;
import org.lib.model.MyBook;
import org.lib.protocol.CreateBook;
import org.lib.protocol.GetAllBooks;
import org.lib.utils.LibException;
import static org.lib.connection.Connection.instance;
import org.lib.model.MyBookId;

/**
 *
 * @author danecek
 */
public class LibraryFacadeProxy extends LibraryFacade {

    @Override
    public void createBook(String title, String author) throws LibException {
        instance.send(new CreateBook(title, author));
    }

    @Override
    public Collection<MyBook> getAllBooks() throws LibException {
        return instance.send(new GetAllBooks());
    }

    @Override
    public boolean isAvailable() {
        return Connection.instance.isConnected();
    }

    @Override
    public void deleteBooks(Collection<MyBook> books) throws LibException {
        instance.send(new DeleteBooks(books));
    }

}
