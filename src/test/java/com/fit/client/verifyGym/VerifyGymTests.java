package com.fit.client.verifyGym;

import com.fit.admin.SingletonDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resource.ClientElements;

public class VerifyGymTests {
    private RemoteWebDriver driver;
    private VerifyGymPage verifyGymPage;

    @BeforeClass
    public void driverSetup(){
        driver = SingletonDriver.getInstance();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        verifyGymPage = new VerifyGymPage(driver, wait);
    }

    @BeforeMethod
    public void setDriver(){
        driver.navigate().to("https://client-dev.fitcrowd.net/gymVerify");
    }

    @Test
    public void missingGymCode(){
        verifyGymPage.checkPage();
        verifyGymPage.failedLogin();
        Assert.assertEquals(verifyGymPage.getMissingGymCodeError(), ClientElements.missingCredentialMessage);
    }

    @Test
    public void invalidGymCode(){
        verifyGymPage.checkPage();
        verifyGymPage.setGymCode("TestGymCode");
        verifyGymPage.failedLogin();
        Assert.assertEquals(verifyGymPage.getInvalidGymCodeError(), ClientElements.errorMessage);
    }

    @Test
    public void validGymCode(){
        verifyGymPage.checkPage();
        verifyGymPage.setGymCode("18GYM");
        verifyGymPage.successfulLogin();
    }
}
