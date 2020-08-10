package com.fit.schedulePage;

import com.fit.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.ParseException;

public class SchedulePageTests {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private SchedulePage schedulePage;

    @BeforeClass(groups = {"checkClass"})
    public void driverSetup(){
        driver = SingletonDriver.getInstance();
        wait = new WebDriverWait(driver, 30);
        schedulePage = new SchedulePage(driver, wait);
        schedulePage.readFile("ClassData.txt");
    }

    @BeforeClass(groups = {"checkClass"})
    public void setDriver(){
        driver.navigate().to("https://admin-dev.fitcrowd.net/schedule");
    }

    @Test(groups = {"checkClass"}, priority = -1)
    public void checkClassType(){
        schedulePage.checkPage();
        schedulePage.selectClass();
        schedulePage.checkClassType();
    }

    @Test(groups = {"checkClass"})
    public void checkClassName(){
        schedulePage.checkPage();
        schedulePage.checkClassName();
    }

    @Test(groups = {"checkClass"})
    public void checkClassLocation(){
        schedulePage.checkPage();
        schedulePage.checkClassLocation();
    }

    @Test(groups = {"checkClass"})
    public void checkClassDate(){
        schedulePage.checkPage();
        schedulePage.checkClassDate();
    }

    @Test(groups = {"checkClass"})
    public void checkStartTime(){
        schedulePage.checkPage();
        schedulePage.checkStartTime();
    }

    @Test(groups = {"checkClass"})
    public void checkFinishTime() throws ParseException {
        schedulePage.checkPage();
        schedulePage.checkFinishTime();
    }

    @Test(groups = {"checkClass"})
    public void checkClassParticipants(){
        schedulePage.checkPage();
        schedulePage.checkClassParticipants();
    }

    @Test(groups = {"checkClass"})
    public void checkClassOpenRegistration(){
        schedulePage.checkPage();
        schedulePage.checkOpenRegistration();
    }

    @Test(groups = {"checkClass"})
    public void checkClassCloseRegistration(){
        schedulePage.checkPage();
        schedulePage.checkCloseRegistration();
    }

    @Test(groups = {"checkClass"})
    public void checkClassDescription(){
        schedulePage.checkPage();
        schedulePage.checkDescription();
    }
}
