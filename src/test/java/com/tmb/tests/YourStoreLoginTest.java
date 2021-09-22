package com.tmb.tests;

import com.tmb.driver.DriverManager;
import com.tmb.pages.YourStoreHomePage;
import com.tmb.pages.YourStoreLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class YourStoreLoginTest extends BaseTest {

    private YourStoreLoginTest(){}

    @Test
    public void loginLogoutTest() throws InterruptedException {
        YourStoreHomePage yourStoreHomePage =new YourStoreLoginPage()
                .enterEmail("rabie.dexter@gmail.com")
                .enterPassword("Ad85021!")
                .clickLogin();
        yourStoreHomePage.clickMyAccount().clickLogout();
        String title = DriverManager.getDriver().getTitle();
        Assert.assertEquals(title, "Account Logout");
    }
}