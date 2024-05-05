package com.sd.factory;

import com.sd.driver.DriverManager;
import com.sd.enums.ConfigProperties;
import com.sd.exceptions.BrowserInvocationFailedException;
import com.sd.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public final class DriverFactory {
    private DriverFactory() {
    }

    public static WebDriver getDriver(String browser) {

        WebDriver driver = null;

        String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);
        if (Objects.isNull(DriverManager.getDriver())) {
            if (browser.equalsIgnoreCase("chrome")) {

                if (runmode.equalsIgnoreCase("remote")) {
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName("chrome");
                    try {
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
                    } catch (MalformedURLException e) {
                        throw new BrowserInvocationFailedException("Browser Invocation failed.. please check capabilties of browser");
                    }
                } else {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

                }
            } else if (browser.equalsIgnoreCase("firefox")) {

                if (runmode.equalsIgnoreCase("remote")) {
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName("firefox");
                    try {
                        DriverManager.setDriver(new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), capabilities));
                    } catch (MalformedURLException e) {
                        throw new BrowserInvocationFailedException("Browser Invocation failed.. please check capabilties of browser");
                    }
                } else {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }

            } else if (browser.equalsIgnoreCase("ie")) {

                if (runmode.equalsIgnoreCase("remote")) {
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName("ie");
                    try {
                        DriverManager.setDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));
                    } catch (MalformedURLException e) {
                        throw new BrowserInvocationFailedException("Browser Invocation failed.. please check capabilties of browser");
                    }
                } else {
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                }

            }else if (browser.equalsIgnoreCase("edge")) {

                if (runmode.equalsIgnoreCase("remote")) {
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName("edge");
                    try {
                        DriverManager.setDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));
                    } catch (MalformedURLException e) {
                        throw new BrowserInvocationFailedException("Browser Invocation failed.. please check capabilties of browser");
                    }
                } else {
                    WebDriverManager.iedriver().setup();
                    driver = new EdgeDriver();
                }

            }

        }
        return driver;
    }
}
