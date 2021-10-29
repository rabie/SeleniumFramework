package com.tmb.listners;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerClass implements ITestListener, ISuiteListener {

    public void onStart(ISuite suite) {
            ExtentReport.initReports();
    }
    public void onFinish(ISuite suite) {
            ExtentReport.flushReports();
    }
    public void onTestStart(ITestResult result) {
       /* if (!result.getMethod().getDescription().isEmpty())
                 ExtentReport.createTest(result.getMethod().getDescription());
        else*/
        ExtentReport.createTest(result.getMethod().getMethodName());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod()
                .getMethod().getAnnotation(FrameworkAnnotation.class).author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod()
                .getMethod().getAnnotation(FrameworkAnnotation.class).category());

    }
    public void onTestSuccess(ITestResult result) {
            ExtentLogger.pass(result.getMethod().getMethodName() + " is Passed", true);

    }
    public void onTestFailure(ITestResult result) {
            ExtentLogger.fail(result.getMethod().getMethodName() + " is Failed", true);
            ExtentLogger.fail(result.getThrowable().toString());
           // ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));

    }
    public void onTestSkipped(ITestResult result) {
            ExtentLogger.skip(result.getMethod().getMethodName() + " is Skipped", true);

    }

}
