package org.lib.proxy;

import java.util.logging.Logger;
import org.lib.business.LibraryFacade;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ProxyActivator implements BundleActivator {

    private static final Logger LOG = Logger.getLogger(ProxyActivator.class.getName());

    @Override
    public void start(BundleContext context) throws Exception {
        LOG.info("");
        context.registerService(LibraryFacade.class, new LibraryFacadeProxy(), null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        LOG.info("");
    }

}
