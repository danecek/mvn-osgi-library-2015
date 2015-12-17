/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient.impl;

import org.lib.richclient.AbstractLibAction;
import org.lib.richclient.MainWindow;
import org.lib.utils.Messages;

/**
 *
 * @author danecek
 */
public class ExitAction extends AbstractLibAction {

    public static ExitAction instance = new ExitAction();

    private ExitAction() {
        super(Messages.Exit.createMess());
    }

    @Override
    public void execute() {
        MainWindow.instance.stop();
    }

}
