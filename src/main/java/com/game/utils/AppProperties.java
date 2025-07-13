package com.game.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {
    private static final String PROPERTIES_FILE = "/application.properties";
    private static Properties properties = new Properties();

    static {
        try (InputStream input = AppProperties.class.getResourceAsStream(PROPERTIES_FILE)) {
            if (input != null) {
                properties.load(input);
            } else {
                throw new IOException("Properties file not found: " + PROPERTIES_FILE);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load application properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}