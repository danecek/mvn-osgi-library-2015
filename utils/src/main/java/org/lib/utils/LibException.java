package org.lib.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author danecek
 */
public class LibException extends Exception {

    public LibException(Throwable cause) {
        super(cause);
    }

    public LibException(String message) {
        super(message);
    }

}
