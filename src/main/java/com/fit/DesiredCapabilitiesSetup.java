package com.fit;
import org.openqa.selenium.remote.DesiredCapabilities;
public class DesiredCapabilitiesSetup {
    private DesiredCapabilities capabilities;

    public DesiredCapabilitiesSetup(){
        this.capabilities = new DesiredCapabilities();
    }

    public DesiredCapabilities setCapabilities(){
        this.capabilities.setCapability("browserName", "chrome");
        this.capabilities.setCapability("platform", "ANY");
        this.capabilities.setCapability("javascriptEnable", "true");

        System.getProperty("resourcePath", System.getProperty("user.dir") + "/src/main/resources/");


        return this.capabilities;
    }
}
