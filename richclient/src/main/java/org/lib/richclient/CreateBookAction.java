/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient;

/**
 *
 * @author danecek
 */
public class CreateBookAction extends AbstractLibAction {

    public static CreateBookAction instance = new CreateBookAction();

    private CreateBookAction() {
        super("Create Book");
    }

    @Override
    public void execute() {
        new CreateBookDialog().execute();
    }

}
