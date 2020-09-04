package com.fit.client.appointments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resource.ClientElements;
import resource.Utility;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;

public class AppointmentsPage {
    private RemoteWebDriver driver;
    private WebDriverWait wait;

    public AppointmentsPage(RemoteWebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Check Page")
    public void checkPage() {
        Utility.checkPage(driver, "https://client-dev.fitcrowd.net/classes");
    }

    @Step("Select Class")
    public WebElement selectClass() {
        //Get list of appointed classes
        List<WebElement> listOfClasses = driver.findElements(ClientElements.appointedClass);
        for (WebElement element : listOfClasses) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ClientElements.appointedClassDetails));
            List<WebElement> classDetails = element.findElements(ClientElements.appointedClassDetails);

            System.out.println(classDetails.get(0).getText());
            if (classDetails.get(0).getText().equals(" ")) {
                return null;
            } else {
                return element;
            }
        }
        return null;
    }


    @Step("View Class")
    public void viewClass() {
        WebElement element = this.selectClass();

        if (element == null)
            return;

        Actions builder = new Actions(driver);
        builder.moveToElement(element.findElement(ClientElements.infoButton)).click().perform();
    }

    @Step("Check Attend Class")
    public void checkAttendClass() {
        WebElement element = this.selectClass();

        if (element == null)
            return;

        Actions builder = new Actions(driver);
        if (element.findElement(ClientElements.attendButton).isEnabled()) {
            builder.moveToElement(element.findElement(ClientElements.attendButton)).click().perform();
            Assert.assertNotEquals(driver.getCurrentUrl(), "https://client-dev.fitcrowd.net/classes");
        }
    }

    @Step("Check Cancel Class")
    public void checkCancelClass() {
        WebElement element = this.selectClass();

        if (element == null)
            return;

        List<WebElement> classDetails = element.findElements(ClientElements.appointedClassDetails);
        if (element.findElement(ClientElements.cancelButton).getText().equals("CANCEL")) {
            element.findElement(ClientElements.cancelButton).click();
            driver.switchTo().activeElement();
            Actions builder = new Actions(driver);
            builder.moveToElement(driver.findElement(ClientElements.confirmButton)).click().perform();
            wait.until(ExpectedConditions.textToBe(ClientElements.statusText, "CANCELED"));
            Assert.assertEquals(classDetails.get(4).findElement(ClientElements.spanTag).getText(), "CANCELED");
        }
    }

    @Step("Check Book Class")
    public void checkBookClass() {
        WebElement element = this.selectClass();

        if (element == null)
            return;

        List<WebElement> classDetails = element.findElements(ClientElements.appointedClassDetails);
        if (element.findElement(ClientElements.bookButton).getText().equals("BOOK")) {
            element.findElement(ClientElements.bookButton).click();
            wait.until(ExpectedConditions.textToBe(ClientElements.statusText, "CONFIRMED"));
            Assert.assertEquals(classDetails.get(4).findElement(ClientElements.spanTag).getText(), "CONFIRMED");
        }
    }


}
