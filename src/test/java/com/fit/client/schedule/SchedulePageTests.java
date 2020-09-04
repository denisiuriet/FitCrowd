package com.fit.client.schedule;

import com.fit.admin.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class SchedulePageTests {
    private RemoteWebDriver driver;
    private SchedulePage schedulePage;

    @BeforeClass
    public void driverSetup() throws IOException {
        driver = SingletonDriver.getInstance();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        schedulePage = new SchedulePage(driver, wait);
    }

    @BeforeClass
    public void setDriver() {
        driver.navigate().to("https://client-dev.fitcrowd.net/schedule");
    }

    @Test
    public void selectDate() throws ParseException {
        schedulePage.checkPage();
        schedulePage.dayView();
        schedulePage.selectDate(0);
    }

    @Test(priority = 1)
    public void cancelClass() {
        schedulePage.checkPage();
        schedulePage.cancelClass();
    }

    @Test(priority = 2)
    public void bookClass() throws IOException {
        schedulePage.checkPage();
        schedulePage.bookClass();
    }

    @Test(priority = 3)
    public void attendToOnlineClass() {
        schedulePage.checkPage();
        schedulePage.attendToOnlineClass();
    }
}
