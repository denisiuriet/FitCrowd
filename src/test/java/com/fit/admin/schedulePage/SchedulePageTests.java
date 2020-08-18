package com.fit.admin.schedulePage;

import com.fit.admin.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SchedulePageTests {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private SchedulePage schedulePage;

    @BeforeClass(groups = {"checkClass", "create"})
    public void driverSetup() {
        driver = SingletonDriver.getInstance();
        wait = new WebDriverWait(driver, 30);
        schedulePage = new SchedulePage(driver);
        schedulePage.readFile("ClassData.txt");
    }

    @BeforeClass(groups = {"checkClass", "create"})
    public void setDriver() {
        driver.navigate().to("https://admin-dev.fitcrowd.net/schedule");
    }

    @Test(groups = {"checkClass", "create"}, priority = -1)
    public void checkClassType() {
        schedulePage.checkPage();
        schedulePage.selectClass();
        schedulePage.checkClassType();
    }


    @Test(groups = {"checkClass", "create"})
    public void checkClassName() {
        schedulePage.checkPage();
        schedulePage.checkClassName();
    }

    @Test(groups = {"checkClass", "create"})
    public void checkClassLocation() {
        schedulePage.checkPage();
        schedulePage.checkClassLocation();
    }

    @Test(groups = {"checkClass", "create"})
    public void checkClassDate() {
        schedulePage.checkPage();
        schedulePage.checkClassDate();
    }

    @Test(groups = {"checkClass", "create"})
    public void checkStartTime() {
        schedulePage.checkPage();
        schedulePage.checkStartTime();
    }

    @Test(groups = {"checkClass", "create"})
    public void checkFinishTime() {
        schedulePage.checkPage();
        schedulePage.checkFinishTime();
    }

    @Test(groups = {"checkClass", "create"})
    public void checkClassParticipants() {
        schedulePage.checkPage();
        schedulePage.checkClassParticipants();
    }

    @Test(groups = {"checkClass", "create"})
    public void checkClassOpenRegistration() {
        schedulePage.checkPage();
        schedulePage.checkOpenRegistration();
    }

    @Test(groups = {"checkClass", "create"})
    public void checkClassCloseRegistration() {
        schedulePage.checkPage();
        schedulePage.checkCloseRegistration();
    }

    @Test(groups = {"checkClass", "create"})
    public void checkClassDescription() {
        schedulePage.checkPage();
        schedulePage.checkDescription();
    }
}