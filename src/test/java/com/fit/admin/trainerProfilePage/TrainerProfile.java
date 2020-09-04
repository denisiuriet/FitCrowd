package com.fit.admin.trainerProfilePage;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resource.ClientElements;
import resource.Elements;
import resource.Utility;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TrainerProfile {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private FileWriter writer;
    private List<String> data;


    public TrainerProfile(RemoteWebDriver driver, WebDriverWait wait) throws IOException {
        this.driver = driver;
        this.wait = wait;
        this.data = new ArrayList<>();
        File file = new File("TrainerProfile.txt");
        this.writer = new FileWriter(file);
    }

    @Step("Check Page")
    public void checkPage() {
        Utility.checkPage(driver, "https://admin-dev.fitcrowd.net/trainerProfile");
    }

    public void readFile(String fileName) {
        this.data = new ArrayList<>();

        try {
            this.data = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
    public void updateFirstName(String firstName) throws IOException {
        driver.findElement(Elements.trainerFirstName).clear();
        driver.findElement(Elements.trainerFirstName).sendKeys(firstName);
        writer.write(firstName + "\n");
    }

    @Step("Update Last Name")
    public void updateLastName(String lastName) throws IOException {
        driver.findElement(Elements.trainerLastName).clear();
        driver.findElement(Elements.trainerLastName).sendKeys(lastName);
        writer.write(lastName + "\n");
    }

    @Step("Update Email")
    public void updateEmail(String email) throws IOException {
        driver.findElement(Elements.trainerEmail).clear();
        driver.findElement(Elements.trainerEmail).sendKeys(email);
        writer.write(email + "\n");
    }


    @Step("Update Phone No.")
    public void updatePhoneNo(String phoneNo) throws IOException {
        driver.findElement(Elements.trainerPhoneNo).clear();
        driver.findElement(Elements.trainerPhoneNo).sendKeys(phoneNo);
        writer.write(phoneNo + "\n");
    }

    @Step("Update Country")
    public void updateCountry(String country) throws IOException {
        driver.findElement(Elements.trainerCountry).clear();
        driver.findElement(Elements.trainerCountry).sendKeys(country);
        writer.write(country + "\n");

    }

    @Step("Update County")
    public void updateCounty(String county) throws IOException {
        driver.findElement(Elements.trainerCounty).clear();
        driver.findElement(Elements.trainerCounty).sendKeys(county);
        writer.write(county + "\n");
    }

    @Step("Update City")
    public void updateCity(String city) throws IOException {
        driver.findElement(Elements.trainerCity).clear();
        driver.findElement(Elements.trainerCity).sendKeys(city);
        writer.write(city + "\n");
    }

    @Step("Update Street Name")
    public void updateStreetName(String streetName) throws IOException {
        driver.findElement(Elements.trainerStreetName).clear();
        driver.findElement(Elements.trainerStreetName).sendKeys(streetName);
        writer.write(streetName + "\n");
    }

    @Step("Update Street No.")
    public void updateStreetNo(String streetNo) throws IOException {
        driver.findElement(Elements.trainerStreetNo).clear();
        driver.findElement(Elements.trainerStreetNo).sendKeys(streetNo);
        writer.write(streetNo + "\n");
    }

    @Step("Update Description")
    public void updateDescription(String description) throws IOException {
        driver.findElement(Elements.trainerDescription).clear();
        driver.findElement(Elements.trainerDescription).sendKeys(description);
        writer.write(description + "\n");
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
    public void updateTrainerProfile() throws IOException {
        driver.findElement(Elements.updateTrainerProfile).click();
        this.writer.flush();
        this.writer.close();
    }

    @Step("Get Alert Message")
    public String getAlertMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClientElements.alert));
        return driver.findElement(ClientElements.alert).getText();
    }

    @Step
    public void confirmUpdate() {
        this.readFile("TrainerProfile.txt");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.trainerFirstName));
        Assert.assertEquals(driver.findElement(Elements.trainerFirstName).getAttribute("value"), this.data.get(0));
        Assert.assertEquals(driver.findElement(Elements.trainerLastName).getAttribute("value"), this.data.get(1));
        Assert.assertEquals(driver.findElement(Elements.trainerEmail).getAttribute("value"), this.data.get(2));
        Assert.assertEquals(driver.findElement(Elements.trainerPhoneNo).getAttribute("value"), this.data.get(3));
        Assert.assertEquals(driver.findElement(Elements.trainerCountry).getAttribute("value"), this.data.get(4));
        Assert.assertEquals(driver.findElement(Elements.trainerCounty).getAttribute("value"), this.data.get(5));
        Assert.assertEquals(driver.findElement(Elements.trainerCity).getAttribute("value"), this.data.get(6));
        Assert.assertEquals(driver.findElement(Elements.trainerStreetName).getAttribute("value"), this.data.get(7));
        Assert.assertEquals(driver.findElement(Elements.trainerStreetNo).getAttribute("value"), this.data.get(8));
        Assert.assertEquals(driver.findElement(Elements.trainerDescription).getAttribute("value"), this.data.get(9));


    }
}
