package com.fit.forgotPasswordPage;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import resource.Elements;
import resource.Utility;
import ru.yandex.qatools.allure.annotations.Step;

public class ForgotPasswordPage {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private String errorMessage;

    public ForgotPasswordPage(RemoteWebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Check Page")
    public boolean checkPage(){
        return Utility.checkPage(driver, "https://admin-dev.fitcrowd.net/forgotPassword");
    }

    @Step("Set email")
    public void setEmail(String email){
        driver.findElement(Elements.enterEmailToResetPass).sendKeys(email);
    }

    @Step("Return to login")
    public boolean returnToLogin(){
        driver.findElement(Elements.returnToLogin).click();
        if(driver.getCurrentUrl().equals("https://admin-dev.fitcrowd.net/login")){
            Utility.takeScreenshot(driver);
            return true;
        }else{
            Utility.takeScreenshot(driver);
            return false;
        }
    }

    @Step("Get error message")
    public String getEmailError(){
        this.errorMessage = driver.findElement(Elements.emailError).getText();

        return this.errorMessage;
    }

    @Step("Check Reset Button")
    public void checkResetButton(){
        driver.findElement(Elements.resetPassword).click();
        Utility.takeScreenshot(driver);
    }

    @Step("Get alert message")
    public String  getAlertMessage(){
        return driver.findElement(Elements.alertMessage).getText();
    }

}
