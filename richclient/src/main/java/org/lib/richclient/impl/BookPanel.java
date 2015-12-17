/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient.impl;

import java.util.Collection;
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
import org.lib.business.LibraryFacade;
import org.lib.model.MyBook;
import org.lib.model.MyBookId;
import org.lib.richclient.ActionsState;
import org.lib.richclient.MyAlert;
import org.lib.richclient.PersistentDateState;
import org.lib.utils.LibException;
import static org.lib.utils.Messages.*;

/**
 *
 * @author danecek
 */
public class BookPanel extends TitledPane implements Observer {

    private static final Logger LOG = Logger.getLogger(BookPanel.class.getName());

    ObservableList<MyBook> books = FXCollections.observableArrayList();
    private TableView<MyBook> table;

    private TableView<MyBook> createTable() {
        TableView<MyBook> table = new TableView<MyBook>();
        TableColumn<MyBook, MyBookId> idCol
                = new TableColumn<>(Id.createMess());
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<MyBook, MyBookId> authorCol
                = new TableColumn<>(Author.createMess());
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        TableColumn<MyBook, MyBookId> titleCol
                = new TableColumn<>(Title.createMess());
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        table.getColumns().addAll(idCol, authorCol, titleCol);
        table.setItems(books);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getSelectionModel().getSelectedItems().
                addListener(new ListChangeListener<MyBook>() {
                    @Override
                    public void onChanged(ListChangeListener.Change<? extends MyBook> changed) {
                        ActionsState.instance.dateChanged();
                    }
                });
        return table;
    }

    public BookPanel() {
        super(Books.createMess(), null);
        table = createTable();
        setContent(table);
        PersistentDateState.instance.addObserver(this);
        refresh();
    }

    public void refresh() {
        try {
            if (LibraryFacade.getService().isAvailable()) {
                Collection<MyBook> allbooks = LibraryFacade.getService().getAllBooks();
                books.clear();
                books.addAll(allbooks);
            }
        } catch (LibException ex) {
            MyAlert.error(ex.toString());
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        refresh();
    }

    public TableView<MyBook> getTable() {
        return table;
    }

    ObservableList<MyBook> selectedBooks() {
        return table.getSelectionModel().getSelectedItems();
    }

}
