package com.sd.pages;

import com.sd.enums.WaitStrategy;
import com.sd.reports.ExtentLogger;
import com.sd.reports.ExtentManager;
import com.sd.reports.ExtentReport;
import org.openqa.selenium.By;

public final class HomePage extends BasePage {
    private static By humberger = By.xpath("//button[@id='react-burger-menu-btn']");
    private static By logoutbtn = By.xpath("//a[@id='logout_sidebar_link']");

    public LoginPage clicklogout() {
        click(humberger, WaitStrategy.CLICKABLE,"Humberger Button");
        click(logoutbtn,WaitStrategy.CLICKABLE,"Login Button");
        return new LoginPage();

    }
}
