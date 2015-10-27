package org.lib.integration;

import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class IntegrationActivator implements BundleActivator {
    
    static final Logger log = Logger.getLogger(IntegrationActivator.class.getName());
    
    @Override
    public void start(BundleContext context) throws Exception {
        log.info("");
    }
    
    @Override
    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }
    
}
