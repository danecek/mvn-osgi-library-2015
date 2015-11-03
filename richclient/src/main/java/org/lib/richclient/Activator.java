package org.lib.richclient;

import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    static final Logger logger = Logger.getLogger(Activator.class.getName());

    @Override
    public void start(BundleContext context) throws Exception {
        logger.info("");
        new JFXPanel();
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                new MainWindow();
            }
        });
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }

}
