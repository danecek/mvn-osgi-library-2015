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

public final class DefaultMyBookDAO implements MyBookDAO {

    Map<MyBookId, MyBook> books = new HashMap<>();
    private Integer counter = 2;

    public DefaultMyBookDAO() {
        create("Macha", "Maj");
    }

    @Override
    public Collection<MyBook> getAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public void create(String title, String author) {
        MyBook b = new MyBook(new MyBookId(counter++), title, author);
        books.put(b.getId(), b);
    }

    @Override
    public void delete(MyBookId id) {
        books.remove(id);
    }
}
