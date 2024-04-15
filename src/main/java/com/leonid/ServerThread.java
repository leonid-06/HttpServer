package com.leonid;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {

    private final ServerSocket serverSocket;

    public ServerThread(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    @Override
    public void run() {
        Socket clientSocket = null;
        try {
            while (true) {
                clientSocket = serverSocket.accept();
                ConnectionThread connectionThread = new ConnectionThread(clientSocket);
                connectionThread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            if (clientSocket!=null)
                try {
                    clientSocket.close();
                } catch (IOException ignored) {
                }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ignored) {
                }
            }
        }
    }
}

