package com.fit.admin.classesPage;

import com.fit.admin.SingletonDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ClassesPageTests {
    private RemoteWebDriver driver;
    private ClassesPage classesPage;

    @BeforeClass
    public void driverSetup() throws IOException {
        driver = SingletonDriver.getInstance();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        classesPage = new ClassesPage(driver, wait);
    }

    @BeforeMethod
    public void setDriver() {
        driver.navigate().to("https://admin-dev.fitcrowd.net/classes");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }


    @Test
    public void createClass() throws IOException, InterruptedException {
        classesPage.checkPage();
        classesPage.clickCreate();
        classesPage.selectClassType();
        classesPage.setClassName("Test7");
        classesPage.setClassLocation(0);
        classesPage.addImage();
        classesPage.setOpenRegistration("24");
        classesPage.setCloseRegistration("0");
        classesPage.setParticipants("10");
        classesPage.setDuration("45");
        classesPage.clickBeginningDate();
        classesPage.setDate(1);
        classesPage.setTime(Keys.NUMPAD0, Keys.NUMPAD0, Keys.NUMPAD2, Keys.NUMPAD3);
        classesPage.setDescription("Class Description");
        classesPage.createClass();
        classesPage.closeFile();
    }


    @Test(priority = 1)
    public void viewClass() {
        classesPage.checkPage();
        classesPage.viewClass();
        classesPage.closeView();
    }

    @Test(priority = 2)
    public void editClass() throws IOException, InterruptedException {
        classesPage.checkPage();
        classesPage.editClass();
        classesPage.editClassName("Test8");
        classesPage.changeLocation();
        classesPage.editClassImage();
        classesPage.editOpenRegistration("10");
        classesPage.editCloseRegistration("5");
        classesPage.editParticipants("15");
        classesPage.editDuration("45");
        classesPage.editDate(4);
        classesPage.editTime(Keys.NUMPAD4, Keys.NUMPAD5, Keys.NUMPAD1, Keys.NUMPAD9);
        classesPage.editDescription("New Description");
        classesPage.confirmEditClass();
        classesPage.closeFile();
    }


    @Test(priority = 3)
    public void deleteClass() {
        classesPage.checkPage();
        classesPage.deleteClass();
        classesPage.confirmDeleteClass();
    }

}

