package com.fit.classesPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resource.Elements;
import resource.Utility;
import ru.yandex.qatools.allure.annotations.Step;

public class ClassesPage {
    private RemoteWebDriver driver;
    private WebDriverWait wait;

    public ClassesPage(RemoteWebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    @Step
    public void checkPage(){
        Utility.checkPage(driver, "https://admin-dev.fitcrowd.net/classes");
    }

    @Step
    public void addImage(){
        driver.findElement(Elements.createButton).click();
        driver.switchTo().activeElement();
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(Elements.createImg)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.sendImg));
        //WebElement frame = driver.findElement(Elements.createFrame);
        driver.findElement(Elements.sendImg).sendKeys("C:/Users/iurie/Desktop/nurca.jpg");
    }
}
