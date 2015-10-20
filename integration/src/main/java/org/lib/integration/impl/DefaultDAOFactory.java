/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.integration.impl;

import org.lib.integration.DAOFactory;
import org.lib.integration.MyBookDAO;

/**
 *
 * @author danecek
 */
public class DefaultDAOFactory  extends DAOFactory{

    @Override
    public MyBookDAO getMyBookDAO() {
        return new DefaultMyBookDAO();
    }
    
}
