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
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.lib.utils.Messages;

/**
 *
 * @author danecek
 */
public abstract class AbstractLibDialog extends Dialog<ButtonType> {

    public static class ErrorPanel extends HBox {

        private final Label errorLab;
        private final Text errorText;

        public void setError(String err) {
            errorText.setText(err);
            errorLab.setVisible(true);
        }

        public void clearError() {
            errorText.setText("");
            errorLab.setVisible(false);
        }

        public ErrorPanel() {
            errorLab = new Label(Messages.Error.createMess() + ':');
            errorText = new Text();
            errorLab.setVisible(false);
            errorLab.setLabelFor(errorText);
            errorLab.setTextFill(Color.RED);

            getChildren().addAll(errorLab, errorText);
            setSpacing(5);
            errorText.setFill(Color.RED);

        }

    }

    protected ErrorPanel errorPanel = new ErrorPanel();

    public AbstractLibDialog(String title) {
        setTitle(title);
        getDialogPane().setContent(new VBox(createContent(),
                errorPanel));
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        validate();
    }

    public AbstractLibDialog() {
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
