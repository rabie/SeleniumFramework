package com.tmb.constants;

public final class FrameworkConstants {

    private FrameworkConstants(){}

    private static final String CHROMEDRIVERPATH = System.getProperty("user.dir")
                                                    + "/src/test/resources/drivers/chromedriver.exe" ;
    public static String getCHROMEDRIVERPATH() {
        return CHROMEDRIVERPATH;
    }
}
