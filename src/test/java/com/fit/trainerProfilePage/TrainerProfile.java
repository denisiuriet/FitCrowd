package com.fit.trainerProfilePage;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import resource.Elements;
import resource.Utility;
import ru.yandex.qatools.allure.annotations.Step;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class TrainerProfile {
    private RemoteWebDriver driver;
    private WebDriverWait wait;

    public TrainerProfile(RemoteWebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Check Page")
    public void checkPage(){
        Utility.checkPage(driver, "https://admin-dev.fitcrowd.net/trainerProfile");
    }

    @Step("Add Trainer Image")
    public void addTrainerImage() throws AWTException {
    //Click to open File Upload box
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(Elements.trainerImage)).click().perform();


        //Copy path to clipboard
        StringSelection ss = new StringSelection("C:\\Users\\iurie\\Desktop\\Procyon_lotor_(raccoon).jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //Robot for commands CTRL + V, Enter
        Robot robot = new Robot();

        robot.setAutoDelay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.setAutoDelay(1000);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.setAutoDelay(1000);

        Utility.takeScreenshot(driver);
    }

    @Step("Update First Name")
    public void updateFirstName(String firstName){
        driver.findElement(Elements.trainerFirstName).clear();
        driver.findElement(Elements.trainerFirstName).sendKeys(firstName);
    }

    @Step("Update Last Name")
    public void updateLastName(String lastName){
        driver.findElement(Elements.trainerLastName).clear();
        driver.findElement(Elements.trainerLastName).sendKeys(lastName);
    }

    @Step("Update Phone No.")
    public void updatePhoneNo(String phoneNo){
        driver.findElement(Elements.trainerPhoneNo).clear();
        driver.findElement(Elements.trainerPhoneNo).sendKeys(phoneNo);
    }

    @Step("Update Country")
    public void updateCountry(String country){
        driver.findElement(Elements.trainerCountry).clear();
        driver.findElement(Elements.trainerCountry).sendKeys(country);
    }

    @Step("Update County")
    public void updateCounty(String county){
        driver.findElement(Elements.trainerCounty).clear();
        driver.findElement(Elements.trainerCounty).sendKeys(county);
    }

    @Step("Update City")
    public void updateCity(String city){
        driver.findElement(Elements.trainerCity).clear();
        driver.findElement(Elements.trainerCity).sendKeys(city);
    }

    @Step("Update Street Name")
    public void updateStreetName(String streetName){
        driver.findElement(Elements.trainerStreetName).clear();
        driver.findElement(Elements.trainerStreetName).sendKeys(streetName);
    }

    @Step("Update Street No.")
    public void updateStreetNo(String streetNo){
        driver.findElement(Elements.trainerStreetNo).clear();
        driver.findElement(Elements.trainerStreetNo).sendKeys(streetNo);
    }

    @Step("Update Description")
    public void updateDescription(String description){
        driver.findElement(Elements.trainerDescription).clear();
        driver.findElement(Elements.trainerDescription).sendKeys(description);
    }

    @Step("Insert Accreditation")
    public void insertAccreditation(String accreditation){
        driver.findElement(Elements.trainerAccreditation).clear();
        driver.findElement(Elements.trainerAccreditation).sendKeys(accreditation);
    }

    @Step("Add Accreditation")
    public void addAccreditation(){
        driver.findElement(Elements.addAccreditation).click();
    }

    @Step("Update Trainer Profile")
    public void updateTrainerProfile(){
        driver.findElement(Elements.updateTrainerProfile).click();
    }

    @Step("Change Password")
    public void changePassword(){
        driver.findElement(Elements.changePassword).click();
    }

    @Step("Set current password")
    public void setCurrentPassword(String currentPassword){
        driver.findElement(Elements.currentPassword).sendKeys(currentPassword);
    }

    @Step("Set new password")
    public void setNewPassword(String newPassword){
        driver.findElement(Elements.newPassword).sendKeys(newPassword);
    }

    @Step("Set confirm new passwod")
    public void confirmNewPassword(String confirmNewPassword){
        driver.findElement(Elements.confirmNewPassword).sendKeys(confirmNewPassword);
    }

    @Step("Confirm change password")
    public void confirmChangePassword(){
        driver.findElement(Elements.changePasswordConfirm).click();
    }
}
