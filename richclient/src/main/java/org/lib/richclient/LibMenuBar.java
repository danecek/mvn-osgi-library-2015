/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient;

import javafx.scene.control.MenuBar;

/**
 *
 * @author danecek
 */
public class LibMenuBar extends MenuBar {

    public LibMenuBar() {
        getMenus().addAll(new FilesMenu());
    }
    
}
