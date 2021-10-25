package com.tmb.pages;

import com.tmb.driver.DriverManager;

public final class LaptopPage {

    public String getTitle(){
        return DriverManager.getDriver().getTitle();
    }
}
