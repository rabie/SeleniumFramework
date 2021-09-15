package com.tmb.pages;

import com.tmb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class PhpTravelsLoginPage {

    private final By emailInput = By.id("inputEmail");
    private final By passwordInput = By.id("inputPassword");
    private final By loginBtn = By.id("login");

    public PhpTravelsLoginPage enterEmail(String email ){
        DriverManager.getDriver().findElement(emailInput).sendKeys(email);
        return this;
    }

    public PhpTravelsLoginPage enterPassword(String password){
        DriverManager.getDriver().findElement(passwordInput)
                .sendKeys(password, Keys.TAB, Keys.TAB, Keys.ENTER);
        return this;
    }

    public PhpTravelsHomePage clickLogin(){
        DriverManager.getDriver().findElement(loginBtn).click();
        return new PhpTravelsHomePage();
    }


}
