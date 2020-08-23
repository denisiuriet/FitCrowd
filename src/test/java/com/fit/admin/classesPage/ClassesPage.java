package com.fit.admin.classesPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ClassesPage {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
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

    @Step("Click create button")
    public void clickCreate() {
        driver.findElement(Elements.createButton).click();
        driver.switchTo().activeElement();
    }

    @Step("Add image")
    public void addImage() throws IOException {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(Elements.addImage)).click().perform();
        Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/main/resources/" + "ClassImageUpload.exe");
        Utility.takeScreenshot(driver);
    }


    @Step("Select Class Type")
    public void selectClassType() throws IOException {
        List<WebElement> listOfContainer = driver.findElements(Elements.classContainers);
        listOfContainer.get(0).click();
        List<WebElement> classTypes = driver.findElement(Elements.classTypesOptions).findElements(Elements.divTag);
        classTypes.get(1).click();
        writer.write(driver.findElement(Elements.classType).getText() + "\n");

    }

    @Step("Set Class Name")
    public void setClassName(String className) throws IOException {
        driver.findElement(Elements.className).sendKeys(className);
        writer.write(driver.findElement(Elements.className).getAttribute("value") + "\n");
        Utility.takeScreenshot(driver);
    }

    @Step("Set Class Location")
    public void setClassLocation() throws IOException {
        List<WebElement> listOfContainers = driver.findElements(Elements.classContainers);
        driver.findElement(Elements.locationClickableElement).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.locationMenu));
        List<WebElement> listOfOptions = listOfContainers.get(1).findElement(Elements.locationMenu).findElements(Elements.divTag);
        WebElement element = listOfOptions.get(4);
        element.click();
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

    @Step("Click on beginning date")
    public void clickBeginningDate() {
        driver.findElement(Elements.currentDate).click();
    }

    @Step("Set date")
    public void setDate(int flag) throws IOException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.tableOfDates));
        List<WebElement> listOfWeeks = driver.findElement(Elements.tableOfDates).findElement(Elements.calendar).findElements(Elements.calendarLines);

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        localDate.format(formatter);

        here:
        for (WebElement element : listOfWeeks) {
            List<WebElement> listOfDays = element.findElements(Elements.daysOfWeek);
            for (WebElement day : listOfDays) {

                if (day.getAttribute("class").equals("prev disabled") || day.getAttribute("class").equals("disabled"))
                    continue;

                int dayOfMonth = Integer.parseInt(day.getText());
                int actualDay = localDate.getDayOfMonth();
                actualDay = actualDay + flag;
                if (dayOfMonth >= actualDay) {
                    day.click();
                    break here;
                }
            }
        }
        writer.write(driver.findElement(Elements.currentDate).getAttribute("value") + "\n");

    }

    @Step("Set class time")
    public void setTime(Keys min1, Keys min2, Keys hour1, Keys hour2) throws IOException {
        driver.findElement(Elements.classTime).sendKeys(min1);
        driver.findElement(Elements.classTime).sendKeys(min2);
        driver.findElement(Elements.classTime).sendKeys(Keys.ARROW_LEFT);
        driver.findElement(Elements.classTime).sendKeys(hour1);
        driver.findElement(Elements.classTime).sendKeys(hour2);
        writer.write(driver.findElement(Elements.classTime).getAttribute("title") + "\n");

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
        driver.findElement(Elements.submitButton).click();
    }

    @Step("Close file")
    public void closeFile() throws IOException {
        writer.flush();
        writer.close();
    }

    @Step("Check if class was created")
    public void confirmClass() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.classesList));
        List<WebElement> listOfClasses = driver.findElements(Elements.classesList);
        for (WebElement element : listOfClasses) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.classDetails));
            Utility.takeScreenshot(driver);
        }


    }

    @Step("Delete class")
    public void deleteClass(String className) {
        List<WebElement> list = driver.findElement(Elements.classTable).findElements(Elements.tableElements);
        for (WebElement element : list) {
            List<WebElement> elementsOfRow = element.findElements(Elements.rowElements);
            System.out.println(elementsOfRow.get(0).getText());
            if (elementsOfRow.get(0).getText().equals(className)) {
                elementsOfRow.get(5).findElements(Elements.actionButtons).get(2).click();
            }
        }
    }

    @Step("Get Alert Message")
    public String getAlertMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.alertMessage));
        return driver.findElement(ClientElements.alert).getText();
    }

    @Step("Confirm delete")
    public void confirmDeleteClass() {
        driver.switchTo().activeElement().findElement(Elements.confirmButton).click();
        Assert.assertEquals(this.getAlertMessage(), "Class model deleted");
    }

    @Step("View Class")
    public void viewClass(String className) {
        List<WebElement> list = driver.findElement(Elements.classTable).findElements(Elements.tableElements);
        for (WebElement element : list) {
            List<WebElement> elementsOfRow = element.findElements(Elements.rowElements);
            if (elementsOfRow.get(0).getText().equals(className)) {
                elementsOfRow.get(5).findElements(Elements.actionButtons).get(0).click();
            }
        }
    }

    @Step("Close View")
    public void closeView() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.closeView));
        driver.findElement(Elements.closeView).click();
    }

    @Step("Open Edit Window")
    public void editClass(String className) throws IOException {
        file = new File("ClassData.txt");
        writer = new FileWriter(file);
        driver.navigate().to("https://admin-dev.fitcrowd.net/classes");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.classTable));
        List<WebElement> list = driver.findElement(Elements.classTable).findElements(Elements.tableElements);
        for (WebElement element : list) {
            List<WebElement> elementsOfRow = element.findElements(Elements.rowElements);
            if (elementsOfRow.get(0).getText().equals(className)) {
                elementsOfRow.get(5).findElements(Elements.actionButtons).get(1).click();
                break;
            }
        }
    }

    @Step("Clear field")
    public void clearField(By element) {
        driver.findElement(element).clear();
    }

    @Step("Edit class image")
    public void editClassImage() throws IOException {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(Elements.addImage)).click().perform();
        Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/main/resources/" + "EditImageUpload.exe");
        Utility.takeScreenshot(driver);
    }

    @Step("Edit class Name")
    public void editClassName(String className) throws IOException {
        writer.write("VIRTUAL" + "\n");
        this.clearField(Elements.className);
        this.setClassName(className);
    }

    @Step("Change location")
    public void changeLocation() throws IOException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.editClassLocation));
        driver.findElement(Elements.editClassLocation).click();
        //driver.findElement(Elements.locationOption2).click();
        writer.write(driver.findElement(Elements.locationName).getText() + "\n");
    }

    @Step("Edit Open Registration")
    public void editOpenRegistration(String openRegistration) throws IOException {
        this.clearField(Elements.openRegistration);
        this.setOpenRegistration(openRegistration);
    }

    @Step("Edit Close Registration")
    public void editCloseRegistration(String closeRegistration) throws IOException {
        this.clearField(Elements.closeRegistration);
        this.setCloseRegistration(closeRegistration);
    }

    @Step("Edit Participants No.")
    public void editParticipants(String participants) throws IOException {
        this.clearField(Elements.classParticipants);
        this.setParticipants(participants);
    }

    @Step("Edit duration")
    public void editDuration(String duration) throws IOException {
        this.clearField(Elements.classDuration);
        this.setDuration(duration);
    }

    @Step("Change date")
    public void editDate(int flag) throws IOException {
        this.clickBeginningDate();
        this.setDate(flag);
        writer.write(driver.findElement(Elements.currentDate).getAttribute("value") + "\n");
        Utility.takeScreenshot(driver);
    }

    @Step("Edit time")
    public void editTime(Keys min1, Keys min2, Keys hour1, Keys hour2) throws IOException {
        this.setTime(min1, min2, hour1, hour2);
        writer.write(driver.findElement(Elements.classTime).getAttribute("title") + "\n");

        Utility.takeScreenshot(driver);
    }

    @Step("Edit Description")
    public void editDescription(String description) throws IOException {
        this.clearField(Elements.classDescription);
        this.setDescription(description);
    }

    @Step("Edit Class")
    public void editClass() {
        this.createClass();
    }

}
