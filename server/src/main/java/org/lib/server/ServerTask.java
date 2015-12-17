/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danecek
 */
public class ServerTask implements Runnable {

    ServerSocket ss;
    ExecutorService es;
    private static final Logger LOG = Logger.getLogger(ServerTask.class.getName());

    public ServerTask(ExecutorService es) {
        try {
            this.es = es;
            ss = new ServerSocket(3333);
        } catch (IOException ex) {
            Logger.getLogger(ServerTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        for (;;) {
            try {
                LOG.info("waiting for client");
                Socket s = ss.accept();
                es.execute(new ClientTask(s));
            } catch (IOException ex) {
                Logger.getLogger(ServerTask.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
