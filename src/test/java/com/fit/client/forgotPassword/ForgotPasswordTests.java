package com.fit.client.forgotPassword;

import com.fit.admin.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resource.ClientElements;

public class ForgotPasswordTests {
    private RemoteWebDriver driver;
    private ForgotPasswordPage forgotPasswordPage;

    @BeforeClass
    public void driverSetup(){
        driver = SingletonDriver.getInstance();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        forgotPasswordPage = new ForgotPasswordPage(driver, wait);
    }

    @BeforeMethod
    public void setDriver(){
        driver.navigate().to("https://client-dev.fitcrowd.net/forgotPassword");
    }

    @Test
    public void missingEmail(){
        forgotPasswordPage.checkPage();
        forgotPasswordPage.resetPassword();
        Assert.assertEquals(forgotPasswordPage.getEmailError(), ClientElements.missingEmail);
    }

    @Test
    public void invalidEmail(){
        forgotPasswordPage.checkPage();
        forgotPasswordPage.setEmail("TestEmail");
        Assert.assertEquals(forgotPasswordPage.getEmailError(), ClientElements.invalidEmail);
    }

    @Test
    public void wrongEmail(){
        forgotPasswordPage.checkPage();
        forgotPasswordPage.setEmail("TestEmail@gmail.com");
        forgotPasswordPage.resetPassword();
        Assert.assertEquals(forgotPasswordPage.getAlertMessage(), ClientElements.wrongEmailMessage);
    }

    @Test
    public void validEmail(){
        forgotPasswordPage.checkPage();
        forgotPasswordPage.setEmail("denis.yonutz98@gmail.com");
        forgotPasswordPage.resetPassword();
        Assert.assertEquals(forgotPasswordPage.getAlertMessage(), ClientElements.validEmailMessage);
    }

    @Test
    public void returnToLogin(){
        forgotPasswordPage.checkPage();
        forgotPasswordPage.returnToLogin();
    }

}
