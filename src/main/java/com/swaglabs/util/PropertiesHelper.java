package com.swaglabs.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {

    private final Properties properties;

    /**
     * Constructor to initialize an empty properties object.
     */
    public PropertiesHelper() {
        properties = new Properties();
    }

    public PropertiesHelper(String fileName) {
        properties = new Properties();
        loadProperties(fileName);
    }

    /**
     * Loads properties from a given file and adds them to the existing properties set.
     *
     * @param fileName Path to the properties file within the resources folder.
     */
    public void loadProperties(String fileName) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new RuntimeException("Properties file not found: " + fileName);
            }
            properties.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties file: " + fileName, e);
        }
    }

    /**
     * Gets a property value by key.
     *
     * @param key Key of the property.
     * @return The value of the property as a String.
     */
    public String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property key not found: " + key);
        }
        return value;
    }

    /**
     * Clears all properties. Useful when switching between property files.
     */
    public void clearProperties() {
        properties.clear();
    }
}
