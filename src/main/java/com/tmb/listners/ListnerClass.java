package com.tmb.listners;

import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;
import org.testng.*;

import java.io.IOException;

public class ListnerClass implements ITestListener, ISuiteListener {

    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushReports();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is Passed");
    }

    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " is Failed");
    }

    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is Skipped");
    }

}
