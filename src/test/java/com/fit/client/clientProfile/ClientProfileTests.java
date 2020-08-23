package com.fit.client.clientProfile;

import com.fit.admin.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import resource.ClientElements;

import java.io.IOException;

public class ClientProfileTests {
    private RemoteWebDriver driver;
    private ClientProfile clientProfile;

    @BeforeClass
    public void driverSetup() throws IOException {
        driver = SingletonDriver.getInstance();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        clientProfile = new ClientProfile(driver, wait);
    }

    @BeforeClass
    public void setDriver() {
        driver.navigate().to("https://client-dev.fitcrowd.net/clientProfile");
    }

    @Test
    public void uploadImage() throws IOException {
        clientProfile.checkPage();
        clientProfile.uploadClientImage();
    }

    @Test(priority = 1)
    public void updateFirstName() throws IOException {
        clientProfile.checkPage();
        clientProfile.updateFirstName("Denis");
    }

    @Test(priority = 2)
    public void updateLastName() throws IOException {
        clientProfile.checkPage();
        clientProfile.updateLastName("Iuriet");
    }

    @Test(priority = 3)
    public void updatePhoneNumber() throws IOException {
        clientProfile.checkPage();
        clientProfile.updatePhone("987654321");
    }

    @Test(priority = 4)
    public void updateEmail() throws IOException {
        clientProfile.checkPage();
        clientProfile.updateEmail("Denis.yonutz98@gmail.com");
    }

    @Test(priority = 5)
    public void updateStreetName() throws IOException {
        clientProfile.checkPage();
        clientProfile.updateStreetName("Dorobantilor");
    }

    @Test(priority = 6)
    public void updateStreetNumber() throws IOException {
        clientProfile.checkPage();
        clientProfile.updateStreetNumber("20");
    }

    @Test(priority = 7)
    public void updateCity() throws IOException {
        clientProfile.checkPage();
        clientProfile.updateCity("Cluj-Napoca");
    }

    @Test(priority = 8)
    public void updateCountry() throws IOException {
        clientProfile.checkPage();
        clientProfile.updateCountry("Romania");
    }

    @Test(priority = 9)
    public void updateCounty() throws IOException {
        clientProfile.checkPage();
        clientProfile.updateCounty("Cluj");
    }

    @Test(priority = 10)
    public void updateProfile() throws IOException {
        clientProfile.checkPage();
        clientProfile.updateProfile();
        Assert.assertEquals(clientProfile.getAlertMessage(), ClientElements.updateAlertMessage);
    }

    @Test(priority = 11)
    public void confirmUpdateProfile() {
        clientProfile.checkPage();
        clientProfile.confirmUpdate();
    }
}
