package com.tmb.pages;

import com.tmb.enums.WaitStrategy;
import com.tmb.reports.ExtentLogger;
import org.openqa.selenium.By;

public class YourStoreHomePage extends BasePage{

    private final By myAccountLink = By.linkText("My Account");
    private final By logoutLink = By.linkText("Logout");
    private final By continueBtn = By.linkText("Continue");
    private final By loginLink = By.linkText("Login");

    public YourStoreHomePage clickMyAccount(){
        click(myAccountLink, WaitStrategy.CLICKABLE);
        ExtentLogger.pass("Click my Account");
        return this;
    }

    public YourStoreLoginPage clickLogout(){
        click(logoutLink, WaitStrategy.CLICKABLE);
        click(continueBtn, WaitStrategy.PRESENCE);
        click(myAccountLink, WaitStrategy.CLICKABLE);
        click(loginLink, WaitStrategy.CLICKABLE);
        ExtentLogger.pass("Logout clicked");

        return new YourStoreLoginPage();
    }
}
