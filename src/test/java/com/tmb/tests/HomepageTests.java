package com.tmb.tests;

import com.tmb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class HomepageTests extends BaseTest{

    private HomepageTests(){}

    @Test
    public void test2(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Rabie", Keys.ENTER);
    }

    @Test
    public void test3(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Liza", Keys.ENTER);
    }
}
