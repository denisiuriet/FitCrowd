package com.fit.admin.forgotPasswordPage;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import resource.Elements;
import resource.Utility;
import ru.yandex.qatools.allure.annotations.Step;

public class ForgotPasswordPage {
    private RemoteWebDriver driver;

    public ForgotPasswordPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    @Step("Check Page")
    public boolean checkPage() {
        return Utility.checkPage(driver, "https://admin-dev.fitcrowd.net/forgotPassword");
    }

    @Step("Set email")
    public void setEmail(String email) {
        driver.findElement(Elements.enterEmailToResetPass).sendKeys(email);
    }

    @Step("Return to login")
    public void returnToLogin() {
        driver.findElement(Elements.returnToLogin).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://admin-dev.fitcrowd.net/login");
    }

    @Step("Get error message")
    public String getEmailError() {
        return driver.findElement(Elements.emailError).getText();
    }

    @Step("Check Reset Button")
    public void checkResetButton() {
        driver.findElement(Elements.resetPassword).click();
        Utility.takeScreenshot(driver);
    }

    @Step("Get alert message")
    public String getAlertMessage() {
        return driver.findElement(Elements.alertMessage).getText();
    }

}
