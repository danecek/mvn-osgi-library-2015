/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.proxy;



import java.util.Collection;
import org.lib.business.LibraryFacade;
import org.lib.connection.Connection;
import org.lib.model.MyBook;
import org.lib.protocol.CreateBook;
import org.lib.protocol.GetAllBooks;
import org.lib.utils.LibException;
import static org.lib.connection.Connection.instance;

/**
 *
 * @author danecek
 */
public class LibraryFacadeProxy extends LibraryFacade {

    @Override
    public void createBook(MyBook book) throws LibException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createBook(String title, String author) throws LibException {
        instance.send(new CreateBook(title, author));
    }

    @Override
    public Collection<MyBook> getAllBooks() throws LibException {
        return instance.send(new GetAllBooks());
    }

    @Override
    public boolean facadeAvailable() {
        return Connection.instance.isConnected();
    }

}
