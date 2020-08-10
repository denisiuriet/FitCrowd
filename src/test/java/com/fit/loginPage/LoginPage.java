package com.fit.loginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import resource.Elements;
import resource.Utility;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private String errorMessage;

    public LoginPage(RemoteWebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Check page")
    public boolean checkPage(){
        return Utility.checkPage(driver, "https://admin-dev.fitcrowd.net/login");
    }

    @Step("Set Email")
    public void setEmail(String email){
        driver.findElement(Elements.email).sendKeys(email);
        Utility.takeScreenshot(driver);
    }

    @Step("Set Password")
    public void setPassword(String password){
        driver.findElement(Elements.password).sendKeys(password);
        Utility.takeScreenshot(driver);
    }

    @Step("Get credentials error message")
    public List<String> getCredentialsErrorMessage(){
        List<WebElement> listOfElements = driver.findElements(Elements.errorCredentials);
        List<String> errorMessages = new ArrayList<>();

        for(WebElement elem : listOfElements){
            errorMessages.add(elem.getText());
        }

        return errorMessages;
    }

    @Step("Get login error message")
    public String getLoginErrorMessage(){
        this.errorMessage = driver.findElement(Elements.errorMessageInvalid).getText();

        return this.errorMessage;
    }

    @Step("Check successful login")
    public boolean successfulLogin(){
        driver.findElement(Elements.loginButton).click();
        if(driver.getCurrentUrl().equals("https://admin-dev.fitcrowd.net/schedule")){
            Utility.takeScreenshot(driver);
            return true;
        }else{
            Utility.takeScreenshot(driver);
            return false;
        }
    }

    @Step("Check failed login")
    public void failedLogin(){
        driver.findElement(Elements.loginButton).click();
        Utility.takeScreenshot(driver);
    }

    @Step("Check forgot password")
    public boolean forgotPassword(){
        driver.findElement(Elements.forgotPassword).click();
        if(driver.getCurrentUrl().equals("https://admin-dev.fitcrowd.net/forgotPassword")){
            Utility.takeScreenshot(driver);
            return true;
        }else{
            Utility.takeScreenshot(driver);
            return false;
        }
    }
}
