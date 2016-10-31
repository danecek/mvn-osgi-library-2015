package org.lib.richclient.impl;

import org.lib.richclient.AbstractLibAction;
import org.lib.richclient.MainWindow;
import org.lib.utils.Messages;

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
