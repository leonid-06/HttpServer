package com.leonid.config;

import com.leonid.util.Json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigurationManager {
    private static Configuration configuration;
    private static ConfigurationManager manager;

    public static ConfigurationManager getInstance() {
        if (manager == null) manager = new ConfigurationManager();
        return manager;
    }

    public void loadConfigurationFile(String fileName) {
        try {
            String fileData = Files.readString(Paths.get(fileName));
            configuration = Json.getConfObject(fileData);
        } catch (IOException e) {
            System.err.println("ERROR WITH CONFIG FILE");
        }
        setDefaultConfiguration();

    }

    public Configuration getConfiguration() {
        return configuration;
    }

    private void setDefaultConfiguration(){
        configuration = new Configuration(8080, "");
    }
}
