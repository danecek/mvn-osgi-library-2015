package org.lib.derbydb;

import java.util.logging.Logger;
import org.lib.integration.DAOFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class DerbyDBActivator implements BundleActivator {
    
    private static final Logger LOG = Logger.getLogger(DerbyDBActivator.class.getName());
    
    @Override
    public void start(BundleContext context) throws Exception {
        LOG.info("");
        context.registerService(DAOFactory.class.getName(), new DerbyDBDAOFactory(), null);
    }
    
    @Override
    public void stop(BundleContext context) throws Exception {
        LOG.info("");
    }
    
}
