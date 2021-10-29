package com.tmb.tests;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.enums.CategoryType;
import com.tmb.pages.YourStoreHomePage;
import com.tmb.pages.YourStoreLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public final class YourStoreLoginTest extends BaseTest {

    private YourStoreLoginTest(){}

    @FrameworkAnnotation(author = {"Reda", "Nawres"}, category = {CategoryType.REGRESSION, CategoryType.SANITY})
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