/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.business;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.logging.Logger;
import org.lib.model.MyBook;
import org.lib.utils.LibException;
import org.osgi.util.tracker.ServiceTracker;

public abstract class LibraryFacade implements LibraryFacadeInterface {

    private static LibraryFacadeInterface service;
    private static ServiceTracker<LibraryFacade, LibraryFacade> st;

    public static LibraryFacadeInterface getService() {
        if (service == null) {
            service = st.getService();
            if (service == null) {
                service = facadeAspectWrapper(new LibraryFacadeDefault());
            }
        }
        return service;
    }

    public static void setSt(ServiceTracker<LibraryFacade, LibraryFacade> aSt) {
        st = aSt;
    }
    private static final Logger LOG = Logger.getLogger(LibraryFacade.class.getName());

    private static LibraryFacadeInterface facadeAspectWrapper(LibraryFacadeDefault facade) {
        return (LibraryFacadeInterface) Proxy.newProxyInstance(LibraryFacade.class.getClassLoader(),
                new Class<?>[]{LibraryFacadeInterface.class},
                new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                LOG.info(method.getName());
                Method bussineMethod = facade.getClass().getMethod(method.getName(), method.getParameterTypes());
                return bussineMethod.invoke(facade, args);
            }
        });

    }

}
