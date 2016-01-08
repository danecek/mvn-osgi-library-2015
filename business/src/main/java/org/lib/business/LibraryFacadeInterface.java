/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.business;

import java.util.Collection;
import org.lib.model.MyBook;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public interface LibraryFacadeInterface {

    void createBook(String title, String author) throws LibException;

    void deleteBooks(Collection<MyBook> books) throws LibException;

    Collection<MyBook> getAllBooks() throws LibException;

    boolean isAvailable();
    
}
