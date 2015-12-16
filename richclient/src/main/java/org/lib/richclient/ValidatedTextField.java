/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author danecek
 */
public class ValidatedTextField extends TextField {

    public ValidatedTextField(AbstractLibDialog createBookDialog) {
        this(createBookDialog, "");
    }

    public ValidatedTextField(AbstractLibDialog createBookDialog, String text) {
        super(text);
        setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                createBookDialog.validate();
            }
        });
    }

}
