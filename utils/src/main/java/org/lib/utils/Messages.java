/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.utils;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 *
 * @author danecek
 */
public enum Messages {
    Connect,
    Connection,
    Create_Book,
    Delete_Books,
    Library,
    Disconnect,
    Not_connected,
    Exit,
    Books,
    Id,
    Author,
    Title,
    Host,
    Port,
    Empty_title,
    Empty_author,
    Invalid_port,
    Invalid_host,
    Error;

    public String createMess(Object... args) {
        try {
            ResourceBundle rb = ResourceBundle.getBundle("org.lib.utils.bundle");
            return MessageFormat.format(rb.getString(name()), args);
        } catch (MissingResourceException mrex) {
            Logger.getLogger(getClass().getName()).fine(mrex.toString());
            return name().replaceAll("_", " ");
        }
    }

}
