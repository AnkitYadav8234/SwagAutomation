package com.sd.listeners;

import com.sd.constants.FrameworkConstants;
import com.sd.exceptions.FrameworkException;
import com.sd.utils.ExcelUtils;
import lombok.SneakyThrows;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {


    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext iTestContext) {
        List<Map<String, String>> list = null;
        list = ExcelUtils.getTestDetails(FrameworkConstants.getRunmanagerSheet());
        List<IMethodInstance> result = new ArrayList<>();

        for(int i=0;i<methods.size();i++) {
            for(int j=0;j<list.size();j++) {
                if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname")) &&
                        list.get(j).get("execute").equalsIgnoreCase("yes")) {
                    methods.get(i).getMethod().setDescription((list.get(j).get("testdescription")));
                    methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
                    methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
                    result.add(methods.get(i));
                }
            }
        }

        return result;
    }
}
