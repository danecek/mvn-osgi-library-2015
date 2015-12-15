package org.lib.connection;

import java.util.logging.Logger;
import javafx.application.Platform;
import org.lib.richclient.MainWindow;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ConnectionActivator implements BundleActivator {

    private static final Logger LOG = Logger.getLogger(ConnectionActivator.class.getName());

    @Override
    public void start(BundleContext context) throws Exception {
        LOG.info("");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                MainWindow.getInstance().getLibMenuBar().getMenus().add(new ConnectionMenu());
            }
        });
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        LOG.info("");
    }

}
