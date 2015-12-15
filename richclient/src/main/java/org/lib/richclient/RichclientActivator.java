package org.lib.richclient;

import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class RichclientActivator implements BundleActivator {

    static final Logger logger = Logger.getLogger(RichclientActivator.class.getName());

    @Override
    public void start(BundleContext context) throws Exception {
        logger.info("");
        new JFXPanel();
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                MainWindow.getInstance().setContext(context);
            }
        });
    }

    public void stop(BundleContext context) throws Exception {
        logger.info("");
    }

}
