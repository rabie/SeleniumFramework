package com.tmb.pages;

import com.tmb.driver.DriverManager;
import org.openqa.selenium.By;

public class YourStoreHomePage extends BasePage{

    private final By myAccountLink = By.linkText("My Account");
    private final By logoutLink = By.linkText("Logout");
    private final By continueBtn = By.linkText("Continue");
    private final By loginLink = By.linkText("Login");

    public YourStoreHomePage clickMyAccount(){
        click(myAccountLink);
        return this;
    }

    public YourStoreLoginPage clickLogout(){
        click(logoutLink);
        click(continueBtn);
        click(myAccountLink);
       click(loginLink);

        return new YourStoreLoginPage();
    }
}
