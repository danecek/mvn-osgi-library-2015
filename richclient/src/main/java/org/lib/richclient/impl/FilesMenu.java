package org.lib.richclient.impl;

import javafx.scene.control.Menu;
import org.lib.utils.Messages;

public class FilesMenu extends Menu {

    public FilesMenu() {
        super(Messages.Files.createMess());
        getItems().addAll(ExitAction.instance.genMenuItem());
    }

}
