package com.tmb.factories;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver getDriver(String browser) throws MalformedURLException {
        String runMode = PropertyUtils.getValue(ConfigProperties.RUNMODE);
        DesiredCapabilities caps = null;
        WebDriver driver = null;
        if (browser.equalsIgnoreCase("chrome")){
                /*
                 this is needed only to setup chrome in local not needed in Docker
                 WebDriverManager.chromedriver().setup();
                 */
            if (runMode.equalsIgnoreCase("remote")){
                caps = new DesiredCapabilities();
                caps.setBrowserName(BrowserType.CHROME);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
            }else{
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }else if (browser.equalsIgnoreCase("firefox")){
            if (runMode.equalsIgnoreCase("remote")){
                caps = new DesiredCapabilities();
                caps.setBrowserName(BrowserType.FIREFOX);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
            }else{
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }

        }
        return driver;
    }
}
