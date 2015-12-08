/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.protocol;

import java.util.Collection;
import org.lib.business.LibraryFacade;
import org.lib.model.MyBook;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public class GetAllBooks extends Command {


    public GetAllBooks() {

    }

    @Override
    Collection<MyBook> execute(LibraryFacade f) throws LibException {
        return f.getAllBooks();
    }

}
