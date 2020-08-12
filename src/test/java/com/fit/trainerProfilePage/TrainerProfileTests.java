package com.fit.trainerProfilePage;

import com.fit.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

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
    public void addImage() throws AWTException {
        trainerProfile.addTrainerImage();
    }

    @Test
    public void updateFirstName() {
        trainerProfile.checkPage();
        trainerProfile.updateFirstName("TestFirstName");
    }

    @Test
    public void updateLastName() {
        trainerProfile.checkPage();
        trainerProfile.updateLastName("TestLastName");
    }

    @Test
    public void updatePhoneNo() {
        trainerProfile.checkPage();
        trainerProfile.updatePhoneNo("987654321");
    }

    @Test
    public void updateCountry() {
        trainerProfile.checkPage();
        trainerProfile.updateCountry("TestCountry");
    }

    @Test
    public void updateCounty() {
        trainerProfile.checkPage();
        trainerProfile.updateCounty("TestCounty");
    }

    @Test
    public void updateCity() {
        trainerProfile.checkPage();
        trainerProfile.updateCity("TestCity");
    }

    @Test
    public void updateStreetName() {
        trainerProfile.checkPage();
        trainerProfile.updateStreetName("TestStreetName");
    }

    @Test
    public void updateStreetNo() {
        trainerProfile.checkPage();
        trainerProfile.updateStreetNo("1");
    }

    @Test
    public void updateDescription() {
        trainerProfile.checkPage();
        trainerProfile.updateDescription("TestDescription");
    }

    @Test
    public void addAccreditation(){
        trainerProfile.checkPage();
        trainerProfile.insertAccreditation("TestAccreditation");
        trainerProfile.addAccreditation();
    }

    @Test
    public void updateTrainerProfile(){
        trainerProfile.checkPage();
        trainerProfile.updateTrainerProfile();
    }
/*
    @Test
    public void changePassword(){
        trainerProfile.checkPage();
        trainerProfile.changePassword();
        trainerProfile.setCurrentPassword("abcd1234");
        trainerProfile.setNewPassword("1234abcd");
        trainerProfile.confirmNewPassword("1234abcd");
        trainerProfile.confirmChangePassword();
    }*/
}
