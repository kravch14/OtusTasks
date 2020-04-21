package factory;

import enums.BrowserName;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    public static WebDriver createNewDriver(String browser) {

        Instance instance;
        if (browser.equals(BrowserName.FIREFOX.toString())) {
            instance = new FirefoxInstance();
        } else if (browser.equals(BrowserName.CHROME.toString())) {
            instance = new ChromeInstance();
        } else
            throw new IllegalArgumentException("Unknown browser name");

        return instance.createDriver();
    }
}

