package org.lib.utils;

import java.util.Locale;
import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class UtilsActivator implements BundleActivator {

    Logger log = Logger.getLogger(UtilsActivator.class.getName());

    @Override
    public void start(BundleContext context) throws Exception {
        log.info("");
//        Locale.setDefault(new Locale("cs"));
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        log.info("");
    }

}
