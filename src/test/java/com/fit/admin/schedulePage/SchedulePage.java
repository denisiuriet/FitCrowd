package com.fit.admin.schedulePage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resource.ClientElements;
import resource.Elements;
import resource.Utility;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SchedulePage {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private List<String> data;

    public SchedulePage(RemoteWebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
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
    public boolean checkPage() {
        return Utility.checkPage(driver, "https://admin-dev.fitcrowd.net/schedule");
    }

    @Step("Select Date")
    public void selectDate(int day) throws ParseException {
        driver.findElement(Elements.scheduleDayView).click();
        //Format the current date and add days to it
        SimpleDateFormat format = new SimpleDateFormat("MM/dd");
        //Get Current Date
        Calendar currentDate = Calendar.getInstance();
        //Add the number of days to current date
        currentDate.add(Calendar.DAY_OF_MONTH, day);
        //Format new date into a String to split it in month and day for later checks;
        String classDate = format.format(currentDate.getTime());
        String[] splitClassDate = classDate.split("/");
        int classMonth = Integer.parseInt(splitClassDate[0]);
        int classDay = Integer.parseInt(splitClassDate[1]);

        //Split the date from calendar
        String date = driver.findElement(ClientElements.date).getText();
        String[] split = date.split("\\s+");

        //Format the month
        SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM");
        Calendar cal = Calendar.getInstance();
        cal.setTime(inputFormat.parse(split[1]));
        //Get the month value, ex: for Aug, result = 8
        SimpleDateFormat outputFormat = new SimpleDateFormat("MM");

        //Get the month and the day from calendar to check it with the desired one;
        int calMonth = Integer.parseInt(outputFormat.format(cal.getTime()));
        int calDay = Integer.parseInt(split[2]);
        //As long as the calendar date is not the desired one, calendar will go on
        while (calMonth != classMonth ||
                calDay != classDay) {
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            //Go to next day;
            driver.findElement(ClientElements.nextButton).click();
            //Extract the date;
            date = driver.findElement(ClientElements.date).getText();
            split = date.split("\\s+");

            //Split the new date in month and day;
            //Month
            cal.setTime(inputFormat.parse(split[1]));
            calMonth = Integer.parseInt(outputFormat.format(cal.getTime()));

            //Day
            calDay = Integer.parseInt(split[2]);
        }
    }


    @Step("Select Class")
    public boolean selectClass() {
        //If there is no class on the selected day, exit
        if(driver.findElement(Elements.scheduleClasses).getText().equals("")){
            return false;
        }else{
            Actions builder = new Actions(driver);
            builder.moveToElement(driver.findElement(Elements.scheduleClasses).findElement(Elements.scheduleClass)).click().perform();

            return true;
        }

    }

    @Step("Edit class")
    public void editClass(){
        Boolean isClass = this.selectClass();

        if(isClass == false)
            return;

        driver.findElement(Elements.editButton).click();
    }

    @Step("Set date")
    public void editDate(int flag) {
        Boolean isClass = this.selectClass();

        if(isClass == false)
            return;

        driver.findElement(Elements.scheduleEditDate).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.scheduleTableOfDates));
        List<WebElement> listOfWeeks = driver.findElement(Elements.scheduleTableOfDates).findElement(Elements.calendar).findElements(Elements.calendarLines);

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        localDate.format(formatter);

        here:
        for (WebElement element : listOfWeeks) {
            List<WebElement> listOfDays = element.findElements(Elements.daysOfWeek);
            for (WebElement day : listOfDays) {

                if (day.getAttribute("class").equals("prev disabled") || day.getAttribute("class").equals("disabled"))
                    continue;

                int dayOfMonth = Integer.parseInt(day.getText());
                int actualDay = localDate.getDayOfMonth();
                actualDay = actualDay + flag;
                if (dayOfMonth >= actualDay) {
                    day.click();
                    break here;
                }
            }
        }
    }

    @Step("Edit class time")
    public void editTime(Keys min1, Keys min2, Keys hour1, Keys hour2) {
        Boolean isClass = this.selectClass();

        if(isClass == false)
            return;

        driver.findElement(Elements.classTime).sendKeys(min1);
        driver.findElement(Elements.classTime).sendKeys(min2);
        driver.findElement(Elements.classTime).sendKeys(Keys.ARROW_LEFT);
        driver.findElement(Elements.classTime).sendKeys(hour1);
        driver.findElement(Elements.classTime).sendKeys(hour2);

        Utility.takeScreenshot(driver);
    }

    @Step("Edit Open Registration")
    public void editOpenRegistration(String openRegistration) {
        Boolean isClass = this.selectClass();

        if(isClass == false)
            return;

        driver.findElement(Elements.scheduleOpenRegistration).clear();
        driver.findElement(Elements.scheduleOpenRegistration).sendKeys(openRegistration);
    }

    @Step("Edit Close Registration")
    public void editCloseRegistration(String closeRegistration) {
        Boolean isClass = this.selectClass();

        if(isClass == false)
            return;

        driver.findElement(Elements.closeRegistration).clear();
        driver.findElement(Elements.closeRegistration).sendKeys(closeRegistration);
    }

    @Step("Get alert message")
    public String getAlertMessage(){
        return driver.findElement(Elements.alertMessage).getText();
    }

    @Step("Confirm edit")
    public void confirmClassEdit(){
        Boolean isClass = this.selectClass();

        if(isClass == false)
            return;

        driver.findElement(Elements.saveButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.alertMessage));
        Assert.assertEquals(this.getAlertMessage(), "Class updated");
    }


}
