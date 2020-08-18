package com.fit.admin.trainerProfilePage;

import com.fit.admin.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TrainerProfileTests {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private TrainerProfile trainerProfile;

    @BeforeClass
    public void driverSetup() {
        driver = SingletonDriver.getInstance();
        wait = new WebDriverWait(driver, 30);
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
    public void updateFirstName() {
        trainerProfile.checkPage();
        trainerProfile.updateFirstName("Denis");
    }

    @Test(priority = 2)
    public void updateLastName() {
        trainerProfile.checkPage();
        trainerProfile.updateLastName("Iuriet");
    }

    @Test(priority = 3)
    public void updatePhoneNo() {
        trainerProfile.checkPage();
        trainerProfile.updatePhoneNo("123456789");
    }

    @Test(priority = 4)
    public void updateCountry() {
        trainerProfile.checkPage();
        trainerProfile.updateCountry("TestCountry");
    }

    @Test(priority = 5)
    public void updateCounty() {
        trainerProfile.checkPage();
        trainerProfile.updateCounty("TestCounty");
    }

    @Test(priority = 6)
    public void updateCity() {
        trainerProfile.checkPage();
        trainerProfile.updateCity("TestCity");
    }

    @Test(priority = 7)
    public void updateStreetName() {
        trainerProfile.checkPage();
        trainerProfile.updateStreetName("TestStreetName");
    }

    @Test(priority = 8)
    public void updateStreetNo() {
        trainerProfile.checkPage();
        trainerProfile.updateStreetNo("1");
    }

    @Test(priority = 9)
    public void updateDescription() {
        trainerProfile.checkPage();
        trainerProfile.updateDescription("TestDescription");
    }

    @Test(priority = 10)
    public void addAccreditation() {
        trainerProfile.checkPage();
        trainerProfile.insertAccreditation("TestAccreditation");
        trainerProfile.addAccreditation();
    }

    @Test(priority = 11)
    public void updateTrainerProfile() {
        trainerProfile.checkPage();
        trainerProfile.updateTrainerProfile();
    }

}
