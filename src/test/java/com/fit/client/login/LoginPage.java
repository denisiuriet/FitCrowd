package com.fit.client.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resource.ClientElements;
import resource.Utility;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {
    private RemoteWebDriver driver;
    private WebDriverWait wait;

    public LoginPage(RemoteWebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Check page")
    public void checkPage() {
        Utility.checkPage(driver, "https://client-dev.fitcrowd.net/login");
    }

    @Step("Set Email")
    public void setEmail(String email) {
        driver.findElement(ClientElements.clientEmail).sendKeys(email);
    }

    @Step("Set Password")
    public void setPassword(String password) {
        driver.findElement(ClientElements.clientPassword).sendKeys(password);
    }

    @Step("Check Forgot Password Button")
    public void checkForgotPassword(){
        driver.findElement(ClientElements.forgotPassword).click();
        wait.until(ExpectedConditions.urlToBe("https://client-dev.fitcrowd.net/forgotPassword"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://client-dev.fitcrowd.net/forgotPassword");
    }

    @Step("Failed Login")
    public void failedLogin() {
        driver.findElement(ClientElements.submitButton).click();
        Utility.takeScreenshot(driver);
    }

    @Step("Successful Login")
    public void successfulLogin() {
        driver.findElement(ClientElements.submitButton).click();
        wait.until(ExpectedConditions.urlToBe("https://client-dev.fitcrowd.net/home"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://client-dev.fitcrowd.net/home");
    }

    @Step("Check Missing Credentials Errors")
    public void checkMissingCredentialsError() {
        List<WebElement> errorElements = driver.findElements(ClientElements.error);
        List<String> errors = new ArrayList<>();
        for (WebElement element : errorElements) {
            errors.add(element.getText());
        }

        List<String> checkErrors = new ArrayList<>();
        checkErrors.add(ClientElements.missingCredentialMessage);
        checkErrors.add(ClientElements.missingCredentialMessage);

        Assert.assertEquals(errors, checkErrors);
    }

    @Step("Get Email Error Message")
    public String getEmailErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClientElements.error));
        return driver.findElement(ClientElements.error).getText();
    }

    @Step("Get Password Error Message")
    public String getPasswordErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClientElements.error));
        List<WebElement> errors = driver.findElements(ClientElements.error);
        return errors.get(1).getText();
    }

    @Step("Get Invalid Credentials Message")
    public String getInvalidCredentialsMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClientElements.invalidError));
        return driver.findElement(ClientElements.invalidError).getText();
    }
}
