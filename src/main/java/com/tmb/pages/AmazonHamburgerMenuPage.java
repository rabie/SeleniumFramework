package com.tmb.pages;

import com.tmb.enums.WaitStrategy;
import com.tmb.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

public class AmazonHamburgerMenuPage extends BasePage{

   /* @FindBy(xpath = "//div[text()='Mobiles, Computers']/parent::a")
    private WebElement linkMobileAndComputers;

    @FindBy(xpath = "//a[text()='Laptops']")
    private WebElement linkLaptops;
    @FindBy(xpath = "//a[text()='Drives & Storage']")
    private WebElement linkDrivesAndStorage;

    public AmazonHamburgerMenuPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }*/

    private String linkSubMenu = "//a[text()='%replace%']";
    //second variant using format
    private String linkSubMenu2 = "//a[text()='%s']";

    private String linkComputers = "//div[text()='Mobiles, Computers']/parent::a";

    public AmazonHamburgerMenuPage clickComputer(){
        click(By.xpath(linkComputers), WaitStrategy.CLICKABLE, "Mobile and Computers");
        return this;
    }

    public LaptopPage clickOnSubMenuItem(String menuText){
        String newXpath = DynamicXpathUtils.getXpath(linkSubMenu, menuText);

        if (menuText.contains("Laptop")){
            click(By.xpath(newXpath), WaitStrategy.CLICKABLE, menuText);
            return new LaptopPage();
        }else
            return null;
    }
}
