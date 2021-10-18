package com.tmb.constants;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;

public final class FrameworkConstants {

    private FrameworkConstants(){}

    private static final String RESOURCESPATH  = System.getProperty("user.dir") + "/src/test/resources/";
    //Driver location
    private static final String CHROMEDRIVERPATH = RESOURCESPATH + "drivers/chromedriver.exe" ;
    private static final String FIREFOXDRIVERPATH = RESOURCESPATH + "drivers/geckodriver.exe" ;
    //Config location
    private static final String CONFIGFILEPATH = RESOURCESPATH + "config/config.properties";
    // Explicit Wait duration
    private static final int EXPLICITWAIT = 10;
    //Extent Report location
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-output/";
    private static String extentReportFilePath = "";
    //Tests and Tests Data in excel
    private static final String EXCELPATH = RESOURCESPATH + "data/testData.xlsx";
    private static final String ALLTESTS = "AllTests";
    private static final String TESTSDATA = "DATA";


    public static String getAllTests() {
        return ALLTESTS;
    }
    public static String getTestsData() {
        return TESTSDATA;
    }
    public static String getExtentReportFilePath() throws Exception {
        if (extentReportFilePath.isEmpty()){
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }
    private static String createReportPath() throws Exception {
        if (PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")){
            return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "/index.html";
        }else
            return EXTENTREPORTFOLDERPATH + "index.html";
    }
    public static String getChromedriverpath() {
        return CHROMEDRIVERPATH;
    }
    public static String getFirefoxDriverPath() {
        return FIREFOXDRIVERPATH;
    }
    public static String getConfigfilepath(){ return CONFIGFILEPATH; }
    public static int getExplicitwait() {
        return EXPLICITWAIT;
    }
    public static String getExcelpath() {
        return EXCELPATH;
    }
}
