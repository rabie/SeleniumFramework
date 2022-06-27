package com.tmb.driver;

import com.tmb.enums.ConfigProperties;
import com.tmb.exceptions.BrowserInvocationFailedException;
import com.tmb.factories.DriverFactory;
import com.tmb.utils.PropertyUtils;

import java.net.MalformedURLException;
import java.util.Objects;


public class Driver {

    private Driver(){}


    public static void initDriver(String browser, String version){

        if (Objects.isNull(DriverManager.getDriver())){
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser, version));
            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Please check the capabilities of browser");
            }
            DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));

        }
    }

    public static void quitDriver(){
        if (Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }

    }
}
