package com.tmb.pages;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;
import com.tmb.reports.ExtentLogger;
import org.openqa.selenium.By;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy, String elementName){
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).click();
        try {
            ExtentLogger.pass(elementName + " is Clicked", true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName){
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).sendKeys(value);
        try {
            ExtentLogger.pass(value + " is entred to " + elementName, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }




}
