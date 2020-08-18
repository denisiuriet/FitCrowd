package com.fit.admin.trainerProfilePage;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resource.Elements;
import resource.Utility;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;

public class TrainerProfile {
    private RemoteWebDriver driver;
    private WebDriverWait wait;

    public TrainerProfile(RemoteWebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Check Page")
    public void checkPage() {
        Utility.checkPage(driver, "https://admin-dev.fitcrowd.net/trainerProfile");
    }

    @Step("Add Trainer Image")
    public void addTrainerImage() throws IOException {
        Actions builder = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.trainerImage));
        builder.moveToElement(driver.findElement(Elements.trainerImage)).click().perform();
        Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/main/resources/" + "TrainerImageUpload.exe");
        Utility.takeScreenshot(driver);
    }

    @Step("Update First Name")
    public void updateFirstName(String firstName) {
        driver.findElement(Elements.trainerFirstName).clear();
        driver.findElement(Elements.trainerFirstName).sendKeys(firstName);
    }

    @Step("Update Last Name")
    public void updateLastName(String lastName) {
        driver.findElement(Elements.trainerLastName).clear();
        driver.findElement(Elements.trainerLastName).sendKeys(lastName);
    }

    @Step("Update Phone No.")
    public void updatePhoneNo(String phoneNo) {
        driver.findElement(Elements.trainerPhoneNo).clear();
        driver.findElement(Elements.trainerPhoneNo).sendKeys(phoneNo);
    }

    @Step("Update Country")
    public void updateCountry(String country) {
        driver.findElement(Elements.trainerCountry).clear();
        driver.findElement(Elements.trainerCountry).sendKeys(country);
    }

    @Step("Update County")
    public void updateCounty(String county) {
        driver.findElement(Elements.trainerCounty).clear();
        driver.findElement(Elements.trainerCounty).sendKeys(county);
    }

    @Step("Update City")
    public void updateCity(String city) {
        driver.findElement(Elements.trainerCity).clear();
        driver.findElement(Elements.trainerCity).sendKeys(city);
    }

    @Step("Update Street Name")
    public void updateStreetName(String streetName) {
        driver.findElement(Elements.trainerStreetName).clear();
        driver.findElement(Elements.trainerStreetName).sendKeys(streetName);
    }

    @Step("Update Street No.")
    public void updateStreetNo(String streetNo) {
        driver.findElement(Elements.trainerStreetNo).clear();
        driver.findElement(Elements.trainerStreetNo).sendKeys(streetNo);
    }

    @Step("Update Description")
    public void updateDescription(String description) {
        driver.findElement(Elements.trainerDescription).clear();
        driver.findElement(Elements.trainerDescription).sendKeys(description);
    }

    @Step("Insert Accreditation")
    public void insertAccreditation(String accreditation) {
        driver.findElement(Elements.trainerAccreditation).clear();
        driver.findElement(Elements.trainerAccreditation).sendKeys(accreditation);
    }

    @Step("Add Accreditation")
    public void addAccreditation() {
        driver.findElement(Elements.addAccreditation).click();
    }

    @Step("Update Trainer Profile")
    public void updateTrainerProfile() {
        driver.findElement(Elements.updateTrainerProfile).click();
    }
}
