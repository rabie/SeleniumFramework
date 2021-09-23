package com.tmb.tests;

import com.tmb.pages.YourStoreLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class YourStoreLoginTest extends BaseTest {

    private YourStoreLoginTest(){}

    @Test
    public void loginLogoutTest() throws InterruptedException {
     String title = new YourStoreLoginPage()
             .enterEmail("rabie.dexter@gmail.com")
             .enterPassword("Ad85021!")
             .clickLogin()
             .clickMyAccount()
             .clickLogout()
             .getPageTitle();

     Assert.assertEquals(title, "Account Login");
    }
}