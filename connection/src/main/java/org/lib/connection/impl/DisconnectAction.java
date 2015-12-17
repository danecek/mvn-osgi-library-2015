/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.connection.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.connection.Connection;
import org.lib.richclient.AbstractLibAction;
import org.lib.richclient.ActionsState;
import org.lib.richclient.MyAlert;
import org.lib.utils.LibException;
import org.lib.utils.Messages;

/**
 *
 * @author danecek
 */
public class DisconnectAction extends AbstractLibAction {

    public static final DisconnectAction instance = new DisconnectAction();

    private DisconnectAction() {
        super(Messages.Disconnect.createMess());
    }

    @Override
    public void execute() {
        try {
            Connection.instance.disconnect();
        } catch (LibException ex) {
            MyAlert.error(ex);
        }
        ActionsState.instance.dateChanged();
    }

    @Override
    public boolean testDisable() {
        return !Connection.instance.isConnected();
    }

}
