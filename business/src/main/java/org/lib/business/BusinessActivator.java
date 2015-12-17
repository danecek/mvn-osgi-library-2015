package org.lib.business;

import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class BusinessActivator implements BundleActivator {

    private static final Logger LOG = Logger.getLogger(BusinessActivator.class.getName());

    @Override
    public void start(BundleContext context) throws Exception {
        LOG.info("");
        ServiceTracker<LibraryFacade, LibraryFacade> st
                = new ServiceTracker<>(context, LibraryFacade.class, null);
        st.open(); // !!!!
        LibraryFacade.setSt(st);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        LOG.info("");
    }

}
