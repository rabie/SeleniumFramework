package com.tmb.pages;

import com.tmb.enums.WaitStrategy;
import org.openqa.selenium.By;

public class YourStoreLoginPage extends BasePage{

    private final By emailInput = By.id("input-email");
    private final By passwordInput = By.id("input-password");
    private final By loginBtn = By.xpath("//input[@type='submit']");

    public YourStoreLoginPage enterEmail(String email ){
        sendKeys(emailInput, email, WaitStrategy.PRESENCE);
        return this;
    }

    public YourStoreLoginPage enterPassword(String password) {
        sendKeys(passwordInput, password, WaitStrategy.PRESENCE);
        return this;
    }

    public YourStoreHomePage clickLogin() {
        click(loginBtn, WaitStrategy.PRESENCE);
        return new YourStoreHomePage();
    }




}
