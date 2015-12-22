/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient;

import org.lib.richclient.impl.BookPanel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.lib.richclient.impl.BookMenu;
import org.lib.richclient.impl.CreateBookAction;
import org.lib.richclient.impl.DeleteBooksAction;
import org.lib.richclient.impl.FilesMenu;
import org.lib.utils.Messages;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;

/**
 *
 * @author danecek
 */
public class MainWindow extends Stage {

    public static MainWindow instance = new MainWindow();

    private BundleContext context;
    private final MenuBar libMenuBar;
    private final ToolBar libToolBar;
    private final BookPanel bookPanel;

    public void stop() {
        Bundle sb = context.getBundle(0);
        Framework f = (Framework) sb;
        try {
            f.stop(1000);
        } catch (BundleException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private MainWindow() {
        setTitle(Messages.Library.createMess());
        setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent event) {
                stop();
            }
        });
        libMenuBar = new MenuBar(new FilesMenu(), new BookMenu());
        libToolBar = new ToolBar(
                CreateBookAction.instance.genButton(),
                DeleteBooksAction.instance.genButton()
        );
        bookPanel = new BookPanel();
        VBox root = new VBox(libMenuBar, getLibToolBar(),
                new SplitPane(bookPanel, bookPanel));
        Scene s = new Scene(root, 800, 600);
        setScene(s);
        show();
    }

    /**
     * @param context the context to set
     */
    public void setContext(BundleContext context) {
        this.context = context;
    }

    /**
     * @return the libMenuBar
     */
    public MenuBar getLibMenuBar() {
        return libMenuBar;
    }

    /**
     * @return the libToolBar
     */
    public ToolBar getLibToolBar() {
        return libToolBar;
    }

    /**
     * @return the bookPanel
     */
    public BookPanel getBookPanel() {
        return bookPanel;
    }

    public void refresh() {

    }

}
