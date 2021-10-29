package com.tmb.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.CategoryType;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport(){}
    private static ExtentReports extent;

    public static void initReports(){
        if (Objects.isNull(extent)){
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("TMB Report");
            spark.config().setReportName("Training");
        }
    }
    public static void flushReports() {
        if (Objects.nonNull(extent)){
            extent.flush();
            ExtentManager.unload();
            try {
                Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void createTest(String testCaseName){
        ExtentManager.setExtentTest(extent.createTest(testCaseName));
    }
    //using Custom annotation to add Authors and Categories
    public static void addAuthors(String[] authors){
        ExtentManager.getExtentTest().assignAuthor(authors);
    }
    public static void addCategories(CategoryType[] categories){
        for (CategoryType cat: categories) {
            ExtentManager.getExtentTest().assignCategory(cat.toString());
        }
    }
}
