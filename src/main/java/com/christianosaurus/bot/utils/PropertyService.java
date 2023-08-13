package com.christianosaurus.bot.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyService {
    public static String getProperty(String propertyName) {
        Properties properties = new Properties();
        try (InputStream input = PropertyService.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(input);
            return properties.getProperty(propertyName);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return null;
    }
}
