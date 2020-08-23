package com.fit.client.clientProfile;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resource.ClientElements;
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

public class ClientProfile {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private FileWriter writer;
    private List<String> data;

    public ClientProfile(RemoteWebDriver driver, WebDriverWait wait) throws IOException {
        this.driver = driver;
        this.wait = wait;
        this.data = new ArrayList<>();
        File file = new File("ClientProfile.txt");
        this.writer = new FileWriter(file);
    }

    @Step("Check Page")
    public void checkPage() {
        Utility.checkPage(driver, "https://client-dev.fitcrowd.net/clientProfile");
    }

    public void readFile(String fileName) {
        this.data = new ArrayList<>();

        try {
            this.data = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Step("Upload Client Image")
    public void uploadClientImage() throws IOException {
        Actions builder = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClientElements.uploadImage));
        builder.moveToElement(driver.findElement(ClientElements.uploadImage)).click().perform();
        Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/main/resources/" + "ClientImageUpload.exe");
        Utility.takeScreenshot(driver);
    }

    @Step("Update First Name")
    public void updateFirstName(String firstName) throws IOException {
        driver.findElement(ClientElements.clientFirstName).clear();
        driver.findElement(ClientElements.clientFirstName).sendKeys(firstName);
        writer.write(firstName + "\n");
    }

    @Step("Update Last Name")
    public void updateLastName(String lastName) throws IOException {
        driver.findElement(ClientElements.clientLastName).clear();
        driver.findElement(ClientElements.clientLastName).sendKeys(lastName);
        writer.write(lastName + "\n");
    }

    @Step("Update Phone Number")
    public void updatePhone(String phoneNumber) throws IOException {
        driver.findElement(ClientElements.clientPhoneNumber).clear();
        driver.findElement(ClientElements.clientPhoneNumber).sendKeys(phoneNumber);
        writer.write(phoneNumber + "\n");
    }

    @Step("Update Email")
    public void updateEmail(String email) throws IOException {
        driver.findElement(ClientElements.clientProfileEmail).clear();
        driver.findElement(ClientElements.clientProfileEmail).sendKeys(email);
        writer.write(email + "\n");
    }

    @Step("Update Street Name")
    public void updateStreetName(String streetName) throws IOException {
        driver.findElement(ClientElements.clientStreetName).clear();
        driver.findElement(ClientElements.clientStreetName).sendKeys(streetName);
        writer.write(streetName + "\n");
    }

    @Step("Update Street Number")
    public void updateStreetNumber(String streetNumber) throws IOException {
        driver.findElement(ClientElements.clientStreetNumber).clear();
        driver.findElement(ClientElements.clientStreetNumber).sendKeys(streetNumber);
        writer.write(streetNumber + "\n");
    }

    @Step("Update City")
    public void updateCity(String city) throws IOException {
        driver.findElement(ClientElements.clientCity).clear();
        driver.findElement(ClientElements.clientCity).sendKeys(city);
        writer.write(city + "\n");
    }

    @Step("Update Country")
    public void updateCountry(String country) throws IOException {
        driver.findElement(ClientElements.clientCountry).clear();
        driver.findElement(ClientElements.clientCountry).sendKeys(country);
        writer.write(country + "\n");
    }

    @Step("Update County")
    public void updateCounty(String county) throws IOException {
        driver.findElement(ClientElements.clientCounty).clear();
        driver.findElement(ClientElements.clientCounty).sendKeys(county);
        writer.write(county + "\n");
    }

    @Step("Update Profile")
    public void updateProfile() throws IOException {
        this.writer.flush();
        this.writer.close();
        driver.findElement(ClientElements.submitButton).click();
    }

    @Step("Get Alert Message")
    public String getAlertMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClientElements.alert));
        return driver.findElement(ClientElements.alert).getText();
    }

    @Step
    public void confirmUpdate() {
        this.readFile("ClientProfile.txt");
        driver.navigate().to("https://client-dev.fitcrowd.net/clientProfile");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClientElements.clientFirstName));
        Assert.assertEquals(driver.findElement(ClientElements.clientFirstName).getAttribute("value"), this.data.get(0));
        Assert.assertEquals(driver.findElement(ClientElements.clientLastName).getAttribute("value"), this.data.get(1));
        Assert.assertEquals(driver.findElement(ClientElements.clientPhoneNumber).getAttribute("value"), this.data.get(2));
        Assert.assertEquals(driver.findElement(ClientElements.clientProfileEmail).getAttribute("value"), this.data.get(3));
        Assert.assertEquals(driver.findElement(ClientElements.clientStreetName).getAttribute("value"), this.data.get(4));
        Assert.assertEquals(driver.findElement(ClientElements.clientStreetNumber).getAttribute("value"), this.data.get(5));
        Assert.assertEquals(driver.findElement(ClientElements.clientCity).getAttribute("value"), this.data.get(6));
        Assert.assertEquals(driver.findElement(ClientElements.clientCountry).getAttribute("value"), this.data.get(7));
        Assert.assertEquals(driver.findElement(ClientElements.clientCounty).getAttribute("value"), this.data.get(8));
    }
}
