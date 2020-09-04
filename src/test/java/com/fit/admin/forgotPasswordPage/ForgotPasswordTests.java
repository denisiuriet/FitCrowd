package com.fit.admin.forgotPasswordPage;

import com.fit.admin.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resource.Elements;

public class ForgotPasswordTests {

    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private ForgotPasswordPage forgotPasswordPage;

    @BeforeClass
    public void driverSetup() {
        driver = SingletonDriver.getInstance();
        wait = new WebDriverWait(driver, 30);
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    @BeforeMethod
    public void setDriver() {
        driver.navigate().to("https://admin-dev.fitcrowd.net/forgotPassword");
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://admin-dev.fitcrowd.net/forgotPassword");
    }

    @Test
    public void returnToLogin() {
        forgotPasswordPage.checkPage();
        forgotPasswordPage.returnToLogin();
    }

    @Test
    public void missingEmail() {
        forgotPasswordPage.checkPage();
        forgotPasswordPage.checkResetButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.emailError));
        Assert.assertEquals(forgotPasswordPage.getEmailError(), Elements.emailErrorMessage);
    }

    @Test
    public void invalidEmail() {
        forgotPasswordPage.checkPage();
        forgotPasswordPage.setEmail("123@gmail.com");
        forgotPasswordPage.checkResetButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.alertMessage));
        String alertMessage = forgotPasswordPage.getAlertMessage();

        Assert.assertEquals(alertMessage, Elements.invalidEmailMessage);
    }

    @Test
    public void validEmail() {
        forgotPasswordPage.checkPage();
        forgotPasswordPage.setEmail("denisiuriet.test@gmail.com");
        forgotPasswordPage.checkResetButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.alertMessage));
        String alertMessage = forgotPasswordPage.getAlertMessage();

        Assert.assertEquals(alertMessage, Elements.validEmailMessage);

    }
}
