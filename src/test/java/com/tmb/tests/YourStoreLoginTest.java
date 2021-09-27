package com.tmb.tests;

import com.tmb.pages.YourStoreLoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public final class YourStoreLoginTest extends BaseTest {

    private YourStoreLoginTest(){}

    @Test(dataProvider = "loginTestdata")
    public void loginLogoutTest(String userName, String password){
     String title = new YourStoreLoginPage()
             .enterEmail(userName)
             .enterPassword(password)
             .clickLogin()
             .clickMyAccount()
             .clickLogout()
             .getPageTitle();

     Assert.assertEquals(title, "Account Login");
    }

    @DataProvider(name = "loginTestdata", parallel = true)
    public Object[][] getData(){
        return new Object[][]{
                {"rabie.dexter@gmail.com", "Ad85021!" }

        };
    }
}