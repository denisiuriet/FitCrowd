package com.fit.admin.classesPage;

import com.fit.admin.SingletonDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ClassesPageTests {
    private RemoteWebDriver driver;
    private ClassesPage classesPage;

    @BeforeClass(groups = {"create"})
    public void driverSetup() throws IOException {
        driver = SingletonDriver.getInstance();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        classesPage = new ClassesPage(driver, wait);
        classesPage.setFile();
    }

    @BeforeClass(groups = {"create"})
    public void setDriver() {
        driver.navigate().to("https://admin-dev.fitcrowd.net/classes");
    }


    @Test(groups = {"create"})
    public void addImage() throws IOException {
        classesPage.checkPage();
        classesPage.addImage();
    }

    @Test(priority = -1, groups = {"create"})
    public void setClassType() throws IOException {
        classesPage.checkPage();
        classesPage.clickCreate();
        classesPage.selectClassType();
    }

    @Test(priority = 1, groups = {"create"})
    public void setClassName() throws IOException {
        classesPage.setClassName("Test1");
    }

    @Test(priority = 2, groups = {"create"})
    public void setClassLocation() throws IOException {
        classesPage.setClassLocation();
    }

    @Test(priority = 3, groups = {"create"})
    public void setOpenRegistration() throws IOException {
        classesPage.setOpenRegistration("24");
    }

    @Test(priority = 4, groups = {"create"})
    public void setCloseRegistration() throws IOException {
        classesPage.setCloseRegistration("0");
    }

    @Test(priority = 5, groups = {"create"})
    public void setParticipants() throws IOException {
        classesPage.setParticipants("10");
    }

    @Test(priority = 6, groups = {"create"})
    public void setDuration() throws IOException {
        classesPage.setDuration("45");
    }

    @Test(priority = 7, groups = {"create"})
    public void setBeginningDate() throws IOException {
        classesPage.clickBeginningDate();
        classesPage.setDate(3);
    }

    @Test(priority = 8, groups = {"create"})
    public void setTime() throws IOException {
        classesPage.setTime(Keys.NUMPAD0, Keys.NUMPAD0, Keys.NUMPAD2, Keys.NUMPAD3);
    }

    @Test(priority = 9, groups = {"create"})
    public void setDescription() throws IOException {
        classesPage.setDescription("Class Description");
    }

    @Test(priority = 10, groups = {"create"})
    public void createClass() throws IOException {
        classesPage.createClass();
        classesPage.closeFile();
    }

    // @Test(groups = {"create"}, priority = 12)
    // public void confirmClass() {
    //     classesPage.checkPage();
    //     classesPage.confirmClass();
    //  }


    @Test(priority = 13)
    public void viewClass() {
        classesPage.checkPage();
        classesPage.viewClass("Test1");
        classesPage.closeView();
    }

    @Test(priority = 14)
    public void editClassName() throws IOException {
        classesPage.checkPage();
        classesPage.editClass("Test1");
        classesPage.editClassName("Test2");
    }

    @Test(priority = 15)
    public void editClassImage() throws IOException {
        classesPage.checkPage();
        classesPage.editClassImage();
    }

    @Test(priority = 16)
    public void changeLocation() throws IOException {
        classesPage.checkPage();
        classesPage.changeLocation();
    }

    @Test(priority = 17)
    public void editOpenRegistration() throws IOException {
        classesPage.checkPage();
        classesPage.editOpenRegistration("10");
    }

    @Test(priority = 18)
    public void editCloseRegistration() throws IOException {
        classesPage.checkPage();
        classesPage.editCloseRegistration("5");
    }

    @Test(priority = 19)
    public void editClassParticipants() throws IOException {
        classesPage.checkPage();
        classesPage.editParticipants("15");
    }

    @Test(priority = 20)
    public void editClassDuration() throws IOException {
        classesPage.checkPage();
        classesPage.editDuration("45");
    }

    @Test(priority = 21)
    public void editBeginningDate() throws IOException {
        classesPage.checkPage();
        classesPage.editDate(4);
    }

    @Test(priority = 22)
    public void editTime() throws IOException {
        classesPage.checkPage();
        classesPage.editTime(Keys.NUMPAD4, Keys.NUMPAD5, Keys.NUMPAD1, Keys.NUMPAD9);
    }

    @Test(priority = 23)
    public void editDescription() throws IOException {
        classesPage.checkPage();
        classesPage.editDescription("New Description");
    }

    @Test(priority = 24)
    public void editClass() throws IOException {
        classesPage.checkPage();
        classesPage.editClass();
        classesPage.closeFile();
    }

    @Test(priority = 25)
    public void deleteClass() {
        classesPage.checkPage();
        classesPage.deleteClass("Test2");
        classesPage.confirmDeleteClass();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

