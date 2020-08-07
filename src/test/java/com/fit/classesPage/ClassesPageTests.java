package com.fit.classesPage;

import com.fit.SingletonDriver;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resource.Elements;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class ClassesPageTests {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private ClassesPage classesPage;

    @BeforeClass(groups = {"create"})
    public void driverSetup() {
        driver = SingletonDriver.getInstance();
        wait = new WebDriverWait(driver, 30);
        classesPage = new ClassesPage(driver, wait);
    }

    @BeforeMethod(groups = {"create"})
    public void setDriver() {
        driver.navigate().to("https://admin-dev.fitcrowd.net/classes");
        //driver.manage().deleteAllCookies();
        //driver.navigate().to("https://admin-dev.fitcrowd.net/classes");
    }

    @Test(groups = {"create"})
    public void createClass() throws InterruptedException, AWTException {
        classesPage.checkPage();
        classesPage.addImage();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        classesPage.clickOnClassType();
        classesPage.setClassType(1);
        classesPage.setClassName("Test01");
        classesPage.clickClassLocation();
        classesPage.setClassLocation();
        classesPage.setOpenRegistration("8");
        classesPage.setCloseRegistration("0");
        classesPage.setParticipants("10");
        classesPage.setDuration("60");
        classesPage.clickBeginningDate();
        classesPage.setDayOfClass();
        classesPage.setTime("15:55");
        classesPage.setDescription("Class Description");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

