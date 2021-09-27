package com.tmb.pages;

import com.tmb.enums.WaitStrategy;
import com.tmb.reports.ExtentManager;
import com.tmb.reports.ExtentReport;
import org.openqa.selenium.By;

public class YourStoreLoginPage extends BasePage{

    private final By emailInput = By.id("input-email");
    private final By passwordInput = By.id("input-password");
    private final By loginBtn = By.xpath("//input[@type='submit']");

    public YourStoreLoginPage enterEmail(String email ){
        sendKeys(emailInput, email, WaitStrategy.PRESENCE);
        ExtentManager.getExtentTest().pass("enter Email");
        return this;
    }

    public YourStoreLoginPage enterPassword(String password) {
        sendKeys(passwordInput, password, WaitStrategy.VISIBLE);
        ExtentManager.getExtentTest().pass("enter Password");
        return this;
    }

    public YourStoreHomePage clickLogin() {
        click(loginBtn, WaitStrategy.PRESENCE);
        ExtentManager.getExtentTest().pass("Login clicked");
        return new YourStoreHomePage();
    }




}
