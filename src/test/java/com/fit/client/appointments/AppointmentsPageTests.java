package com.fit.client.appointments;

import com.fit.admin.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;

public class AppointmentsPageTests {
    private RemoteWebDriver driver;
    private AppointmentsPage appointmentsPage;

    @BeforeClass
    public void driverSetup() {
        driver = SingletonDriver.getInstance();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        appointmentsPage = new AppointmentsPage(driver, wait);
    }

    @BeforeMethod
    public void setDriver() {
        driver.navigate().to("https://client-dev.fitcrowd.net/classes");
    }

    @Test
    public void checkClass() throws ParseException {
        appointmentsPage.checkPage();
        appointmentsPage.viewClass();
        appointmentsPage.checkClassName();
        appointmentsPage.checkClassType();
        appointmentsPage.checkClassStatus();
        appointmentsPage.checkClassTrainer();
        appointmentsPage.checkClassDate();
        appointmentsPage.checkClassStartTime();
        appointmentsPage.checkClassFinishTime();
        appointmentsPage.checkClassLocation();
        appointmentsPage.checkClassDescription();
    }

    @Test
    public void checkAttendClass() throws ParseException {
        appointmentsPage.checkPage();
        appointmentsPage.checkAttendClass();
    }

    @Test(priority = 1)
    public void checkCancel() throws ParseException {
        appointmentsPage.checkPage();
        appointmentsPage.checkCancelClass();
    }

    @Test(priority = 2)
    public void checkBook() throws ParseException {
        appointmentsPage.checkPage();
        appointmentsPage.checkBookClass();
    }
}
