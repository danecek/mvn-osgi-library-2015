/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient;

import java.util.Observable;

/**
 *
 * @author danecek
 */
public class ActionsState extends Observable {

    public static ActionsState instance = new ActionsState();

    public void dateChanged() {
        this.setChanged();
        this.notifyObservers();
    }

}
