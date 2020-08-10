package com.fit.classesPage;

import com.fit.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ClassesPageTests {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private ClassesPage classesPage;

    @BeforeClass(groups = {"create"})
    public void driverSetup() throws IOException {
        driver = SingletonDriver.getInstance();
        wait = new WebDriverWait(driver, 30);
        classesPage = new ClassesPage(driver, wait);
        classesPage.setFile();
    }

    @BeforeClass(groups = {"create"})
    public void setDriver() {
        driver.navigate().to("https://admin-dev.fitcrowd.net/classes");
    }

    @Test(groups = {"create"})
    public void addImage() throws AWTException, IOException {
        classesPage.checkPage();
        classesPage.addImage();
    }

    @Test(groups = {"create"}, priority = 1)
    public void setClassType() throws IOException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        classesPage.clickOnClassType();
        classesPage.setClassType();
    }

    @Test(groups = {"create"}, priority = 2)
    public void setClassName() throws IOException {
        classesPage.setClassName("Test01");
    }

    @Test(groups = {"create"}, priority = 3)
    public void setClassLocation() throws IOException {
        classesPage.clickClassLocation();
        classesPage.setClassLocation();
    }

    @Test(groups = {"create"}, priority = 4)
    public void setOpenRegistration() throws IOException {
        classesPage.setOpenRegistration("8");
    }

    @Test(groups = {"create"}, priority = 5)
    public void setCloseRegistration() throws IOException {
        classesPage.setCloseRegistration("0");
    }

    @Test(groups = {"create"}, priority = 6)
    public void setParticipants() throws IOException {
        classesPage.setParticipants("10");
    }

    @Test(groups = {"create"}, priority = 7)
    public void setDuration() throws IOException {
        classesPage.setDuration("60");
    }

    @Test(groups = {"create"}, priority = 8)
    public void setBeginningDate() throws IOException {
        classesPage.clickBeginningDate();
        classesPage.setDayOfClass();
    }

    @Test(groups = {"create"}, priority = 9)
    public void setTime() throws IOException {
        classesPage.setTime("15");
    }

    @Test(groups = {"create"}, priority = 10)
    public void setDescription() throws IOException {
        classesPage.setDescription("Class Description");
    }

    @Test(groups = {"create"}, priority = 11)
    public void createClass() throws IOException {
        classesPage.createClass();
        classesPage.closeFile();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

