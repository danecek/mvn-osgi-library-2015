/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.connectionxml;

import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.lib.connection.Connection;
import org.lib.protocol.Command;
import org.lib.protocol.CreateBook;
import org.lib.protocol.GetAllBooks;
import org.lib.protocol.Logout;
import org.lib.protocol.BooksCollection;
import org.lib.protocol.DeleteBooks;
import org.lib.protocol.Ok;
import org.lib.utils.LibException;
import org.lib.utils.Messages;

public class ConnectionXML extends Connection {

    private static final Logger LOG = Logger.getLogger(Connection.class.getName());

    private Marshaller m;
    private DataOutputStream oos;
    private DataInputStream ois;
    private Socket s;
    private Unmarshaller um;

    public ConnectionXML() {
        try {
            JAXBContext jxbcm = JAXBContext.newInstance(
                    GetAllBooks.class, CreateBook.class, DeleteBooks.class, Logout.class);
            m = jxbcm.createMarshaller();
            JAXBContext jxbcum = JAXBContext.newInstance(BooksCollection.class,
                    Ok.class);
            um = jxbcum.createUnmarshaller();
        } catch (JAXBException ex) {
            Logger.getLogger(ConnectionXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void connect(InetAddress host, int port) throws IOException {
        s = new Socket(host, port);
        //  s.setSoTimeout(3000);
        oos = new DataOutputStream(s.getOutputStream());
        ois = new DataInputStream(s.getInputStream());

    }

    @Override
    public void disconnect() throws LibException {
        if (!isConnected()) {
            return;
        }
        try (OutputStream oos = this.oos;
                InputStream ois = this.ois;
                Socket s = this.s) {
            send(new Logout());
            this.s = null;
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public <T> T send(Command com) throws LibException {
        if (!isConnected()) {
            throw new LibException(Messages.Not_connected.createMess());
        }
        try {
            StringWriter sw = new StringWriter();
            m.marshal(com, sw);
            String commStr = sw.toString();
            LOG.log(Level.INFO, "{0}:{1}", new Object[]{commStr.length(), commStr});
            oos.writeInt(commStr.length());
            oos.flush();
            oos.writeUTF(commStr);
            oos.flush();
            if (com instanceof Logout) {
                return null;
            }
            int l = ois.readInt();
            String strResult = ois.readUTF();
            LOG.log(Level.INFO, "{0}:{1}", new Object[]{l, strResult});
            T result = (T) um.unmarshal(new StringReader(strResult));
            if (result instanceof Exception) {
                throw (LibException) result;
            }
            return result;
        } catch (IOException | JAXBException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new LibException(ex);
        }

    }

    @Override
    public boolean isConnected() {
        return s != null;
    }

}
