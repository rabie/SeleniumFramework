package com.tmb.utils;

import com.tmb.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {
    private static List<Map<String,String>> allTestsData = new ArrayList<>();

    @DataProvider(parallel = true)
    public static Object[] getData(Method method){
        String testName = method.getName();

        if (allTestsData.isEmpty()){
            allTestsData = ExcelUtils.getTestDetails(FrameworkConstants.getTestsData());
        }
        List<Map<String,String>> testData = new ArrayList<>();

        for (int i = 0; i < allTestsData.size() ; i++) {
            if (allTestsData.get(i).get("testname").equalsIgnoreCase(testName) &&
                allTestsData.get(i).get("execute").equalsIgnoreCase("yes")){
                    testData.add(allTestsData.get(i));

            }
        }
        return testData.toArray();

    }
}
