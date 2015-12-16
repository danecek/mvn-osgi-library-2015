/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.connection.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.lib.connection.Connection;
import org.lib.richclient.AbstractLibDialog;
import org.lib.richclient.MyAlert;
import org.lib.richclient.ValidatedTextField;
import org.lib.utils.Messages;

public class ConnectDialog extends AbstractLibDialog {
    
    private ValidatedTextField host;
    private ValidatedTextField port;
    
    public ConnectDialog() {
        super(Messages.Connect.createMess());
    }
    
    protected Node createContent() {
        GridPane gp = new GridPane();
        gp.setVgap(5);
        gp.setHgap(5);
        gp.setPadding(new Insets(5));
        gp.add(new Label("Host:"), 0, 0);
        gp.add(host = new ValidatedTextField(this, "localhost"), 1, 0);
        gp.add(new Label("Port:"), 0, 1);
        gp.add(port = new ValidatedTextField(this, "3333"), 1, 1);
        return gp;
    }
    
    @Override
    protected void ok() {
        try {
            Connection.instance.connect(InetAddress.getByName(host.getText()),
                    Integer.parseInt(port.getText()));
        } catch (IOException ex) {
            MyAlert.error(ex);
        }
        
    }
    
    @Override
    public void validate() {
        boolean error = false;
        
        getDialogPane().lookupButton(ButtonType.OK).setDisable(error);
        
    }
    
}
