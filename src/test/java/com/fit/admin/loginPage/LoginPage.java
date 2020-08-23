package com.fit.admin.loginPage;

import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resource.Elements;
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
    public boolean checkPage() {
        return Utility.checkPage(driver, "https://admin-dev.fitcrowd.net/login");
    }

    @Step("Set Email")
    public void setEmail(String email) {
        driver.findElement(Elements.email).sendKeys(email);
        Utility.takeScreenshot(driver);
    }

    @Step("Set Password")
    public void setPassword(String password) {
        driver.findElement(Elements.password).sendKeys(password);
        Utility.takeScreenshot(driver);
    }

    @Step("Get credentials error message")
    public List<String> getCredentialsErrorMessage() {
        List<WebElement> listOfElements = driver.findElements(Elements.errorCredentials);
        List<String> errorMessages = new ArrayList<>();

        for (WebElement elem : listOfElements) {
            errorMessages.add(elem.getText());
        }

        return errorMessages;
    }

    @Step("Get login error message")
    public String getLoginErrorMessage() {
        return driver.findElement(Elements.errorMessageInvalid).getText();
    }

    @Step("Check successful login")
    public void successfulLogin() {
        driver.findElement(Elements.loginButton).click();
        wait.until(ExpectedConditions.urlToBe("https://admin-dev.fitcrowd.net/schedule"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://admin-dev.fitcrowd.net/schedule");
        Utility.takeScreenshot(driver);
    }

    @Step("Check failed login")
    public void failedLogin() {
        driver.findElement(Elements.loginButton).click();
        Utility.takeScreenshot(driver);
    }

    @Step("Check forgot password")
    public void forgotPassword() {
        driver.findElement(Elements.forgotPassword).click();
        wait.until(ExpectedConditions.urlToBe("https://admin-dev.fitcrowd.net/forgotPassword"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://admin-dev.fitcrowd.net/forgotPassword");
        Utility.takeScreenshot(driver);
    }
}
