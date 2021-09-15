package com.tmb.driver;

import com.tmb.constants.FrameworkConstants;
import com.tmb.utils.ReadPropertyFile;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Objects;

public class Driver {

    private Driver(){}


    public static void initDriver() throws Exception {
        if (Objects.isNull(DriverManager.getDriver())){
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath());
            DriverManager.setDriver(new ChromeDriver());
            DriverManager.getDriver().get(ReadPropertyFile.getValue("url"));
        }
    }

    public static void quitDriver(){
        if (Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }

    }
}
