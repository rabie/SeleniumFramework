package com.tmb.tests;

import com.tmb.pages.AmazonHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public final class AmazonTest extends BaseTest{

    private AmazonTest(){}

    @Test
    public void amazonTest(Map<String, String> data){
        String title = new AmazonHomePage().
                clickHamburger().
                clickComputer().
                clickOnSubMenuItem(data.get("menutext")).getTitle();

        Assert.assertNotNull(title);
    }

}
