package org.lib.derbydb;

import java.util.logging.Logger;
import org.lib.integration.DAOFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class DerbyDBActivator implements BundleActivator {
    
    static final Logger log = Logger.getLogger(DerbyDBActivator.class.getName());
    
    public void start(BundleContext context) throws Exception {
        log.info("");
        context.registerService(DAOFactory.class.getName(), new DerbyDBDAOFactory(), null);
    }
    
    public void stop(BundleContext context) throws Exception {
        log.info("");
        // TODO add deactivation code here
    }
    
}
