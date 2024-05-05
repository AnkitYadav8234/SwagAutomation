package com.sd.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private DriverManager() {
    }

    public static WebDriver driver;
    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driverref) {
        dr.set(driverref);
    }

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void unload() {
        dr.remove();
    }
}
