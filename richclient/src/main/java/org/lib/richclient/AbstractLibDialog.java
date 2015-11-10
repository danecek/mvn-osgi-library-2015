/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient;


import java.util.Optional;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author danecek
 */
public abstract class AbstractLibDialog extends Dialog<ButtonType> {

    Text errorText = new Text();

    public AbstractLibDialog(String title) {
        setTitle(title);
        errorText.setFill(Color.RED);
        getDialogPane().setContent(new VBox(createContent(), errorText));
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        validate();
    }

    protected abstract Node createContent();

    public void execute() {
        Optional<ButtonType> result = showAndWait();
        ButtonType bt = result.get();
        if (bt.getButtonData().isCancelButton()) {
            return;
        }
        ok();
    }

    protected abstract void ok();

    public abstract void validate();

}
