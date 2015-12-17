/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient.impl;

import org.lib.business.LibraryFacade;
import org.lib.richclient.AbstractLibAction;
import org.lib.richclient.MainWindow;
import org.lib.utils.Messages;

/**
 *
 * @author danecek
 */
public class DeleteBooksAction extends AbstractLibAction {

    public static DeleteBooksAction instance = new DeleteBooksAction();

    private DeleteBooksAction() {
        super(Messages.Delete_Books.createMess());
    }

    @Override
    public boolean testDisable() {
        return MainWindow.instance.getBookPanel().selectedBooks().isEmpty()
                || !LibraryFacade.getService().isAvailable();
    }

    @Override
    public void execute() {
        new DeleteBooksDialog().execute();
    }

}
