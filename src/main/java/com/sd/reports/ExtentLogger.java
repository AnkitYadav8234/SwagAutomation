package com.sd.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.sd.driver.DriverManager;
import com.sd.enums.ConfigProperties;
import com.sd.utils.PropertyUtils;
import com.sd.utils.ScreenshotUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ExtentLogger {
    private ExtentLogger() {
    }

    public static void pass(String message) {
        ExtentManager.getExtTest().pass(message);
    }

    public static void fail(String message) {
        ExtentManager.getExtTest().fail(message);
    }

    public static void skip(String message) {
        ExtentManager.getExtTest().skip(message);
    }

    public static void pass(String message, boolean isScreenShotNeeded)  {

        if (PropertyUtils.get(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes") && isScreenShotNeeded) {
            ExtentManager.getExtTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }
        else {
            ExtentManager.getExtTest().pass(message);
        }

    }

    public static void fail(String message, boolean isScreenShotNeeded)  {

        if (PropertyUtils.get(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes") && isScreenShotNeeded) {
            ExtentManager.getExtTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }
        else {
            ExtentManager.getExtTest().fail(message);
        }

    }

    public static void skip(String message, boolean isScreenShotNeeded)  {

        if (PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes") && isScreenShotNeeded) {
            ExtentManager.getExtTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }
        else {
            ExtentManager.getExtTest().skip(message);
        }

    }

}
