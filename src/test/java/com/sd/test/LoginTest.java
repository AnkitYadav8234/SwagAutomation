package com.sd.test;

import com.sd.annotations.FrameworkAnnotation;
import com.sd.enums.AuthorType;
import com.sd.enums.CategoriesType;
import com.sd.pages.LoginPage;
import com.sd.utils.DataProviderUtills;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public final class LoginTest extends BaseTest {
    private LoginTest() {
    }

    @FrameworkAnnotation(author = {AuthorType.ANKIT,AuthorType.RAHUL},category = {CategoriesType.SMOKE,CategoriesType.REGRESSION})
    @Test
    public void loginLogoutTest(Map<String,String> data)  {
        new LoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clicklogin().clicklogout();
    }


    @FrameworkAnnotation(author = {AuthorType.ANKIT,AuthorType.RAHUL},category = {CategoriesType.SMOKE,CategoriesType.REGRESSION})
    @Test
    public void newloginLogoutTest(Map<String,String> data)  {
        new LoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clicklogin().clicklogout();
    }


    @FrameworkAnnotation(author = {AuthorType.ANKIT,AuthorType.RAHUL},category = {CategoriesType.SMOKE,CategoriesType.REGRESSION})
    @Test
    public void loginLogoutTest1(Map<String,String> data)  {
        new LoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clicklogin().clicklogout();
    }


    @FrameworkAnnotation(author = {AuthorType.ANKIT,AuthorType.RAHUL},category = {CategoriesType.SMOKE,CategoriesType.REGRESSION})
    @Test
    public void newloginLogoutTest2(Map<String,String> data)  {
        new LoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clicklogin().clicklogout();
    }
}
