/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient.impl;

import javafx.scene.control.Menu;

/**
 *
 * @author danecek
 */
public class BooksMenu extends Menu {

    public BooksMenu() {
        super("Books"); //
        getItems().addAll(CreateBookAction.instance.genMenuItem());
    }

}
