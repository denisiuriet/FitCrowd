package com.fit.classesPage;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import resource.Elements;
import resource.Utility;
import ru.yandex.qatools.allure.annotations.Step;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.EventListener;

public class ClassesPage {
    private RemoteWebDriver driver;
    private WebDriverWait wait;

    public ClassesPage(RemoteWebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Check Page")
    public boolean checkPage() {
        if (driver.getCurrentUrl().equals("https://admin-dev.fitcrowd.net/classes")) {
            Utility.takeScreenshot(driver);
            return true;
        } else {
            Utility.takeScreenshot(driver);
            return false;
        }
    }

    @Step("Add image to class")
    public void addImage() throws AWTException {
        driver.findElement(Elements.createButton).click();

        //Switch to create frame
        driver.switchTo().activeElement();


        //Click to open File Upload box
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(Elements.createImg)).click().perform();


        //Copy path to clipboard
        StringSelection ss = new StringSelection("C:\\Users\\iurie\\Desktop\\Procyon_lotor_(raccoon).jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //Robot for commands CTRL + V, Enter
        Robot robot = new Robot();

        robot.setAutoDelay(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.setAutoDelay(2000);

        Utility.takeScreenshot(driver);
    }

    @Step("Click on class type")
    public void clickOnClassType(){
        driver.findElement(Elements.classType).click();
    }

    @Step("Set Class Type")
    public void setClassType(int index) { ;
        driver.findElement(Elements.virtualOption).click();
        Utility.takeScreenshot(driver);
    }

    @Step("Set Class Name")
    public void setClassName(String className) {
        driver.findElement(Elements.className).sendKeys(className);
        Utility.takeScreenshot(driver);
    }

    @Step("Click Class Location")
    public void clickClassLocation() {
        driver.findElement(Elements.classLocation).click();
    }

    @Step("Set Class Location")
    public void setClassLocation(){
        driver.findElement(Elements.locationOption).click();
    }

    @Step("Set Open Registration")
    public void setOpenRegistration(String openRegistration) {
        driver.findElement(Elements.openRegistration).sendKeys(openRegistration);
        Utility.takeScreenshot(driver);
    }

    @Step("Set Close Registration")
    public void setCloseRegistration(String closeRegistration){
        driver.findElement(Elements.closeRegistration).clear();
        driver.findElement(Elements.closeRegistration).sendKeys(closeRegistration);
        Utility.takeScreenshot(driver);
    }

    @Step("Set Participants")
    public void setParticipants(String participantsNo){
        driver.findElement(Elements.classParticipants).sendKeys(participantsNo);
        Utility.takeScreenshot(driver);
    }

    @Step("Set duration")
    public void setDuration(String duration){
        driver.findElement(Elements.classDuration).sendKeys(duration);
        Utility.takeScreenshot(driver);
    }

    @Step("Click on next month")
    public void clickNextMonth(){
        driver.findElement(Elements.nextMonth).click();
    }

    @Step("Get current date")
    public String getCurrentDate(){
        return driver.findElement(Elements.currentDate).getText();
    }

    @Step("Click on beginning date")
    public void clickBeginningDate(){
        driver.findElement(Elements.currentDate).click();
    }

    @Step("Set class description")
    public void setDescription(String description){
        driver.findElement(Elements.classDescription).sendKeys(description);
        Utility.takeScreenshot(driver);
    }

    @Step("Set class time")
    public void setTime(String time){
        driver.findElement(Elements.classTime).sendKeys(time);
        Utility.takeScreenshot(driver);
    }

    @Step("Set day of class")
    public void setDayOfClass(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.dayOfClass));
        driver.findElement(Elements.dayOfClass).click();
        Utility.takeScreenshot(driver);
    }
}
