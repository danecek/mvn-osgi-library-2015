package org.lib.connection;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import org.lib.connection.impl.ConnectAction;
import org.lib.connection.impl.ConnectionMenu;
import org.lib.connection.impl.DisconnectAction;
import org.lib.richclient.ActionsState;
import org.lib.richclient.MainWindow;
import org.lib.richclient.MyAlert;
import org.lib.utils.LibException;
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
                MainWindow.instance.getLibMenuBar().getMenus().add(new ConnectionMenu());
                MainWindow.instance.getLibToolBar().getItems().addAll(
                        ConnectAction.instance.genButton(),
                        DisconnectAction.instance.genButton()
                );
                ActionsState.instance.dateChanged();
            }
        });
    }

    @Override
    public void stop(BundleContext context) throws LibException {
        LOG.info("");
        Connection.instance.disconnect();
    }

}
