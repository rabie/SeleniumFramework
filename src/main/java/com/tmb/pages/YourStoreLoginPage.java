package com.tmb.pages;

import com.tmb.driver.DriverManager;
import org.openqa.selenium.By;

public class YourStoreLoginPage extends BasePage{

    private final By emailInput = By.id("input-email");
    private final By passwordInput = By.id("input-password");
    private final By loginBtn = By.xpath("//input[@type='submit']");

    public YourStoreLoginPage enterEmail(String email ){
        sendKeys(emailInput, email);
        return this;
    }

    public YourStoreLoginPage enterPassword(String password) {
        sendKeys(passwordInput, password);
        return this;
    }

    public YourStoreHomePage clickLogin() {
        click(loginBtn);
        return new YourStoreHomePage();
    }




}
