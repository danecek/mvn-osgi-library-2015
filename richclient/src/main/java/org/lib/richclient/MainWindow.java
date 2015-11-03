/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.richclient;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author danecek
 */
public class MainWindow extends Stage {

    public MainWindow() {
        setTitle("Library");
        
        VBox root = new VBox(new Label("Hello"));
        Scene s = new Scene(root, 800, 600);
        setScene(s);
        show();
    }
    
    

}
