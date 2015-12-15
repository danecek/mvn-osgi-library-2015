/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.connection;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.lib.richclient.AbstractLibDialog;
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
        gp.add(host = new ValidatedTextField(this), 1, 0);
        gp.add(new Label("Port:"), 0, 1);
        gp.add(port = new ValidatedTextField(this), 1, 1);
        return gp;
    }

    protected void ok() {
//        Connection.instance.connect(new InetAddress(host.getText()),
//                Integer.parseInt(port.getText()));

    }

    public void validate() {
        boolean error = false;

        getDialogPane().lookupButton(ButtonType.OK).setDisable(error);

    }

}
