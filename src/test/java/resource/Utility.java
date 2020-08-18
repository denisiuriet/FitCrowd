package resource;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

public class Utility {

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot(RemoteWebDriver driver){
        return driver.getScreenshotAs(OutputType.BYTES);
    }

    public static boolean checkPage(RemoteWebDriver driver, String url) {
        if (driver.getCurrentUrl().equals(url)) {
            Utility.takeScreenshot(driver);
            return true;
        } else {
            Utility.takeScreenshot(driver);
            return false;
        }
    }
}
