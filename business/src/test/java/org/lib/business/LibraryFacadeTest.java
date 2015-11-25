/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.business;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.lib.model.MyBook;
import org.lib.model.MyBookId;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public class LibraryFacadeTest {

    public LibraryFacadeTest() {
    }

    @Test
    public void testSomeMethod() {
        try {
            LibraryFacade.instance.createBook(new MyBook(new MyBookId(1), "Macha", "Maj"));
            Collection<MyBook> books = LibraryFacade.instance.getAllBooks();
            System.out.println(books);
            assertTrue(books.contains(new MyBook(new MyBookId(1), "Macha", "Maj")));
        } catch (LibException ex) {
            Logger.getLogger(LibraryFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
