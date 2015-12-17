/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient.impl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import org.lib.business.LibraryFacade;
import org.lib.model.MyBook;
import org.lib.richclient.AbstractLibDialog;
import org.lib.richclient.ActionsState;
import org.lib.richclient.MainWindow;
import org.lib.richclient.MyAlert;
import org.lib.richclient.PersistentDateState;
import org.lib.utils.LibException;
import org.lib.utils.Messages;

public class DeleteBooksDialog extends AbstractLibDialog {

    private static final Logger LOG = Logger.getLogger(DeleteBooksDialog.class.getName());

    public DeleteBooksDialog() {
        super(Messages.Delete_Books.createMess());
    }

    @Override
    protected Node createContent() {
        ListView<MyBook> lv = new ListView<>(MainWindow.instance.getBookPanel().selectedBooks());
        lv.setSelectionModel(new MultipleSelectionModel<MyBook>() {

            {
                super.setSelectedIndex(-1);
                super.setSelectedItem(null);
            }

            @Override
            public ObservableList<Integer> getSelectedIndices() {
                return FXCollections.emptyObservableList();
            }

            @Override
            public ObservableList<MyBook> getSelectedItems() {
                return FXCollections.emptyObservableList();
            }

            @Override
            public void selectIndices(int index, int... indices) {
            }

            @Override
            public void selectAll() {
            }

            @Override
            public void selectFirst() {
            }

            @Override
            public void selectLast() {
            }

            @Override
            public void clearAndSelect(int i) {
            }

            @Override
            public void select(int i) {
            }

            @Override
            public void select(MyBook t) {
            }

            @Override
            public void clearSelection(int i) {
            }

            @Override
            public void clearSelection() {
            }

            @Override
            public boolean isSelected(int i) {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return true;
            }

            @Override
            public void selectPrevious() {
            }

            @Override
            public void selectNext() {
            }
        });

        return lv;
    }

    @Override
    protected void ok() {
        try {
            LibraryFacade.getService().deleteBooks(
                    new ArrayList(MainWindow.instance.getBookPanel().selectedBooks()));
            PersistentDateState.instance.dateChanged();
            ActionsState.instance.dateChanged();
        } catch (LibException ex) {
            LOG.log(Level.SEVERE, null, ex);
            MyAlert.error(ex);
        }
    }

    @Override
    public void validate() {
    }

}
