package com.sd.listeners;

import com.sd.enums.ConfigProperties;
import com.sd.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;
    private int retries = 1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        try {
            if (PropertyUtils.get(ConfigProperties.RETRYFAILEDTEST).equalsIgnoreCase("yes")){
                if (count < retries){
                    count++;
                    return true;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return false;
    }
}
