package com.tmb.listners;

import com.tmb.constants.FrameworkConstants;
import com.tmb.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {

        List<Map<String, String>> allTests = ExcelUtils.getTestDetails(FrameworkConstants.getAllTests());
        List<IMethodInstance> result = new ArrayList<>();

        for (int i = 0; i <list.size() ; i++) {
            for (int j = 0; j < allTests.size() ; j++) {
                if (list.get(i).getMethod().getMethodName()
                        .equalsIgnoreCase(allTests.get(j).get("testname")) &&
                    allTests.get(j).get("execute").equalsIgnoreCase("yes")){
                        list.get(i).getMethod().setInvocationCount(Integer.parseInt(allTests.get(j).get("count")));
                        list.get(i).getMethod().setDescription(allTests.get(j).get("testdescription"));
                        list.get(i).getMethod().setPriority(Integer.parseInt(allTests.get(j).get("priority")));
                        result.add(list.get(i));
                    }
            }
        }
        return result;
    }
}
