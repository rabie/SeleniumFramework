package com.tmb.listners;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
        List<IMethodInstance> result = new ArrayList<>();

        Map<String, Object> test1 = new HashMap<>();
        test1.put("name", "test1");
        test1.put("count", "3");

        List<Map<String, Object>> tests = new ArrayList<>();
        tests.add(test1);

        for (int i = 0; i <list.size() ; i++) {
            for (int j = 0; j <tests.size() ; j++) {
                if (list.get(i).getMethod().getMethodName().equalsIgnoreCase((String) (tests.get(j)).get("name"))){
                    list.get(i).getMethod().setInvocationCount(Integer.parseInt((String) (tests.get(j)).get("count")));
                }else {

                }
                result.add(list.get(i));
            }
        }


        return result;
    }
}
