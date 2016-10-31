/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.serverxml;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.lib.business.LibraryFacade;
import org.lib.protocol.Command;
import org.lib.protocol.CreateBook;
import org.lib.protocol.DeleteBooks;
import org.lib.protocol.GetAllBooks;
import org.lib.protocol.Logout;
import org.lib.protocol.BooksCollection;
import org.lib.protocol.Ok;
import org.lib.utils.LibException;

/**
 *
 * @author danecek
 */
public class ClientXMLTask implements Runnable {

    private static final Logger LOG = Logger.getLogger(ClientXMLTask.class.getName());

    private Socket s;

//    Class[] clss = {MyBook.class};
    // MyBook ClassNotFound workaround
    private Marshaller m;
    private Unmarshaller um;

    public ClientXMLTask(Socket s) throws IOException {
        try {
            this.s = s;
            JAXBContext jaxbcum = JAXBContext.newInstance(GetAllBooks.class,
                    CreateBook.class, DeleteBooks.class, Logout.class);
            JAXBContext jaxbcm = JAXBContext.newInstance(BooksCollection.class, Ok.class);
            m = jaxbcm.createMarshaller();
            um = jaxbcum.createUnmarshaller();
        } catch (JAXBException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try (
                DataOutputStream oos = new DataOutputStream(s.getOutputStream());
                DataInputStream ois = new DataInputStream(s.getInputStream());
                Socket s = this.s) {
            for (;;) {
                LOG.info("waiting for command");
                int l = ois.readInt();
                String strComm = ois.readUTF();
                LOG.log(Level.INFO, "{0}:{1}", new Object[]{l, strComm});
                Command comm = (Command) um.unmarshal(new StringReader(strComm));
                if (comm instanceof Logout) {
                    break;
                }
                Object result;
                try {
                    result = comm.execute(LibraryFacade.getService());
                } catch (LibException ex) {            oos.flush();
                    result = ex;
                }
                StringWriter sw = new StringWriter();
                m.marshal(result, sw);
                String resultStr = sw.toString();
                LOG.log(Level.INFO, "{0}:{1}", new Object[]{resultStr.length(), resultStr});
                oos.writeInt(resultStr.length());
                oos.writeUTF(resultStr);
// m.marshal(result, oos);
                oos.flush();
            }
        } catch (IOException | JAXBException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

    }

}
