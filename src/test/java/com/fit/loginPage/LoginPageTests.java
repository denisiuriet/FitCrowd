package com.fit.loginPage;

import com.fit.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resource.Elements;

import java.util.List;

public class LoginPageTests {
    private RemoteWebDriver driver;
    private WebDriverWait wait;

    private LoginPage loginPage;

    @BeforeClass(groups = {"create", "checkClass"})
    public void driverSetup() {
        driver = SingletonDriver.getInstance();
        wait = new WebDriverWait(driver, 30);

        loginPage = new LoginPage(driver, wait);
    }

    @BeforeMethod(groups = {"create", "checkClass"})
    public void setDriver() {
        driver.navigate().to("https://admin-dev.fitcrowd.net/login");
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://admin-dev.fitcrowd.net/login");
    }

    @Test
    public void missingCredentials() {
        loginPage.checkPage();
        loginPage.failedLogin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.errorCredentials));
        List<String> listOfErrors = loginPage.getCredentialsErrorMessage();

        for (String error : listOfErrors) {
            Assert.assertEquals(error, Elements.required);
        }
    }

    @Test
    public void invalidEmail() {
        loginPage.checkPage();
        loginPage.setEmail("abc");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.errorCredentials));
        List<String> listOfErrors = loginPage.getCredentialsErrorMessage();

        Assert.assertEquals(listOfErrors.get(0), Elements.invalidEmail);
    }

    @Test
    public void invalidPassword() {
        loginPage.checkPage();
        loginPage.setPassword("123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.errorCredentials));
        List<String> listOfErrors = loginPage.getCredentialsErrorMessage();

        Assert.assertEquals(listOfErrors.get(1), Elements.invalidPassword);
    }

    @Test
    public void invalidCredentials() {
        loginPage.checkPage();
        loginPage.setEmail("abc@gmail.com");
        loginPage.setPassword("abcd1234");
        loginPage.failedLogin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.errorMessageInvalid));

        Assert.assertEquals(loginPage.getLoginErrorMessage(), Elements.invalidCredentials);
    }

    @Test(priority = -1, groups = {"create", "checkClass"})
    public void validCredentials() throws InterruptedException {
        loginPage.checkPage();
        loginPage.setEmail("iuriet.denis@gmail.com");
        loginPage.setPassword("abcd1234");
        loginPage.successfulLogin();
    }

    @Test
    void checkForgotPassword() {
        loginPage.checkPage();
        loginPage.forgotPassword();
    }

    // @AfterClass
    // public void tearDown(){
    //    driver.quit();
    //}
}
