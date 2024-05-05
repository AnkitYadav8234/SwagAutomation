package com.sd.com.sd;

import com.sd.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class LoginPage extends BasePage{
    private final By text_username = By.xpath("//input[@id='user-name']");
    private final By text_password = By.xpath("//input[@id='password']");
    private final By button_login = By.xpath("//input[@id='login-button']");

    public LoginPage  enterUsername(String username){
        sendkeys(text_username,username, WaitStrategy.PRESENCE);
        return this;
    }
    public LoginPage enterPassword(String password){
        sendkeys(text_password,password, WaitStrategy.PRESENCE);
        return this;
    }
    public HomePage  clicklogin(){
        click(button_login,WaitStrategy.CLICKABLE);
        return new HomePage();
    }



}
