package com.tmb.tests;

import com.tmb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public final class HomepageTests extends BaseTest{

    private HomepageTests(){}

    @Test
    public void test2() throws InterruptedException {


        DriverManager.getDriver().findElement(By.name("q"))
                .sendKeys("testing mini bytes - youtube", Keys.ENTER);

        String title = DriverManager.getDriver().getTitle();
        Assert.assertTrue(title.toLowerCase().contains("mini bytes"));
        List<WebElement> list = DriverManager.getDriver().findElements(By.tagName("h3"));
        for (WebElement element : list){
            if (element.getText().contains("testing mini bytes")){
                Assert.assertTrue(true);
                break;
            }
        }

    }
}
