package com.fit.client.verifyGym;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resource.ClientElements;
import resource.Utility;
import ru.yandex.qatools.allure.annotations.Step;

public class VerifyGymPage {
    private RemoteWebDriver driver;
    private WebDriverWait wait;

    public VerifyGymPage(RemoteWebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Check Page")
    public void checkPage(){
        Utility.checkPage(driver, "https://client-dev.fitcrowd.net/gymVerify");
    }

    @Step("Set Gym Code")
    public void setGymCode(String gymCode){
        driver.findElement(ClientElements.gymCode).sendKeys(gymCode);
    }

    @Step("Successful login")
    public void successfulLogin(){
        driver.findElement(ClientElements.submitButton).click();
        wait.until(ExpectedConditions.urlToBe("https://client-dev.fitcrowd.net/login"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://client-dev.fitcrowd.net/login");
    }

    @Step("Failed Login")
    public void failedLogin(){
        driver.findElement(ClientElements.submitButton).click();
        Utility.takeScreenshot(driver);
    }

    @Step("Get Missing Gym Code Error")
    public String getMissingGymCodeError(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClientElements.error));
        return driver.findElement(ClientElements.error).getText();
    }

    @Step("Get Invalid Gym Code Error")
    public String getInvalidGymCodeError(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClientElements.invalidError));
        return driver.findElement(ClientElements.invalidError).getText();
    }
}
