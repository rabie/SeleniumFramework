package com.tmb.pages;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).click();
    }
    protected void sendKeys(By by, String value, WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).sendKeys(value);
    }
    public String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }




}
