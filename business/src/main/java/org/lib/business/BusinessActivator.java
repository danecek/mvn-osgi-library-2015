package org.lib.business;

import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class BusinessActivator implements BundleActivator {

    static final Logger log = Logger.getLogger(BusinessActivator.class.getName());

    @Override
    public void start(BundleContext context) throws Exception {
        log.info("");
        ServiceTracker<LibraryFacade, LibraryFacade> st
                = new ServiceTracker<>(context, LibraryFacade.class, null);
        st.open(); // !!!!
        LibraryFacade.setSt(st);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        log.info("");
    }

}
