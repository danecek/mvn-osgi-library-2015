/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.integration;

import org.lib.integration.impl.DefaultDAOFactory;

/**
 *
 * @author danecek
 */
public abstract class DAOFactory {

    private static DefaultDAOFactory instance;

    public static DAOFactory service() {
        if (instance == null) {
            instance = new DefaultDAOFactory();
        }
        return instance;
    }

    public abstract MyBookDAO getMyBookDAO();

}
