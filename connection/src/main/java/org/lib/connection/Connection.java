/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.connection;

import java.io.IOException;
import java.net.InetAddress;
import org.lib.protocol.Command;
import org.lib.utils.LibException;
import org.osgi.util.tracker.ServiceTracker;

public abstract class Connection {

    private static Connection service;
    private static ServiceTracker<Connection, Connection> st;

    public static void setSt(ServiceTracker aSt) {
        st = aSt;
    }

    public static Connection getService() {
        if (service == null) {
            service = st.getService();
            if (service == null) {
                service = new ConnectionDefault();
            }
        }
        return service;
    }

    public abstract void connect(InetAddress host, int port) throws IOException;

    public abstract void disconnect() throws LibException;

    public abstract <T> T send(Command com) throws LibException;

    public abstract boolean isConnected();

}
