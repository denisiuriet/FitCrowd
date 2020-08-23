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

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AppointmentsPage {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private List<String> data;

    public AppointmentsPage(RemoteWebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Check Page")
    public void checkPage() {
        Utility.checkPage(driver, "https://client-dev.fitcrowd.net/classes");
    }

    public void readFile(String fileName) {
        this.data = new ArrayList<>();

        try {
            this.data = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Step("Select Class")
    public WebElement selectClass() throws ParseException {
        //Get list of appointed classes
        List<WebElement> listOfClasses = driver.findElements(ClientElements.appointedClass);

        for (WebElement element : listOfClasses) {
            //Get class info
            wait.until(ExpectedConditions.visibilityOfElementLocated(ClientElements.appointedClassDetails));
            List<WebElement> classDetails = element.findElements(ClientElements.appointedClassDetails);
            //Read the data store, when the class was booked;
            this.readFile("BookedClassDetails.txt");
            String trainerName = classDetails.get(1).findElement(ClientElements.spanTag).getText();
            wait.until(ExpectedConditions.visibilityOfElementLocated(ClientElements.appClassTime));
            String classTime = classDetails.get(2).findElement(ClientElements.appClassTime).getText();

            //Split the date, to format it
            String[] split = classTime.split(",");
            String[] splitDate = split[0].split("\\s+");

            //Format the month
            SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM");
            Calendar cal = Calendar.getInstance();
            cal.setTime(inputFormat.parse(splitDate[1]));
            //Get the month value, ex: for Aug, result = 8
            SimpleDateFormat outputFormat = new SimpleDateFormat("MM");

            //Merge the year, month a day into a String
            String date = splitDate[2] + "-" + outputFormat.format(cal.getTime()) + "-" + splitDate[0];

            if (this.data.get(3).equals(trainerName) && this.data.get(4).equals(date) && (" " + this.data.get(5)).equals(split[1])) {
                return element;
            }
        }
        return null;
    }

    @Step("Check Class Name")
    public void checkClassName() {
        Assert.assertEquals(driver.findElement(ClientElements.className).getAttribute("value"), this.data.get(0));
    }

    @Step("Check Class Type")
    public void checkClassType() {
        Assert.assertEquals(driver.findElement(ClientElements.classType).getAttribute("value"), this.data.get(1));
    }

    @Step("Check Class Status")
    public void checkClassStatus() {
        Assert.assertEquals(driver.findElement(ClientElements.classStatus).getAttribute("value"), this.data.get(2));
    }

    @Step("Check Class Trainer")
    public void checkClassTrainer() {
        Assert.assertEquals(driver.findElement(ClientElements.classTrainer).getText(), this.data.get(3));
    }

    @Step("Check Class Date")
    public void checkClassDate() {
        Assert.assertEquals(driver.findElement(ClientElements.classDate).getAttribute("value"), this.data.get(4));
    }

    @Step("Check Class Start Time")
    public void checkClassStartTime() {
        Assert.assertEquals(driver.findElement(ClientElements.classStartTime).getText(), this.data.get(5));
    }

    @Step("Check Class Finish Time")
    public void checkClassFinishTime() {
        Assert.assertEquals(driver.findElement(ClientElements.classFinishTime).getText(), this.data.get(6));
    }

    @Step("Check Class Location")
    public void checkClassLocation() {
        Assert.assertEquals(driver.findElement(ClientElements.classLocation).getText(), this.data.get(7));
    }

    @Step("Check Class Description")
    public void checkClassDescription() {
        Assert.assertEquals(driver.findElement(ClientElements.classDescription).getText(), this.data.get(8));
        driver.findElement(ClientElements.xButton).click();
    }

    @Step("View Class")
    public void viewClass() throws ParseException {
        WebElement element = this.selectClass();
        Actions builder = new Actions(driver);
        builder.moveToElement(element.findElement(ClientElements.infoButton)).click().perform();
    }

    @Step("Check Attend Class")
    public void checkAttendClass() throws ParseException {
        WebElement element = this.selectClass();
        Actions builder = new Actions(driver);
        builder.moveToElement(element.findElement(ClientElements.attendButton)).click().perform();
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://client-dev.fitcrowd.net/classes");
    }

    @Step("Check Cancel Class")
    public void checkCancelClass() throws ParseException {
        WebElement element = this.selectClass();
        List<WebElement> classDetails = element.findElements(ClientElements.appointedClassDetails);
        if (element.findElement(ClientElements.cancelButton).getText().equals("CANCEL")) {
            element.findElement(ClientElements.cancelButton).click();
            driver.switchTo().activeElement();
            driver.findElement(ClientElements.submitButton).click();
            wait.until(ExpectedConditions.textToBe(ClientElements.statusText, "CANCELED"));
            Assert.assertEquals(classDetails.get(4).findElement(ClientElements.spanTag).getText(), "CANCELED");
        }
    }

    @Step("Check Book Class")
    public void checkBookClass() throws ParseException {
        WebElement element = this.selectClass();
        List<WebElement> classDetails = element.findElements(ClientElements.appointedClassDetails);
        if (element.findElement(ClientElements.bookButton).getText().equals("BOOK")) {
            element.findElement(ClientElements.bookButton).click();
            wait.until(ExpectedConditions.textToBe(ClientElements.statusText, "CONFIRMED"));
            Assert.assertEquals(classDetails.get(4).findElement(ClientElements.spanTag).getText(), "CONFIRMED");
        }
    }


}
