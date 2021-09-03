package com.tmb.tests;

import com.tmb.constants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", FrameworkConstants.getCHROMEDRIVERPATH());
        driver = new ChromeDriver();
        driver.get("https://google.com");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void firstTest() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
    }
}
