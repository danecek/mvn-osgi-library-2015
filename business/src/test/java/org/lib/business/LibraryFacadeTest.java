/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.business;

import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.lib.model.MyBook;
import org.lib.model.MyBookId;

/**
 *
 * @author danecek
 */
public class LibraryFacadeTest {

    public LibraryFacadeTest() {
    }

    @Test
    public void testSomeMethod() {
        LibraryFacade.instance.createBook(new MyBook(new MyBookId(1), "Macha", "Maj"));
        Collection<MyBook> books = LibraryFacade.instance.getAllBooks();
        System.out.println(books);
        assertTrue(books.contains(new MyBook(new MyBookId(1), "Macha", "Maj")));
    }

}
