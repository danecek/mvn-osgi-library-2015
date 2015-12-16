/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.connection.impl;

import org.lib.connection.impl.ConnectAction;
import javafx.scene.control.Menu;
import org.lib.utils.Messages;

/**
 *
 * @author danecek
 */
public class ConnectionMenu extends Menu {

    public ConnectionMenu() {
        super(Messages.Connection.createMess());
        this.getItems().addAll(ConnectAction.instance.genMenuItem());
    }

}
