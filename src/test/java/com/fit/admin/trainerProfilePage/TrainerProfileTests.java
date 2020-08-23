package com.fit.admin.trainerProfilePage;

import com.fit.admin.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TrainerProfileTests {
    private RemoteWebDriver driver;
    private TrainerProfile trainerProfile;

    @BeforeClass
    public void driverSetup() throws IOException {
        driver = SingletonDriver.getInstance();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        trainerProfile = new TrainerProfile(driver, wait);
    }

    @BeforeClass
    public void setDriver() {
        driver.navigate().to("https://admin-dev.fitcrowd.net/trainerProfile");
    }

    @Test
    public void addImage() throws IOException {
        trainerProfile.addTrainerImage();
    }

    @Test(priority = 1)
    public void updateFirstName() throws IOException {
        trainerProfile.checkPage();
        trainerProfile.updateFirstName("Denis");
    }

    @Test(priority = 2)
    public void updateLastName() throws IOException {
        trainerProfile.checkPage();
        trainerProfile.updateLastName("Iuriet");
    }

    @Test(priority = 3)
    public void updateEmail() throws IOException {
        trainerProfile.checkPage();
        trainerProfile.updateEmail("iuriet.denis@gmail.com");
    }

    @Test(priority = 4)
    public void updatePhoneNo() throws IOException {
        trainerProfile.checkPage();
        trainerProfile.updatePhoneNo("123456789");
    }

    @Test(priority = 5)
    public void updateCountry() throws IOException {
        trainerProfile.checkPage();
        trainerProfile.updateCountry("TestCountry");
    }

    @Test(priority = 6)
    public void updateCounty() throws IOException {
        trainerProfile.checkPage();
        trainerProfile.updateCounty("TestCounty");
    }

    @Test(priority = 7)
    public void updateCity() throws IOException {
        trainerProfile.checkPage();
        trainerProfile.updateCity("TestCity");
    }

    @Test(priority = 8)
    public void updateStreetName() throws IOException {
        trainerProfile.checkPage();
        trainerProfile.updateStreetName("TestStreetName");
    }

    @Test(priority = 9)
    public void updateStreetNo() throws IOException {
        trainerProfile.checkPage();
        trainerProfile.updateStreetNo("1");
    }

    @Test(priority = 10)
    public void updateDescription() throws IOException {
        trainerProfile.checkPage();
        trainerProfile.updateDescription("TestDescription");
    }

    @Test(priority = 11)
    public void addAccreditation() {
        trainerProfile.checkPage();
        trainerProfile.insertAccreditation("TestAccreditation");
        trainerProfile.addAccreditation();
    }

    @Test(priority = 12)
    public void updateTrainerProfile() throws IOException {
        trainerProfile.checkPage();
        trainerProfile.updateTrainerProfile();
        Assert.assertEquals(trainerProfile.getAlertMessage(), "Profile updated");
    }

    @Test(priority = 13)
    public void confirmUpdateProfile() {
        trainerProfile.checkPage();
        trainerProfile.confirmUpdate();
    }

}
