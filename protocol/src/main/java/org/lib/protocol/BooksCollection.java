package org.lib.protocol;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import org.lib.model.MyBook;

@XmlRootElement
public class BooksCollection implements Serializable {

    private List<MyBook> books;

    public BooksCollection(List<MyBook> books) {
        this.books = books;
    }

    public BooksCollection() {
    }

    /**
     * @return the books
     */
    public List<MyBook> getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(List<MyBook> books) {
        this.books = books;
    }

}
