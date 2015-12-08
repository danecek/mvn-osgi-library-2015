/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient.impl;

import org.lib.richclient.AbstractLibAction;
import org.lib.utils.Messages;

/**
 *
 * @author danecek
 */
public class DeleteBookAction extends AbstractLibAction {
    
    public static DeleteBookAction instance = new DeleteBookAction();
    
    private DeleteBookAction() {
        super(Messages.Delete_Book.createMess());
    }

//    @Override
//    boolean isDisable() {
//      return  BookPanel.getInstance().getTable().getSelectionModel().getSelectedItems().isEmpty();
//    }
    
    @Override
    public void execute() {
       // new CreateBookDialog().execute();
    }
    
}
