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
    private WebDriverWait wait;
    private ClassesPage classesPage;

    @BeforeClass(groups = {"create", "delete", "view", "edit"})
    public void driverSetup() throws IOException {
        driver = SingletonDriver.getInstance();
        wait = new WebDriverWait(driver, 30);
        classesPage = new ClassesPage(driver, wait);
        classesPage.setFile();
    }

    @BeforeClass(groups = {"create", "delete", "view", "edit"})
    public void setDriver() {
        driver.navigate().to("https://admin-dev.fitcrowd.net/classes");
    }


    @Test(groups = {"create"})
    public void addImage() throws IOException {
        classesPage.checkPage();
        classesPage.addImage();
    }

    @Test(groups = {"create"}, priority = -2)
    public void setClassType() throws IOException {
        classesPage.checkPage();
        classesPage.clickCreate();
        classesPage.selectClassType();
    }

    @Test(groups = {"create"}, priority = 2)
    public void setClassName() throws IOException {
        classesPage.setClassName("Test19");
    }

    @Test(groups = {"create"}, priority = -1)
    public void setClassLocation() throws IOException {
        classesPage.setClassLocation();
    }

    @Test(groups = {"create"}, priority = 4)
    public void setOpenRegistration() throws IOException {
        classesPage.setOpenRegistration("24");
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
        classesPage.setDuration("45");
    }

    @Test(groups = {"create"}, priority = 8)
    public void setBeginningDate() throws IOException {
        classesPage.clickBeginningDate();
        classesPage.setDate(0);
    }

    @Test(groups = {"create"}, priority = 9)
    public void setTime() throws IOException {
        classesPage.setTime(Keys.NUMPAD0, Keys.NUMPAD0, Keys.NUMPAD2, Keys.NUMPAD3);
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

    @Test(groups = {"create"}, priority = 12)
    public void confirmClass() {
        classesPage.checkPage();
        classesPage.confirmClass();
    }

    @Test(groups = {"delete"})
    public void deleteClass() {
        classesPage.checkPage();
        classesPage.deleteClass("Test18");
        classesPage.confirmDeleteClass();
    }

    @Test(groups = {"view"})
    public void viewClass() {
        classesPage.checkPage();
        classesPage.viewClass("Test18");
        classesPage.closeView();
    }

    @Test(groups = {"edit"}, priority = -2)
    public void editClassName() throws IOException {
        classesPage.checkPage();
        classesPage.editClass("Test18");
        classesPage.editClassName("Test20");
    }

    @Test(groups = {"edit"})
    public void editClassImage() throws IOException {
        classesPage.checkPage();
        classesPage.editClassImage();
    }

    @Test(groups = {"edit"}, priority = -1)
    public void changeLocation() throws IOException {
        classesPage.checkPage();
        classesPage.changeLocation();
    }

    @Test(groups = {"edit"}, priority = 2)
    public void editOpenRegistration() throws IOException {
        classesPage.checkPage();
        classesPage.editOpenRegistration("10");
    }

    @Test(groups = {"edit"}, priority = 3)
    public void editCloseRegistration() throws IOException {
        classesPage.checkPage();
        classesPage.editCloseRegistration("5");
    }

    @Test(groups = {"edit"}, priority = 4)
    public void editClassParticipants() throws IOException {
        classesPage.checkPage();
        classesPage.editParticipants("15");
    }

    @Test(groups = {"edit"}, priority = 5)
    public void editClassDuration() throws IOException {
        classesPage.checkPage();
        classesPage.editDuration("45");
    }

    @Test(groups = {"edit"}, priority = 6)
    public void editBeginningDate() throws IOException {
        classesPage.checkPage();
        classesPage.editDate(0);
    }

    @Test(groups = {"edit"}, priority = 7)
    public void editTime() throws IOException {
        classesPage.checkPage();
        classesPage.editTime(Keys.NUMPAD4, Keys.NUMPAD5, Keys.NUMPAD1, Keys.NUMPAD9);
    }

    @Test(groups = {"edit"}, priority = 8)
    public void editDescription() throws IOException {
        classesPage.checkPage();
        classesPage.editDescription("New Description");
    }

    @Test(groups = {"edit"}, priority = 9)
    public void editClass() throws IOException {
        classesPage.checkPage();
        classesPage.editClass();
        classesPage.closeFile();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

