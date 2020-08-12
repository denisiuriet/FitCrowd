package com.fit.schedulePage;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resource.Elements;
import resource.Utility;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SchedulePage {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private List<String> data;

    public SchedulePage(RemoteWebDriver driver, WebDriverWait wait) {
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
    public boolean checkPage() {
        return Utility.checkPage(driver, "https://admin-dev.fitcrowd.net/schedule");
    }

    @Step("Select Class")
    public void selectClass(){
        driver.findElement(Elements.selectScheduledClass).click();
    }

    @Step("Check Class Type")
    public boolean checkClassType(){
        if(driver.findElement(Elements.scheduleClassType).getText().equals(this.data.get(0))){
            Utility.takeScreenshot(driver);
            return true;
        }else{
            Utility.takeScreenshot(driver);
            return false;
        }
    }

    @Step("Check Class Name")
    public void checkClassName(){
        Assert.assertEquals(driver.findElement(Elements.scheduleClassName).getAttribute("value"), this.data.get(1));
        System.out.println(driver.findElement(Elements.scheduleClassName).getAttribute("value"));
        System.out.println("Data: " + this.data.get(1));
    }

    @Step("Check Class Location")
    public void checkClassLocation(){
        Assert.assertEquals(driver.findElements(Elements.scheduleClassLocation).get(2).getText(), this.data.get(2));
        System.out.println(driver.findElements(Elements.scheduleClassLocation).get(2).getText());
        System.out.println(this.data.get(2));
    }

    @Step("Check Class Date")
    public void checkClassDate(){
        Assert.assertEquals(driver.findElement(Elements.scheduleClassDate).getAttribute("value"), this.data.get(7));
        System.out.println(driver.findElement(Elements.scheduleClassDate).getAttribute("value"));
        System.out.println(this.data.get(7));
    }

    @Step("Check Start Time")
    public void checkStartTime(){
        Assert.assertEquals(driver.findElement(Elements.startClassTime).getText(), this.data.get(8));
    }

    @Step("Check Finish Time")
    public void checkFinishTime() throws ParseException {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("H[:mm]");
        LocalTime localTime = LocalTime.parse(driver.findElement(Elements.startClassTime).getText(), parser);

        LocalTime newTime = localTime.plusMinutes(Integer.parseInt(this.data.get(6)));

        String finishTime = String.valueOf(newTime);

        Assert.assertEquals(finishTime, driver.findElement(Elements.finishClassTime).getText());

    }

    @Step("Check Max No. Of Participants")
    public void checkClassParticipants(){
        String getText = driver.findElement(Elements.scheduleClassParticipants).getText();
        String[] number = getText.split("/");
        int participants = Integer.parseInt(number[1]);

        Assert.assertEquals(participants, Integer.parseInt(this.data.get(5)));
    }

    @Step("Check Open Registraion")
    public void checkOpenRegistration(){
        Assert.assertEquals(driver.findElement(Elements.scheduleClassOpenRegistration).getText(), this.data.get(3));
    }

    @Step("Check Close Registration")
    public void checkCloseRegistration(){
        Assert.assertEquals(driver.findElement(Elements.scheduleClassCloseRegistration).getText(), this.data.get(4));
    }

    @Step("Check Description")
    public void checkDescription(){
        Assert.assertEquals(driver.findElement(Elements.scheduleClassDescription).getText(), this.data.get(9));
    }




}
