/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.integration;

import java.util.Collection;
import org.lib.model.MyBook;
import org.lib.model.MyBookId;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public interface MyBookDAO {

    void create(String title, String author) throws LibException;

    Collection<MyBook> getAll() throws LibException;

    void delete(MyBookId id) throws LibException;

}
