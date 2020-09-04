package com.fit.admin.homePage;

import com.fit.admin.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTests {
    private RemoteWebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void driverSetup() {
        driver = SingletonDriver.getInstance();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        homePage = new HomePage(driver, wait);
    }

    @BeforeClass
    public void setDriver() {
        driver.navigate().to("https://admin-dev.fitcrowd.net/home");
    }

    @Test
    public void checkClass() {
        homePage.checkPage();
        homePage.checkAttendTodayClass();
    }
}
