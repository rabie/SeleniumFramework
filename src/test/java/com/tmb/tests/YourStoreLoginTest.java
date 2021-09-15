package com.tmb.tests;

import com.tmb.pages.YourStoreLoginPage;
import org.testng.annotations.Test;

public final class YourStoreLoginTest extends BaseTest {

    private YourStoreLoginTest(){}

    @Test
    public void loginLogoutTest() throws InterruptedException {
        new YourStoreLoginPage()
                .enterEmail("rabie.dexter@gmail.com")
                .enterPassword("Ad85021!")
                .clickLogin();
    }
}