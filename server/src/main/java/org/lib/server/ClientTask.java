/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lib.business.LibraryFacade;
import org.lib.model.MyBook;
import org.lib.protocol.Command;
import org.lib.protocol.Logout;
import org.lib.protocol.BooksCollection;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public class ClientTask implements Runnable {

    private static final Logger LOG = Logger.getLogger(ClientTask.class.getName());

    private final ObjectInputStream ois;
    private final ObjectOutputStream oos;
    private final Socket s;

    Class[] clss = {MyBook.class};
    // MyBook ClassNotFound workaround

    public ClientTask(Socket s) throws IOException {
        this.s = s;
        ois = new ObjectInputStream(s.getInputStream());
        oos = new ObjectOutputStream(s.getOutputStream());
    }

    @Override
    public void run() {
        try (ObjectInputStream ois = this.ois;
                ObjectOutputStream oos = this.oos;
                Socket s = this.s) {
            for (;;) {
                Command comm = (Command) ois.readObject();
                LOG.info(comm.toString());
                if (comm instanceof Logout) {
                    break;
                }
                Object result;
                try {
                    result = comm.execute(LibraryFacade.getService());
                } catch (LibException ex) {
                    result = ex;
                }
                LOG.info(result.toString());
                oos.writeObject(result);
                oos.flush();
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ClientTask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
