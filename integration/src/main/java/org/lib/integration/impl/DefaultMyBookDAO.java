/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.integration.impl;

import org.lib.integration.MyBookDAO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.lib.model.MyBook;
import org.lib.model.MyBookId;

/**
 *
 * @author danecek
 */
public class DefaultMyBookDAO implements MyBookDAO {

    Map<MyBookId, MyBook> books = new HashMap<>();
    private Integer counter=2;

    public DefaultMyBookDAO() {
        create(new MyBook(new MyBookId(1), "Macha", "Maj"));
    }

    @Override
    public void create(MyBook book) {
        books.put(book.getId(), book);
    }

    @Override
    public Collection<MyBook> getAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public void create(String title, String author) {
        create(new MyBook(new MyBookId(counter++), title, author));
    }
}
