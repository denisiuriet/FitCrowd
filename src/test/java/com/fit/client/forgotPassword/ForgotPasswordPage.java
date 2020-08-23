package com.fit.client.forgotPassword;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resource.ClientElements;
import resource.Utility;
import ru.yandex.qatools.allure.annotations.Step;

public class ForgotPasswordPage {
    private RemoteWebDriver driver;
    private WebDriverWait wait;

    public ForgotPasswordPage(RemoteWebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Check Page")
    public void checkPage(){
        Utility.checkPage(driver, "https://client-dev.fitcrowd.net/forgotPassword");
    }

    @Step("Set Email")
    public void setEmail(String email){
        driver.findElement(ClientElements.clientEmail).sendKeys(email);
    }

    @Step("Get Email Error")
    public String getEmailError(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClientElements.error));
        return driver.findElement(ClientElements.error).getText();
    }

    @Step("Reset Password")
    public void resetPassword(){
        driver.findElement(ClientElements.submitButton).click();
        Utility.takeScreenshot(driver);
    }

    @Step("Get Alert Message")
    public String getAlertMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClientElements.alert));
        return driver.findElement(ClientElements.alert).getText();
    }

    @Step("Check Return To Login")
    public void returnToLogin(){
        driver.findElement(ClientElements.returnToLogin).click();
        wait.until(ExpectedConditions.urlToBe("https://client-dev.fitcrowd.net/login"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://client-dev.fitcrowd.net/login");
    }


}
