package com.fit.admin.homePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resource.Elements;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {
    private RemoteWebDriver driver;
    private WebDriverWait wait;

    public HomePage(RemoteWebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Check Page")
    public void checkPage() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Step("Check Today Class")
    public void checkAttendTodayClass() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.todayClasses));
        List<WebElement> listOfClasses = driver.findElements(Elements.todayClasses);
        System.out.println(listOfClasses.get(0).getText());
        if(listOfClasses.get(0).getText().equals("No classes for today")){
            return;
        }else{
            for(WebElement element : listOfClasses){
                if(element.findElement(Elements.todayClassType).getText().equals("- online")){
                    element.findElement(Elements.attendButton).click();
                    Assert.assertNotEquals(driver.getCurrentUrl(), "https://admin-dev.fitcrowd.net/home");
                    break;
                }
            }
        }
    }
}



