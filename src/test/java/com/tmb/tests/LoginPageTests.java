package com.tmb.tests;

import com.tmb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class LoginPageTests extends BaseTest{

    private LoginPageTests(){}

    @Test
    public void firstTest() throws InterruptedException {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
    }
}
