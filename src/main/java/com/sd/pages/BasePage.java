package com.sd.com.sd;

import com.sd.enums.WaitStrategy;
import com.sd.constants.FrameworkConstants;
import com.sd.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected void click(By by, WaitStrategy waitstrategy){
        if (waitstrategy == WaitStrategy.CLICKABLE){
            explicitlyWaitForElementToBeClickable(by);
        }else if(waitstrategy == WaitStrategy.PRESENCE){
            explicitlyWaitForElementToBePresent(by);
        }

        DriverManager.getDriver().findElement(by).click();
    }
    protected void sendkeys(By by, String value,WaitStrategy waitstrategy){
        if (waitstrategy == WaitStrategy.CLICKABLE){
            explicitlyWaitForElementToBeClickable(by);
        }else if(waitstrategy == WaitStrategy.PRESENCE){
            explicitlyWaitForElementToBePresent(by);
        }
        DriverManager.getDriver().findElement(by).sendKeys(value);
    }
    protected String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }
    protected void explicitlyWaitForElementToBeClickable(By by){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.elementToBeClickable(by));
    }
    protected void explicitlyWaitForElementToBePresent(By by){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.presenceOfElementLocated(by));
    }
    protected void explicitlyWaitForElementToBeVisible(By by){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
