package com.sd.test;

import com.sd.driver.Driver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Map;

public class BaseTest {
    protected BaseTest() {
    }


    @BeforeMethod
    protected void setUp(Object[] data) throws MalformedURLException {
        Map<String, String> map = (Map<String, String>) data[0];
        Driver.initDriver(map.get("browser"));
    }

    @AfterMethod
    protected void tearDown(ITestResult result) {
        Driver.quitDriver();
    }
}
