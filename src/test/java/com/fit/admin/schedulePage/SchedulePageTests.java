package com.fit.admin.schedulePage;

import com.fit.admin.SingletonDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.ParseException;


public class SchedulePageTests {
    private RemoteWebDriver driver;
    private SchedulePage schedulePage;

    @BeforeClass
    public void driverSetup() {
        driver = SingletonDriver.getInstance();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        schedulePage = new SchedulePage(driver, wait);
        schedulePage.readFile("ClassData.txt");
    }

    @BeforeClass
    public void setDriver() {
        driver.navigate().to("https://admin-dev.fitcrowd.net/schedule");
    }


    @Test(priority = 1)
    public void editClass() throws ParseException {
        schedulePage.checkPage();
        schedulePage.selectDate(4);
        schedulePage.selectClass();
        schedulePage.editClass();
    }

    @Test(priority = 2)
    public void editDate() {
        schedulePage.checkPage();
        schedulePage.editDate(5);
    }

    @Test(priority = 3)
    public void editTime() {
        schedulePage.checkPage();
        schedulePage.editTime(Keys.NUMPAD0, Keys.NUMPAD0, Keys.NUMPAD1, Keys.NUMPAD9);
    }

    @Test(priority = 4)
    public void editOpenRegistration() {
        schedulePage.checkPage();
        schedulePage.editOpenRegistration("30");
    }

    @Test(priority = 5)
    public void editCloseRegistration() {
        schedulePage.checkPage();
        schedulePage.editCloseRegistration("1");
    }

    @Test(priority = 6)
    public void confirmClassEdit(){
        schedulePage.checkPage();
        schedulePage.confirmClassEdit();
    }
}
