/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.integration;

import org.lib.integration.impl.DefaultDAOFactory;
import org.osgi.util.tracker.ServiceTracker;

/**
 *
 * @author danecek
 */
public abstract class DAOFactory {

    private static DAOFactory instance;
    private static ServiceTracker<DAOFactory, DAOFactory> st;

    public static DAOFactory service() {
        if (instance == null) {
            instance = st.getService();
            if (instance == null) {
                instance = new DefaultDAOFactory();
            }
        }
        return instance;
    }

    static void setSt(ServiceTracker<DAOFactory, DAOFactory> stp) {
        st = stp;
    }

    public abstract MyBookDAO getMyBookDAO();

}
