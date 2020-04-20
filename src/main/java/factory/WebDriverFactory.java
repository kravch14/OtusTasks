package factory;

import enums.BrowserName;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    private static Instance instance;

    public static WebDriver createNewDriver(String browser) throws Exception {

        if (browser.equals(BrowserName.FIREFOX.toString())) {
            instance = new FirefoxInstance();
        } else if (browser.equals(BrowserName.CHROME.toString())) {
            instance = new ChromeInstance();
        } else
            throw new Exception("Unknown browser name");

        return instance.createDriver();
    }
}
