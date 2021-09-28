package com.tmb.pages;

import com.tmb.enums.WaitStrategy;
import com.tmb.reports.ExtentLogger;
import org.openqa.selenium.By;

public class YourStoreLoginPage extends BasePage{

    private final By emailInput = By.id("input-email");
    private final By passwordInput = By.id("input-password");
    private final By loginBtn = By.xpath("//input[@type='submit']");

    public YourStoreLoginPage enterEmail(String email ){
        sendKeys(emailInput, email, WaitStrategy.PRESENCE);
        ExtentLogger.pass("enter Email");
        return this;
    }

    public YourStoreLoginPage enterPassword(String password) {
        sendKeys(passwordInput, password, WaitStrategy.VISIBLE);
        ExtentLogger.pass("enter Password");
        return this;
    }

    public YourStoreHomePage clickLogin() {
        click(loginBtn, WaitStrategy.PRESENCE);
        ExtentLogger.pass("Login clicked");
        return new YourStoreHomePage();
    }




}
