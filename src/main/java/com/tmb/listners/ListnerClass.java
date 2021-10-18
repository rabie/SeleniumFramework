package com.tmb.listners;

import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerClass implements ITestListener, ISuiteListener {

    public void onStart(ISuite suite) {
        try {
            ExtentReport.initReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void onTestStart(ITestResult result) {
        if (!result.getMethod().getDescription().isEmpty())
                 ExtentReport.createTest(result.getMethod().getDescription());
        else
                ExtentReport.createTest(result.getMethod().getMethodName());
    }
    public void onTestSuccess(ITestResult result) {
        try {
            ExtentLogger.pass(result.getMethod().getMethodName() + " is Passed", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void onTestFailure(ITestResult result) {
        try {
            ExtentLogger.fail(result.getMethod().getMethodName() + " is Failed", true);
            ExtentLogger.fail(result.getThrowable().toString());
           // ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void onTestSkipped(ITestResult result) {
        try {
            ExtentLogger.skip(result.getMethod().getMethodName() + " is Skipped", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
