/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient.impl;

import org.lib.richclient.AbstractLibAction;
import org.lib.richclient.MainWindow;

/**
 *
 * @author danecek
 */
public class ExitAction extends AbstractLibAction {

    public static ExitAction instance = new ExitAction();

    private ExitAction() {
        super("Exit");
    }

    @Override
    public void execute() {
        MainWindow.instance.stop();
     }

}
