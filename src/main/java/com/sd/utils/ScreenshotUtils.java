package com.sd.utils;

import com.sd.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotUtils {
    private ScreenshotUtils(){}
    public static String getBase64Image() {
        TakesScreenshot driver = (TakesScreenshot) DriverManager.getDriver();
        return driver.getScreenshotAs(OutputType.BASE64);
    }
}
