package org.lib.connection;

import java.util.logging.Logger;
import org.lib.richclient.MainWindow;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ConnectionActivator implements BundleActivator {

    private static final Logger LOG = Logger.getLogger(ConnectionActivator.class.getName());

    @Override
    public void start(BundleContext context) throws Exception {
        LOG.info("");
        MainWindow.instance.getLibMenuBar().getMenus().add(new ConnectionMenu());
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        LOG.info("");
    }

}
