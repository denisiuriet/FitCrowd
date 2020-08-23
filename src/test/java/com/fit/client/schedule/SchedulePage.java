package com.fit.client.schedule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resource.ClientElements;
import resource.Utility;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SchedulePage {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private FileWriter writer;
    private List<String> data;

    public SchedulePage(RemoteWebDriver driver, WebDriverWait wait) throws IOException {
        this.driver = driver;
        this.wait = wait;
        writer = new FileWriter("BookedClassDetails.txt");
    }

    public void readFile(String fileName) {
        this.data = new ArrayList<>();

        try {
            this.data = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Step("Check Page")
    public void checkPage() {
        Utility.checkPage(driver, "https://client-dev.fitcrowd.net/schedule");
    }

    @Step("View Classes/Day")
    public void dayView() {
        driver.findElement(ClientElements.dayButton).click();
    }

    @Step("Get calendar date")
    public void selectDate(int month, int day) throws ParseException {
        //Split the date from calendar
        String date = driver.findElement(ClientElements.date).getText();
        String[] split = date.split("\\s+");

        //Format the month
        SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM");
        Calendar cal = Calendar.getInstance();
        cal.setTime(inputFormat.parse(split[1]));
        //Get the month value, ex: for Aug, result = 8
        SimpleDateFormat outputFormat = new SimpleDateFormat("MM");

        int calMonth = Integer.parseInt(outputFormat.format(cal.getTime()));
        int calDay = Integer.parseInt(split[2]);
        //As long as the calendar date is not the desired one, calendar will go on
        while (calMonth != month ||
                calDay != day) {
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.findElement(ClientElements.nextButton).click();
            date = driver.findElement(ClientElements.date).getText();
            split = date.split("\\s+");

            //Month
            cal.setTime(inputFormat.parse(split[1]));
            calMonth = Integer.parseInt(outputFormat.format(cal.getTime()));

            //Day
            calDay = Integer.parseInt(split[2]);
        }
    }

    @Step("Check no. of participants")
    public boolean checkNoOfParticipants() {
        String participants = driver.findElement(ClientElements.noOfParticipants).getText();
        String[] split = participants.split("/");
        int noOfParticipants = Integer.parseInt(split[0]);
        int maxNoOfParticipants = Integer.parseInt(split[1]);

        return noOfParticipants != maxNoOfParticipants;
    }

    @Step("Check Reservations")
    public boolean checkReservations() {
        String message = driver.findElement(ClientElements.reservation).getText();

        return message.equals(ClientElements.reservationText);
    }

    @Step("Get alert message")
    public String getAlertMessage() {
        return driver.findElement(ClientElements.alert).getText();
    }

    @Step("Get class details")
    public void getClassDetails() throws IOException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClientElements.className));
        writer.write(driver.findElement(ClientElements.className).getAttribute("value") + "\n");
        writer.write(driver.findElement(ClientElements.classType).getAttribute("value") + "\n");
        writer.write(driver.findElement(ClientElements.classStatus).getAttribute("value") + "\n");
        writer.write(driver.findElement(ClientElements.classTrainer).getText() + "\n");
        writer.write(driver.findElement(ClientElements.classDate).getAttribute("value") + "\n");
        writer.write(driver.findElement(ClientElements.classStartTime).getText() + "\n");
        writer.write(driver.findElement(ClientElements.classFinishTime).getText() + "\n");
        writer.write(driver.findElement(ClientElements.classLocation).getText() + "\n");
        writer.write(driver.findElement(ClientElements.classDescription).getText() + "\n");
        writer.flush();
        writer.close();
    }

    @Step("Select class")
    public void bookClass() throws IOException {
        //If exists, get the classes of the selected day
        List<WebElement> listOfClasses = driver.findElements(ClientElements.classesOfDay);

        //Check if there are classes on the selected day
        if (listOfClasses.size() == 0) {
            System.out.println("On the selected day, there is no class");
            return;
        }
        for (WebElement element : listOfClasses) {
            //Click on the first class found in the schedule
            element.click();
            driver.switchTo().activeElement();

            /*Check if the maximum number of participants allowed has not been exceeded
             * - check if the reservations are open
             * - check if the class isn't already booked
             */
            wait.until(ExpectedConditions.visibilityOfElementLocated(ClientElements.submitButton));
            WebElement button = driver.findElement(ClientElements.submitButton);
            if (this.checkNoOfParticipants() && this.checkReservations() && button.getText().equals(ClientElements.bookButtonText)) {
                //Get the class name to check further the alert message
                String className = driver.findElement(ClientElements.className).getAttribute("value");
                //Book the class
                button.click();
                //Wait the alert to appear
                wait.until(ExpectedConditions.visibilityOfElementLocated(ClientElements.alert));
                //Check if the correct message is shown
                Assert.assertEquals(this.getAlertMessage(), ClientElements.successfulBook + className + " class! " + ClientElements.checkAppointmentsMessage);
                //Click again on the class to get the class fields
                element.click();
                //Store the class details into a file to check if they are the same in the Appointments page
                this.getClassDetails();
                driver.findElement(ClientElements.closeButton).click();
                break;
            } else {
                driver.findElement(ClientElements.closeButton).click();
            }
        }

    }

    @Step("Attend to Online Class")
    public void attendToOnlineClass() {
        List<WebElement> listOfClasses = driver.findElements(ClientElements.classesOfDay);
        String classType;
        String classStatus;
        this.readFile("BookedClassDetails.txt");
        for (WebElement element : listOfClasses) {
            element.click();
            if (driver.findElement(ClientElements.className).getAttribute("value").equals(this.data.get(0))) {
                classType = driver.findElement(ClientElements.classType).getAttribute("value");
                classStatus = driver.findElement(ClientElements.classStatus).getAttribute("value");
                if (classType.equals("Online") && classStatus.equals("CONFIRMED")) {
                    driver.findElement(ClientElements.submitButton).click();
                    Assert.assertNotEquals(driver.getCurrentUrl(), "https://client-dev.fitcrowd.net/schedule");
                    break;
                }
            } else {
                driver.findElement(ClientElements.closeButton).click();
            }
        }

    }
}
