package com.fit.client.appointments;

import com.fit.admin.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void inspectClass() {
        appointmentsPage.checkPage();
        appointmentsPage.viewClass();
    }

    @Test
    public void checkAttendClass() {
        appointmentsPage.checkPage();
        appointmentsPage.checkAttendClass();
    }

    @Test(priority = 1)
    public void checkCancel() {
        appointmentsPage.checkPage();
        appointmentsPage.checkCancelClass();
    }

    @Test(priority = 2)
    public void checkBook() {
        appointmentsPage.checkPage();
        appointmentsPage.checkBookClass();
    }
}
