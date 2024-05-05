package com.sd.utils;

import com.sd.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtills {
    private static List<Map<String,String>> list = new ArrayList<>();

    @DataProvider
    public static Object[] getData(Method m)  {
        String testname = m.getName();
        if (list.isEmpty()){
            list = ExcelUtils.getTestDetails(FrameworkConstants.getDataSheet());
        }
        List<Map<String,String>> smalllist = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("testname").equalsIgnoreCase(testname)){
                if (list.get(i).get("execute").equalsIgnoreCase("yes")){
                    smalllist.add(list.get(i));
                }
            }
        }
        return smalllist.toArray();
    }
}
