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
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;

/**
 *
 * @author danecek
 */
public class MainWindow extends Stage {

    /**
     * @return the instance
     */
    public static MainWindow getInstance() {
        if (instance == null)
            instance = new MainWindow();
        return instance;
    }

    private BundleContext context;

    private static MainWindow instance;

//    static {
//        new JFXPanel();
//        Platform.runLater(new Runnable() {
//
//            @Override
//            public void run() {
//                MainWindow.instance = new MainWindow();
//            }
//        });
//    }

    public void stop() {
        Bundle sb = context.getBundle(0);
        Framework f = (Framework) sb;
        try {
            f.stop();
        } catch (BundleException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        // hide();

    }

    private LibMenuBar libMenuBar;

    private MainWindow() {
        setTitle("Library");
        setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent event) {
                stop();
            }
        });
        VBox root = new VBox(libMenuBar = new LibMenuBar(),
                new SplitPane(BookPanel.getInstance()));
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
    public LibMenuBar getLibMenuBar() {
        return libMenuBar;
    }

}
