package com.tmb.tests;

import com.tmb.pages.PhpTravelsLoginPage;
import org.testng.annotations.Test;

public final class PhpTravelsLoginTest {

    private PhpTravelsLoginTest(){}

    @Test
    public void loginLogoutTest(){
        new PhpTravelsLoginPage()
                .enterEmail("rabie.dexter@gmail.com")
                .enterPassword("Ad85021!")
                .clickLogin();
    }
}
