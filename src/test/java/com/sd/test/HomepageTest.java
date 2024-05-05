package com.sd.test;

import com.sd.annotations.FrameworkAnnotation;
import com.sd.driver.DriverManager;
import com.sd.enums.AuthorType;
import com.sd.enums.CategoriesType;
import com.sd.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Map;

public final class HomepageTest extends BaseTest {
    private HomepageTest() {
    }

    @FrameworkAnnotation(author = {AuthorType.ANKIT,AuthorType.RAHUL},category = {CategoriesType.SMOKE,CategoriesType.REGRESSION})
    @Test
    public void loginLogoutTest(Map<String,String> data)  {
        new LoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clicklogin().clicklogout();
    }

}
