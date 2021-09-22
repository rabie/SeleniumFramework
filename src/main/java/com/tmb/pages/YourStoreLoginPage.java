package com.tmb.pages;

import com.tmb.driver.DriverManager;
import org.openqa.selenium.By;

public class YourStoreLoginPage {

    private final By emailInput = By.id("input-email");
    private final By passwordInput = By.id("input-password");
    private final By loginBtn = By.xpath("//input[@type='submit']");

    public YourStoreLoginPage enterEmail(String email ){
        DriverManager.getDriver().findElement(emailInput).sendKeys(email);
        return this;
    }

    public YourStoreLoginPage enterPassword(String password) {
        DriverManager.getDriver().findElement(passwordInput)
                .sendKeys(password);
        return this;
    }

    public YourStoreHomePage clickLogin() {
        DriverManager.getDriver().findElement(loginBtn).click();
        return new YourStoreHomePage();
    }


}
