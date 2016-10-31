package org.lib.protocol;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import org.lib.business.LibraryFacade;
import org.lib.business.LibraryFacadeInterface;
import org.lib.utils.LibException;

@XmlRootElement
public class GetAllBooks extends Command {

    public GetAllBooks() {
    }

    @Override
    public BooksCollection execute(LibraryFacadeInterface f) throws LibException {
        return new BooksCollection(new ArrayList(f.getAllBooks()));
    }

}
