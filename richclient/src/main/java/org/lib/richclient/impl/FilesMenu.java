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
public class FilesMenu extends Menu {

    public FilesMenu() {
        super("Files"); //
        getItems().addAll(ExitAction.instance.genMenuItem());
    }

}
