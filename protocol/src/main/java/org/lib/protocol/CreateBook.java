package org.lib.protocol;

import javax.xml.bind.annotation.XmlRootElement;
import org.lib.business.LibraryFacade;
import org.lib.utils.LibException;

@XmlRootElement
public class CreateBook extends Command {

    private String title;
    private String author;

    public CreateBook() {
    }

    public CreateBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public Object execute(LibraryFacade f) throws LibException {
        f.createBook(getTitle(), getAuthor());
        return OK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
