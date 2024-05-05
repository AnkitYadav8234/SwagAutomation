package com.sd.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
    private ExtentManager(){}

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();
    public static void setExtTest(ExtentTest test){
        extTest.set(test);
    }
    static ExtentTest getExtTest(){
        return extTest.get();
    }
     static void unload(){
        extTest.remove();
    }
}
