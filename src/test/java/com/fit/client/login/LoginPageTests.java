package com.fit.client.login;

import com.fit.admin.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resource.ClientElements;

public class LoginPageTests {
    private RemoteWebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void driverSetup(){
        driver = SingletonDriver.getInstance();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        loginPage = new LoginPage(driver, wait);
    }

    @BeforeMethod
    public void setDriver(){
        driver.navigate().to("https://client-dev.fitcrowd.net/login");
    }

    @Test
    public void checkForgotPasswordButton(){
        loginPage.checkForgotPassword();
    }

    @Test
    public void missingCredentials(){
        loginPage.checkPage();
        loginPage.failedLogin();
        loginPage.checkMissingCredentialsError();
    }

    @Test
    public void invalidEmail(){
        loginPage.checkPage();
        loginPage.setEmail("TestEmail");
        Assert.assertEquals(loginPage.getEmailErrorMessage(), ClientElements.invalidEmail);
    }
    @Test
    public void invalidPassword(){
        loginPage.checkPage();
        loginPage.setPassword("Pass");
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), ClientElements.invalidPassword);
    }

    @Test
    public void invalidCredentials(){
        loginPage.checkPage();
        loginPage.setEmail("TestEmail@gmail.com");
        loginPage.setPassword("Pass1234");
        loginPage.failedLogin();
        Assert.assertEquals(loginPage.getInvalidCredentialsMessage(), ClientElements.invalidCredentials);
    }

    @Test
    public void validCredentials(){
        loginPage.checkPage();
        loginPage.setEmail("denis.yonutz98@gmail.com");
        loginPage.setPassword("abcd4321");
        loginPage.successfulLogin();
    }

}
