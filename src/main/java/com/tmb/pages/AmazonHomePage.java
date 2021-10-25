package com.tmb.pages;

import com.tmb.enums.WaitStrategy;
import org.openqa.selenium.By;

public class AmazonHomePage extends BasePage{


    private By linkHamburger = By.id("nav-hamburger-menu");

    public AmazonHamburgerMenuPage clickHamburger(){
        click(linkHamburger, WaitStrategy.CLICKABLE, " link Hamburger");
        return new AmazonHamburgerMenuPage();
    }
}
