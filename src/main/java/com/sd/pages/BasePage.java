package com.sd.pages;

import com.sd.driver.DriverManager;
import com.sd.enums.WaitStrategy;
import com.sd.factory.ExplicitWaitFactory;
import com.sd.reports.ExtentLogger;
import org.openqa.selenium.By;

public class BasePage {
    protected void click(By by, WaitStrategy waitstrategy,String elementname)  {
        ExplicitWaitFactory.performExpicitWait(waitstrategy, by).click();
        ExtentLogger.pass(elementname +" is clicked",true);

    }

    protected void sendkeys(By by, String value, WaitStrategy waitstrategy, String elementname)  {
        ExplicitWaitFactory.performExpicitWait(waitstrategy, by).sendKeys(value);
        ExtentLogger.pass('"'+value+'"' +" is entered successfully in "+elementname,true);
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

}
