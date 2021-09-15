package com.tmb.utils;

import com.tmb.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {

    private static Properties properties;

    private ReadPropertyFile(){}

    static {
        properties = new Properties();

        try(FileInputStream inputStream  = new FileInputStream(FrameworkConstants.getConfigfilepath())) {
            properties.load(inputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) throws Exception {
        if (Objects.isNull(properties.getProperty(key))|| Objects.isNull(key))
            throw new Exception("Proprety name " + key + " is not found !!");
        return properties.getProperty(key).trim();
    }


}
