package com.tmb.tests;

import com.tmb.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseTest {

    /**
     * Object[] data : native injection in TestNg, we can use it on BeforeMethod Level
     * */
    @BeforeMethod
    protected void setUp(Object[] data) throws Exception {
        Map<String, String> map = (Map<String, String>)data[0];
        Driver.initDriver(map.get("browser"), map.get("version"));
    }
    @AfterMethod
    protected void tearDown(){
        Driver.quitDriver();
    }
}
