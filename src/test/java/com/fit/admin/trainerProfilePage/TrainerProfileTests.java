package com.fit.admin.trainerProfilePage;

import com.fit.admin.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

    @BeforeMethod
    public void setDriver() {
        driver.navigate().to("https://admin-dev.fitcrowd.net/trainerProfile");
    }

    @Test
    public void updateTrainerProfile() throws IOException {
        trainerProfile.checkPage();
        trainerProfile.addTrainerImage();
        trainerProfile.updateFirstName("Denis");
        trainerProfile.updateLastName("Iuriet");
        trainerProfile.updateEmail("denisiuriet.test@gmail.com");
        trainerProfile.updatePhoneNo("123456789");
        trainerProfile.updateCountry("TestCountry");
        trainerProfile.updateCounty("TestCounty");
        trainerProfile.updateCity("TestCity");
        trainerProfile.updateStreetName("TestStreetName");
        trainerProfile.updateStreetNo("1");
        trainerProfile.updateDescription("TestDescription");
        trainerProfile.insertAccreditation("TestAccreditation");
        trainerProfile.addAccreditation();
        trainerProfile.updateTrainerProfile();
        Assert.assertEquals(trainerProfile.getAlertMessage(), "Profile updated");
    }

    @Test(priority = 1)
    public void confirmUpdateProfile() {
        trainerProfile.checkPage();
        trainerProfile.confirmUpdate();
    }

}
