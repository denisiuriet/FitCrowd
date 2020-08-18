package com.fit.admin;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class SingletonDriver {

    private static RemoteWebDriver instance;

    static {
        try {
            DesiredCapabilitiesSetup capabilities = new DesiredCapabilitiesSetup();
            instance = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), capabilities.setCapabilities());
        } catch (MalformedURLException ex) {
            ex.printStackTrace();

            System.out.println("The driver could not be create");
        }
    }

    public static RemoteWebDriver getInstance() {
        return instance;
    }
}
