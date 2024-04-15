package com.leonid;

import com.leonid.config.Configuration;
import com.leonid.config.ConfigurationManager;

import java.io.IOException;

public class HttpServer {
    public static void main(String[] args) {

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration configuration = ConfigurationManager.getInstance().getConfiguration();

        try {
            ServerThread serverThread = new ServerThread(configuration.getPort());
            serverThread.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
