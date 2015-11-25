/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.derbydb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.EmbeddedDriver;
import org.lib.integration.DAOFactory;
import org.lib.integration.MyBookDAO;

/**
 *
 * @author danecek
 */
public class DerbyDBDAOFactory extends DAOFactory {

    Connection conn;

    public DerbyDBDAOFactory() {
        try {
            new EmbeddedDriver();
            String url = "jdbc:derby:" + System.getProperty("user.home") + "/libraryDB; create=true";
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(DerbyDBDAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public MyBookDAO getMyBookDAO() {
        return new DerbyMyBookDAO(conn);
    }

}
