/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient.impl;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import org.lib.model.MyReader;
import org.lib.model.MyReaderId;
import org.lib.richclient.ActionsState;
import org.lib.richclient.PersistentDateState;
import static org.lib.utils.Messages.*;

/**
 *
 * @author danecek
 */
public class ReaderPanel extends TitledPane implements Observer {

    private static final Logger LOG = Logger.getLogger(ReaderPanel.class.getName());

    ObservableList<MyReader> books = FXCollections.observableArrayList();
    private TableView<MyReader> table;

    private TableView<MyReader> createTable() {
        TableView<MyReader> table = new TableView<MyReader>();
        TableColumn<MyReader, MyReaderId> idCol
                = new TableColumn<>(Id.createMess());
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<MyReader, MyReaderId> nameCol
                = new TableColumn<>(Name.createMess());
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().addAll(idCol, nameCol);
        table.setItems(books);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getSelectionModel().getSelectedItems().
                addListener(new ListChangeListener<MyReader>() {
                    @Override
                    public void onChanged(ListChangeListener.Change<? extends MyReader> changed) {
                        ActionsState.instance.dateChanged();
                    }
                });
        return table;
    }

    public ReaderPanel() {
        super(Readers.createMess(), null);
        table = createTable();
        setContent(table);
        PersistentDateState.instance.addObserver(this);
        refresh();
    }

    public void refresh() {
//        try {
//            if (LibraryFacade.getService().isAvailable()) {
//     //           Collection<MyReader> allbooks = LibraryFacade.getService().getAllBooks();
//                books.clear();
//       //         books.addAll(allbooks);
//            }
//        } catch (LibException ex) {
//            MyAlert.error(ex.toString());
//        }
    }

    @Override
    public void update(Observable o, Object arg) {
        refresh();
    }

    public TableView<MyReader> getTable() {
        return table;
    }

    ObservableList<MyReader> selectedBooks() {
        return table.getSelectionModel().getSelectedItems();
    }

}
