package com.tmb.listners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener, ISuiteListener {

    public void onStart(ISuite suite) {
        System.out.println("BeforeSuite in Listener");
    }
    public void onFinish(ISuite suite) {
        System.out.println("AfterSuite in Listener");
    }
    public void onTestStart(ITestResult result) {
        System.out.println("BeforeMethod in Listner");
    }
    public void onTestSuccess(ITestResult result) {
        System.out.println("AfterMethod in Listner -------> Test pass");
    }
    public void onTestFailure(ITestResult result) {
        System.out.println("AfterMethod in Listner -------> Test Fail");
    }
    public void onTestSkipped(ITestResult result) {
        System.out.println("AfterMethod in Listner -------> Test Skipped");
    }
}
