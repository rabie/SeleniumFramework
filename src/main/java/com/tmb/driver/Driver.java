package com.tmb.driver;

import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class Driver {

    private Driver(){}


    public static void initDriver(String browser) throws Exception {

        if (Objects.isNull(DriverManager.getDriver())){
            if (browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath());
                DriverManager.setDriver(new ChromeDriver());
                //DriverManager.getDriver().manage().window().maximize();
            }else if (browser.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver", FrameworkConstants.getFirefoxDriverPath());
                DriverManager.setDriver(new FirefoxDriver());
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
