package com.tmb.utils;

import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    private static Properties properties;

    private PropertyUtils(){}

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

    public static String getValue(ConfigProperties key) throws Exception {
        if (Objects.isNull(properties.getProperty(key.name().toLowerCase().trim()))|| Objects.isNull(key))
            throw new Exception("Proprety name " + key + " is not found !!");
        return properties.getProperty(key.name().toLowerCase()).trim();
    }

}
