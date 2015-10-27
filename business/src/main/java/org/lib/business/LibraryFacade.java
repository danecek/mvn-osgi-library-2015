/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.business;

import org.lib.integration.DAOFactory;
import org.lib.model.MyBook;

/**
 *
 * @author danecek
 */
public class LibraryFacade {

    void create(MyBook book) {
        DAOFactory.service().getMyBookDAO().create(book);
    }

}
