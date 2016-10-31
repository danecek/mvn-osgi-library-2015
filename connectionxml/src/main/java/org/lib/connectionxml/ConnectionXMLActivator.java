package org.lib.connectionxml;

import java.util.logging.Logger;
import org.lib.connection.Connection;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ConnectionXMLActivator implements BundleActivator {

    private static final Logger LOG = Logger.getLogger(ConnectionXMLActivator.class.getName());

    @Override
    public void start(BundleContext context) throws Exception {
        LOG.info("");
        context.registerService(Connection.class, new ConnectionXML(), null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        LOG.info("");
    }

}
