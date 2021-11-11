package com.tmb.driver;

import com.tmb.enums.ConfigProperties;
import com.tmb.exceptions.BrowserInvocationFailedException;
import com.tmb.factories.DriverFactory;
import com.tmb.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

/***
 *
 */

public class Driver {

    private Driver(){}


    public static void initDriver(String browser){

        if (Objects.isNull(DriverManager.getDriver())){
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser));
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
