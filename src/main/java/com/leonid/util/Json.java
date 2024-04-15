package com.leonid.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leonid.config.Configuration;

public class Json {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static Configuration getConfObject(String jsonString) throws JsonProcessingException {
        return mapper.readValue(jsonString, Configuration.class);
    }
}
