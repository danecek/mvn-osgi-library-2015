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
public class CreateBookAction extends AbstractLibAction {
    
    public static CreateBookAction instance = new CreateBookAction();
    
    private CreateBookAction() {
        super(Messages.Create_Book.createMess());
    }
    
    @Override
    public void execute() {
        new CreateBookDialog().execute();
    }
    
}
