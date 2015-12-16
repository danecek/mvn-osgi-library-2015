/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.connection.impl;

import org.lib.richclient.AbstractLibAction;
import org.lib.utils.Messages;

/**
 *
 * @author danecek
 */
public class ConnectAction extends AbstractLibAction {

    public static final ConnectAction instance = new ConnectAction();

    private ConnectAction() {
        super(Messages.Connect.createMess());
    }

    @Override
    public void execute() {
        new ConnectDialog().execute();
    }

}
