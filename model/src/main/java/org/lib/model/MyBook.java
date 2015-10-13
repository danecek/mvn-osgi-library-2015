/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.model;

/**
 *
 * @author danecek
 */
public class MyBook {

    private final MyBookId id;
    private final String title;
    private final String author;

    public MyBook(MyBookId id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    /**
     * @return the id
     */
    public MyBookId getId() {
        return id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

}
