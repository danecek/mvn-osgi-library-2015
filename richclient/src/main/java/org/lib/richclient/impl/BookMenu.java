/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient.impl;

import javafx.scene.control.Menu;
import org.lib.utils.Messages;

/**
 *
 * @author danecek
 */
public class BookMenu extends Menu {

    public BookMenu() {
        super(Messages.Books.createMess());
        getItems().addAll(CreateBookAction.instance.genMenuItem(),
                DeleteBooksAction.instance.genMenuItem());
    }

}
