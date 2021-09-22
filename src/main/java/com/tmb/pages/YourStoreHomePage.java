package com.tmb.pages;

import com.tmb.driver.DriverManager;
import org.openqa.selenium.By;

public class YourStoreHomePage {

    private final By myAccountLink = By.linkText("My Account");
    private final By logoutLink = By.linkText("Logout");

    public YourStoreHomePage clickMyAccount(){
        DriverManager.getDriver().findElement(myAccountLink).click();
        return this;
    }

    public YourStoreLoginPage clickLogout(){
        DriverManager.getDriver().findElement(logoutLink).click();
        return new YourStoreLoginPage();
    }
}
