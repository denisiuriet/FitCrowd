package com.fit.admin;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesSetup {
    private DesiredCapabilities capabilities;
    private ChromeOptions chromeOptions;

    public DesiredCapabilitiesSetup() {
        this.capabilities = new DesiredCapabilities();
        this.chromeOptions = new ChromeOptions();
    }

    public DesiredCapabilities setCapabilities() {
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("headless");
        this.capabilities.setCapability("browserName", "chrome");
        this.capabilities.setCapability("platform", "ANY");
        this.capabilities.setCapability("javascriptEnable", "true");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        System.getProperty("resourcePath", System.getProperty("user.dir") + "/src/main/resources/");


        return this.capabilities;
    }
}
