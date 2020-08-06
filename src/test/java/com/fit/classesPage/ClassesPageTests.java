package com.fit.classesPage;

import com.fit.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClassesPageTests {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private ClassesPage classesPage;

    @BeforeClass
    public void driverSetup(){
        driver = SingletonDriver.getInstance();
        wait = new WebDriverWait(driver, 30);
        classesPage = new ClassesPage(driver, wait);
    }

    @BeforeMethod
    public void setDriver(){
        driver.navigate().to("https://admin-dev.fitcrowd.net/classes");
       // driver.manage().deleteAllCookies();
        //driver.navigate().to("https://admin-dev.fitcrowd.net/classes");
    }

    @Test
    public void addImage() throws InterruptedException {
        classesPage.checkPage();
        classesPage.addImage();
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
