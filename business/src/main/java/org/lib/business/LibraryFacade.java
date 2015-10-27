/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.business;

import org.lib.integration.DAOFactory;

/**
 *
 * @author danecek
 */
public class LibraryFacade {
    
    void create() {
        DAOFactory.service().getMyBookDAO().create(null);
    }
    
}
