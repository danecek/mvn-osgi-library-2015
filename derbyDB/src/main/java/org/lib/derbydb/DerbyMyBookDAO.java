/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.derbydb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.integration.MyBookDAO;
import org.lib.model.MyBook;
import org.lib.model.MyBookId;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public class DerbyMyBookDAO implements MyBookDAO {

    private PreparedStatement getAllPS;
    private PreparedStatement createBookPS;
    private PreparedStatement deleteBookPS;

    public DerbyMyBookDAO(Connection conn) {
        try {
            getAllPS = conn.prepareStatement("SELECT * FROM BOOKS");
            createBookPS = conn.prepareStatement("INSERT INTO BOOKS VALUES(DEFAULT, ?, ?)");
            deleteBookPS = conn.prepareStatement("DELETE FROM  BOOKS WHERE ID=?");
        } catch (SQLException ex) {
            Logger.getLogger(DerbyMyBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(String title, String author) throws LibException {
        try {
            createBookPS.setString(1, title);
            createBookPS.setString(2, author);
            createBookPS.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DerbyMyBookDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new LibException(ex);
        }

    }

    @Override
    public Collection<MyBook> getAll() throws LibException {
        List<MyBook> books = new ArrayList<>();
        try {

            ResultSet rs = getAllPS.executeQuery();
            while (rs.next()) {
                books.add(new MyBook(new MyBookId(rs.getInt(1)), rs.getString(2),
                        rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DerbyMyBookDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new LibException(ex);
        }
        return books;

    }

    @Override
    public void delete(MyBookId id) throws LibException {
        try {
            deleteBookPS.setInt(1, id.getId());
        } catch (SQLException ex) {
            Logger.getLogger(DerbyMyBookDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new LibException(ex);
        }
    }

}
