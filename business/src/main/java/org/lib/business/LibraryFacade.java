/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.business;

import java.util.Collection;
import org.lib.model.MyBook;
import org.lib.utils.LibException;
import org.osgi.util.tracker.ServiceTracker;

public abstract class LibraryFacade {

    private static LibraryFacade service;
    private static ServiceTracker<LibraryFacade, LibraryFacade> st;

    public static LibraryFacade getService() {
        if (service == null) {
            service = st.getService();
            if (service == null) {
                service = new LibraryFacadeDefault();
            }
        }
        return service;
    }

    /**
     * @param aSt the st to set
     */
    public static void setSt(ServiceTracker<LibraryFacade, LibraryFacade> aSt) {
        st = aSt;
    }

    public abstract void createBook(MyBook book) throws LibException;

    public abstract void createBook(String title, String author) throws LibException;

    public abstract Collection<MyBook> getAllBooks() throws LibException;

    public abstract boolean facadeAvailable();

}
