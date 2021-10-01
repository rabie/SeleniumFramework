package com.tmb.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport(){}
    private static ExtentReports extent;

    public static void initReports() throws Exception {
        if (Objects.isNull(extent)){
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("TMB Report");
            spark.config().setReportName("Training");
        }
    }
    public static void flushReports() throws Exception {
        if (Objects.nonNull(extent)){
            extent.flush();
            ExtentManager.unload();
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
        }

    }
    public static void createTest(String testCaseName){
        ExtentManager.setExtentTest(extent.createTest(testCaseName));
    }
}
