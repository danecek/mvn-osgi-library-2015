/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.lib.business.LibraryFacade;
import org.lib.utils.LibException;

public class CreateBookDialog extends AbstractLibDialog {
    
    private ValidatedTextField title;
    private ValidatedTextField author;
    
    public CreateBookDialog() {
        super("Create Book");        
    }
    
    protected Node createContent() {
        GridPane gp = new GridPane();
        gp.add(new Label("Title:"), 0, 0);
        gp.add(title = new ValidatedTextField(this), 1, 0);
        gp.add(new Label("Author:"), 0, 1);
        gp.add(author = new ValidatedTextField(this), 1, 1);
        return gp;
    }
    
    protected void ok() {
        try {
            LibraryFacade.instance.createBook(title.getText(), author.getText());
            PersistentDateState.instance.dateChanged();
        } catch (LibException ex) {
            Logger.getLogger(CreateBookDialog.class.getName()).log(Level.SEVERE, null, ex);
            MyAlert.error(ex.toString());
        }
    }
    
    public void validate() {
        boolean error = false;
        getDialogPane().lookupButton(ButtonType.OK).setDisable(false);
        if (title.getText().isEmpty()) {
            errorText.setText("title is empty");
            error = true;
        }
        if (author.getText().isEmpty()) {
            errorText.setText("author is empty");
            error = true;
        }
        if (!error) {
            errorText.setText("");
        }
        getDialogPane().lookupButton(ButtonType.OK).setDisable(error);
        
    }
    
}
