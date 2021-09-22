package com.tmb.pages;

import com.tmb.constants.FrameworkConstants;
import com.tmb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected void click(By by){
        explicitlyWaitForElementToBeClickable(by);
        DriverManager.getDriver().findElement(by).click();
    }
    protected void sendKeys(By by, String value){
        explicitlyWaitForElementToBeClickable(by);
        DriverManager.getDriver().findElement(by).sendKeys(value);
    }
    public String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }

    private void explicitlyWaitForElementToBeClickable(By by){
        new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
                .until(ExpectedConditions.elementToBeClickable(by));
    }
    private void explicitlyWaitForElementToBePresent(By by){
        new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
