/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.lib.business.LibraryFacade;
import org.lib.richclient.AbstractLibDialog;
import org.lib.richclient.MyAlert;
import org.lib.richclient.PersistentDateState;
import org.lib.richclient.ValidatedTextField;
import org.lib.utils.LibException;
import static org.lib.utils.Messages.*;

public class CreateBookDialog extends AbstractLibDialog {
    
    private ValidatedTextField title;
    private ValidatedTextField author;
    
    public CreateBookDialog() {
        super(Create_Book.createMess());
    }
    
    @Override
    protected Node createContent() {
        GridPane gp = new GridPane();
        gp.setVgap(5);
        gp.setHgap(5);
        gp.setPadding(new Insets(5));
        gp.add(new Label(Title.createMess() + ":"), 0, 0);
        gp.add(title = new ValidatedTextField(this), 1, 0);
        gp.add(new Label(Author.createMess() + ":"), 0, 1);
        gp.add(author = new ValidatedTextField(this), 1, 1);
        return gp;
    }
    
    protected void ok() {
        try {
            LibraryFacade.getService().createBook(title.getText(), author.getText());
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
            errorPanel.setError(Empty_title.createMess());
            error = true;
        }
        if (author.getText().isEmpty()) {
             errorPanel.setError(Empty_author.createMess());
            error = true;
        }
        if (!error) {
            errorPanel.clearError();
        }
        getDialogPane().lookupButton(ButtonType.OK).setDisable(error);
        
    }
    
}
