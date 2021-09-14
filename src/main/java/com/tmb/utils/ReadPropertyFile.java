package com.tmb.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ReadPropertyFile {

    private ReadPropertyFile(){}

    public static String getValue(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") +
                                    "/src/test/resources/config/config.properties");
        properties.load(inputStream);
        inputStream.close();
        return properties.getProperty(key);
    }

}
