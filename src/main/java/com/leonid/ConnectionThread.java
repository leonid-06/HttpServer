package com.leonid;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class ConnectionThread extends Thread{

    private Socket clientSocket;

    public ConnectionThread(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        String CRLF = "\r\n";
        String startingLine = "HTTP/1.1 200 OK";
//        String contentType = "Content-Type: text/plain";
        String body = "hello bitches";
        String contentLength = "Content-Length: " + body.getBytes().length;

        try (OutputStream outputStream = clientSocket.getOutputStream();

             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String response = startingLine + CRLF + contentLength + CRLF + CRLF + body + CRLF;
            outputStream.write(response.getBytes());

            System.out.println("----------");
            while (reader.ready()) System.out.println(reader.readLine());
            System.out.println("----------");

            reader.close();
            outputStream.close();
            clientSocket.close();
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
