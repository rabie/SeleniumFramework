package com.tmb.listners;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;
    private int retries = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean value = false;

        if (PropertyUtils.getValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes"))
             value= count++<retries ? true : false;

        return value;

    }
}
