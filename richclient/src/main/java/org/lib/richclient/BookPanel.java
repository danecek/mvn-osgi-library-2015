/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import org.lib.business.LibraryFacade;
import org.lib.model.MyBook;
import org.lib.model.MyBookId;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public class BookPanel extends TitledPane implements Observer {
    
    ObservableList<MyBook> books = FXCollections.observableArrayList();
    
    Node createTable() {
        TableView<MyBook> table = new TableView<>();
        
        TableColumn<MyBook, MyBookId> idCol = new TableColumn<>("Id");  // todo lok
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<MyBook, MyBookId> authorCol = new TableColumn<>("Author");  // todo lok
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        TableColumn<MyBook, MyBookId> titleCol = new TableColumn<>("Title");  // todo lok
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        table.getColumns().addAll(idCol, authorCol, titleCol);
        table.setItems(books);
        return table;
    }
    
    public BookPanel() {
        super("Books", null);
        setContent(createTable());
        PersistentDateState.instance.addObserver(this);
        refresh();
    }
    
    public void refresh() {
        try {
            Collection<MyBook> allbooks = LibraryFacade.instance.getAllBooks();
            books.clear();
            books.addAll(allbooks);
        } catch (LibException ex) {
            MyAlert.error(ex.toString());
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
        refresh();
    }
    
}
