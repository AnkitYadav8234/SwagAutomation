package com.sd.com.sd;

import com.sd.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class HomePage extends BasePage {
    private static By humberger = By.xpath("//button[@id='react-burger-menu-btn']");
    private static By logoutbtn = By.xpath("//a[@id='logout_sidebar_link']");

    public LoginPage clicklogout() {
        click(humberger, WaitStrategy.CLICKABLE);
        click(logoutbtn,WaitStrategy.CLICKABLE);
        return new LoginPage();

    }
}
