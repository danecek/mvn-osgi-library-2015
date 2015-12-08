/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

/**
 *
 * @author danecek
 */
public abstract class AbstractLibAction implements Observer {

//    interface Disable {
//
//        public void setDisable(boolean b);
//    }
    private String name;
  //  Collection<Disable> items = new ArrayList<>();

    public AbstractLibAction(String name) {
        this.name = name;
        ActionsState.instance.addObserver(this);
    }

    public MenuItem genMenuItem() {
        MenuItem mi = new MenuItem(name);
     //   items.add((Disable) mi);
        mi.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                execute();
            }
        });
        return mi;
    }

    public Button genButton() {
        Button mi = new Button(name);
     //   items.add((Disable) mi);
        mi.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                execute();
            }
        });
        return mi;
    }

    boolean isDisable() {
        return false;
    }

    @Override
    public void update(Observable o, Object arg) {
        boolean id = isDisable();
//        for (Disable item : items) {
//            item.setDisable(id);
//        }
    }

    public abstract void execute();

}
