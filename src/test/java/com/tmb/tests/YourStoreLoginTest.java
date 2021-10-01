package com.tmb.tests;

import com.tmb.listners.RetryFailedTests;
import com.tmb.pages.YourStoreHomePage;
import com.tmb.pages.YourStoreLoginPage;
import com.tmb.utils.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public final class YourStoreLoginTest extends BaseTest {

    private YourStoreLoginTest(){}

    @Test
    public void loginLogoutTest(Map<String, String> data){

     YourStoreHomePage homePage = new YourStoreLoginPage()
             .enterEmail(data.get("username"))
             .enterPassword(data.get("password"))
             .clickLogin();
     Assert.assertEquals(homePage.getPageTitle(), "My Account");
     String title = homePage.clickMyAccount().clickLogout().getPageTitle();

     Assert.assertEquals(title, "Account Login");
    }

    @Test
    public void newTest(Map<String, String> data){

        YourStoreHomePage homePage = new YourStoreLoginPage()
                .enterEmail(data.get("username"))
                .enterPassword(data.get("password"))
                .clickLogin();
        Assert.assertEquals(homePage.getPageTitle(), "My Account");
        String title = homePage.clickMyAccount().clickLogout().getPageTitle();

        Assert.assertEquals(title, "Account Login");
    }

}