/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author danecek
 */
public class MyBook implements Serializable {

    public MyBookId id;
    public String title;
    public String author;

    public MyBook(MyBookId id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public MyBook() {
    }

    public MyBookId getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + author + ": " + title;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyBook other = (MyBook) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
