package com.sd.driver;

import com.sd.enums.ConfigProperties;
import com.sd.factory.DriverFactory;
import com.sd.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.util.Objects;

public class Driver {
    private Driver() {
    }

    public static WebDriver driver;

    public static void initDriver(String browser) throws MalformedURLException {
        if (Objects.isNull(DriverManager.getDriver())) {

            DriverManager.setDriver(DriverFactory.getDriver(browser));
            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }
    }


    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
