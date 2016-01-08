package org.lib.business;

import java.lang.management.ManagementFactory;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Logger;
import javax.management.MBeanServer;
import javax.management.ObjectName;
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
        MBeanServer mbs
                = ManagementFactory.getPlatformMBeanServer();
        ObjectName mxbeanName
                = new ObjectName("org.lib.business:type=My");
        My mxbean = new My();
        mbs.registerMBean(mxbean, mxbeanName);

    }

    @Override
    public void stop(BundleContext context) throws Exception {
        LOG.info("");
    }

}
