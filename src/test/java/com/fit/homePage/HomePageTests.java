package com.fit.homePage;

import com.fit.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTests {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;

    @BeforeClass(groups = {"checkHome"})
    public void driverSetup(){
        driver = SingletonDriver.getInstance();
        wait = new WebDriverWait(driver, 30);
        homePage = new HomePage(driver, wait);
        homePage.readFile("ClassData.txt");
    }

    @BeforeClass(groups = {"checkHome"})
    public void setDriver(){
        driver.navigate().to("https://admin-dev.fitcrowd.net/home");
    }

    @Test(groups = {"checkHome"})
    public void checkClass(){
        homePage.checkPage();
        homePage.checkTodayClass();
    }
}
