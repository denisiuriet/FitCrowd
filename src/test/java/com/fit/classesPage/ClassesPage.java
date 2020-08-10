package com.fit.classesPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resource.Elements;
import resource.Utility;
import ru.yandex.qatools.allure.annotations.Step;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ClassesPage {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private WebElement element;
    private File file;
    private FileWriter writer;

    public ClassesPage(RemoteWebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        file = new File("ClassData.txt");
    }

    @Step
    public void setFile() throws IOException {
        file.createNewFile();
        writer = new FileWriter(file);
    }

    @Step("Check Page")
    public boolean checkPage() {
        return Utility.checkPage(driver, "https://admin-dev.fitcrowd.net/classes");
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
    public void clickOnClassType() {
        driver.findElement(Elements.classType).click();
    }

    @Step("Set Class Type")
    public void setClassType() throws IOException {
        driver.findElement(Elements.virtualOption).click();
        writer.write("VIRTUAL" + "\n");
        Utility.takeScreenshot(driver);
    }

    @Step("Set Class Name")
    public void setClassName(String className) throws IOException {
        driver.findElement(Elements.className).sendKeys(className);
        writer.write(driver.findElement(Elements.className).getAttribute("value") + "\n");
        Utility.takeScreenshot(driver);
    }

    @Step("Click Class Location")
    public void clickClassLocation() {
        driver.findElement(Elements.classLocation).click();
    }

    @Step("Set Class Location")
    public void setClassLocation() throws IOException {
        driver.findElement(Elements.locationOption).click();
        writer.write(driver.findElement(Elements.locationName).getText() + "\n");
    }

    @Step("Set Open Registration")
    public void setOpenRegistration(String openRegistration) throws IOException {
        driver.findElement(Elements.openRegistration).sendKeys(openRegistration);
        writer.write(driver.findElement(Elements.openRegistration).getAttribute("value") + "\n");
        Utility.takeScreenshot(driver);
    }

    @Step("Set Close Registration")
    public void setCloseRegistration(String closeRegistration) throws IOException {
        driver.findElement(Elements.closeRegistration).clear();
        driver.findElement(Elements.closeRegistration).sendKeys(closeRegistration);
        writer.write(driver.findElement(Elements.closeRegistration).getAttribute("value") + "\n");
        Utility.takeScreenshot(driver);
    }

    @Step("Set Participants")
    public void setParticipants(String participantsNo) throws IOException {
        driver.findElement(Elements.classParticipants).sendKeys(participantsNo);
        writer.write(driver.findElement(Elements.classParticipants).getAttribute("value") + "\n");
        Utility.takeScreenshot(driver);
    }

    @Step("Set duration")
    public void setDuration(String duration) throws IOException {
        driver.findElement(Elements.classDuration).sendKeys(duration);
        writer.write(driver.findElement(Elements.classDuration).getAttribute("value") + "\n");
        Utility.takeScreenshot(driver);
    }

    @Step("Click on next month")
    public void clickNextMonth() {
        driver.findElement(Elements.nextMonth).click();
    }

    @Step("Get current date")
    public String getCurrentDate() {
        return driver.findElement(Elements.currentDate).getText();
    }

    @Step("Click on beginning date")
    public void clickBeginningDate() {
        driver.findElement(Elements.currentDate).click();
    }


    @Step("Set day of class")
    public void setDayOfClass() throws IOException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.dayOfClass));
        driver.findElement(Elements.dayOfClass).click();
        writer.write(driver.findElement(Elements.currentDate).getAttribute("value") + "\n");
        Utility.takeScreenshot(driver);
    }

    @Step("Set class time")
    public void setTime(String time) throws IOException {
        driver.findElement(Elements.classTime).sendKeys(time);
        writer.write(driver.findElement(Elements.classTime).getAttribute("title") + "\n");
        //driver.findElement(Elements.classTime).sendKeys(Keys.ARROW_LEFT);
        //driver.findElement(Elements.classTime).sendKeys(time);

        Utility.takeScreenshot(driver);
    }

    @Step("Set class description")
    public void setDescription(String description) throws IOException {
        driver.findElement(Elements.classDescription).sendKeys(description);
        writer.write(driver.findElement(Elements.classDescription).getText() + "\n");
        Utility.takeScreenshot(driver);
    }

    @Step("Create class")
    public void createClass() {
        driver.findElement(Elements.createClassButton).click();
    }

    @Step("Close file")
    public void closeFile() throws IOException {
        writer.flush();
        writer.close();
    }
}
