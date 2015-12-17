/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.derbydb;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private static final Logger LOG = Logger.getLogger(DerbyDBDAOFactory.class.getName());
    
    public DerbyDBDAOFactory() {
        try {
            new EmbeddedDriver();
            String url = "jdbc:derby:" + System.getProperty("user.home") + "/libraryDB; create=true";
            conn = DriverManager.getConnection(url);
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, "BOOKS", null);
            if (!rs.next()) {
                LOG.info("CREATE TABLE BOOKS");
                Statement stm = conn.createStatement();
                stm.executeUpdate("CREATE TABLE BOOKS"
                        + "(ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,"
                        + "TITLE   VARCHAR(50),"
                        + "AUTHOR  VARCHAR(50),"
                        + "PRIMARY KEY (ID))");
                
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public MyBookDAO getMyBookDAO() {
        return new DerbyMyBookDAO(conn);
    }
    
}
