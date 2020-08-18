package com.fit.admin.homePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resource.Elements;
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

    public HomePage(RemoteWebDriver driver, WebDriverWait wait) {
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
    public void checkPage() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Step("Check Today Class")
    public void checkTodayClass() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.todayClasses));
        List<WebElement> listOfClasses = driver.findElements(Elements.todayClasses);
        String className;
        String classType;
        String classTime;
        WebElement button;
        here:
        for (WebElement element : listOfClasses) {
            className = element.findElement(Elements.todayClassName).getText();
            classType = element.findElement(Elements.todayClassType).getText();
            classTime = element.findElement(Elements.todayClassTime).getText();

            if (classType.equals("- online") && className.equals(this.data.get(1) + " " + classType) && classTime.equals(this.data.get(8))) {
                button = element.findElement(Elements.attendButton);
                button.click();
                Assert.assertEquals(driver.getCurrentUrl(), "https://admin-dev.fitcrowd.net/onlineClass/eyJlbWFpbCI6Iml1cmlldC5kZW5pc0BnbWFpbC5jb20iLCJ0b2tlbiI6IkhUZ3E3b2MyN0hCIiwicGFyZW50Q29tcG9uZW50IjoiZml0Y3Jvd2QiLCJsYW5ndWFnZSI6ImVuIn0=");
                break here;
            }
        }
    }
}



