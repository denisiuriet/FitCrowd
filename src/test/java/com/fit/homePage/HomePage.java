package com.fit.homePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import resource.Elements;
import resource.Utility;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private List<String> data;

    public HomePage(RemoteWebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public List<String> readFile(String fileName) {
        this.data = new ArrayList<>();

        try {
            this.data = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return this.data;
    }

    @Step("Check Page")
    public void checkPage(){
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Step("Check Today Class")
    public boolean checkTodayClass() {
        List<WebElement> listOfClasses = driver.findElements(Elements.todayClasses);
        String className;
        String classType;
        WebElement button;

        for (WebElement element : listOfClasses) {
            className = element.findElement(Elements.todayClassName).getText();
            classType = element.findElement(Elements.todayClassType).getText();
            button = element.findElement(Elements.attendButton);

            if (className.equals(this.data.get(1)) && classType.equals("- online")) {
                button.click();
                if (driver.getCurrentUrl().equals("https://admin-dev.fitcrowd.net/onlineClass/eyJlbWFpbCI6Iml1cmlldC5kZW5pc0BnbWFpbC5jb20iLCJ0b2tlbiI6IkhUcUtjY1diRHk5IiwicGFyZW50Q29tcG9uZW50IjoiZml0Y3Jvd2QiLCJsYW5ndWFnZSI6ImVuIn0=")) {
                    Utility.takeScreenshot(driver);
                    return true;
                } else {
                    Utility.takeScreenshot(driver);
                    return false;
                }
            }
        }
        return false;
    }
}



