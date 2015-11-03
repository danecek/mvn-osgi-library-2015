/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient;

import java.util.logging.Level;
import java.util.logging.Logger;
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

    private BundleContext context;

    public static MainWindow instance = new MainWindow();

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

    private MainWindow() {
        setTitle("Library");
        setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent event) {
                stop();
            }
        });
        VBox root = new VBox(new LibMenuBar(),
                 new SplitPane(new BookPanel()));
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

}
