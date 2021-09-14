package com.tmb.tests;

import com.tmb.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {

    @BeforeMethod
    protected void setUp() throws IOException {
        Driver.initDriver();
    }

    @AfterMethod
    protected void tearDown(){
        Driver.quitDriver();
    }
}
