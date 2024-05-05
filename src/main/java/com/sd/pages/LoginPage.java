package com.sd.pages;

import com.sd.enums.WaitStrategy;
import com.sd.reports.ExtentLogger;
import com.sd.reports.ExtentManager;
import com.sd.reports.ExtentReport;
import org.openqa.selenium.By;

public final class LoginPage extends BasePage {
    private final By text_username = By.xpath("//input[@id='user-name']");
    private final By text_password = By.xpath("//input[@id='password']");
    private final By button_login = By.xpath("//input[@id='login-button']");

    public LoginPage  enterUsername(String username)  {
        sendkeys(text_username,username, WaitStrategy.PRESENCE,"Username Text Field");
        return this;
    }
    public LoginPage enterPassword(String password) {
        sendkeys(text_password,password, WaitStrategy.PRESENCE,"Username Text Field");
        return this;
    }
    public HomePage clicklogin() {
        click(button_login,WaitStrategy.CLICKABLE, "Login Button");
        return new HomePage();
    }



}
