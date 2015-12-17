/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.model.MyBook;
import org.lib.protocol.Command;
import org.lib.protocol.Logout;
import org.lib.utils.LibException;
import org.lib.utils.Messages;

/**
 *
 * @author danecek
 */
public class Connection {

    private static final Logger LOG = Logger.getLogger(Connection.class.getName());

    public static final Connection instance = new Connection();

    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Socket s;
    private static Class[] clss = {MyBook.class};
    // MyBook ClassNotFound workaround

    public void connect(InetAddress host, int port) throws IOException {
        s = new Socket(host, port);
        oos = new ObjectOutputStream(s.getOutputStream());
        ois = new ObjectInputStream(s.getInputStream());
    }

    public void disconnect() throws LibException {
        if (!isConnected()) {
            return;
        }
        try (ObjectOutputStream oos = this.oos;
                ObjectInputStream ois = this.ois;
                Socket s = this.s) {
            send(new Logout());
            this.s = null;
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public <T> T send(Command com) throws LibException {
        if (!isConnected()) {
            throw new LibException(Messages.Not_connected.createMess());
        }
        try {
            oos.writeObject(com);
            oos.flush();
            if (com instanceof Logout) {
                return null;
            }
            T result = (T) ois.readObject();
            if (result instanceof Exception) {
                throw (LibException) result;
            }
            return result;
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            throw new LibException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }

    }

    public boolean isConnected() {
        return s != null;
    }

}
