package com.fit.admin.homePage;

import com.fit.admin.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTests {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;

    @BeforeClass(groups = {"create"})
    public void driverSetup() {
        driver = SingletonDriver.getInstance();
        wait = new WebDriverWait(driver, 30);
        homePage = new HomePage(driver, wait);
        homePage.readFile("ClassData.txt");
    }

    @BeforeClass(groups = {"create"})
    public void setDriver() {
        driver.navigate().to("https://admin-dev.fitcrowd.net/home");
    }

    @Test(groups = {"create"})
    public void checkClass() {
        homePage.checkPage();
        homePage.checkTodayClass();
    }
}
