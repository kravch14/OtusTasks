package factory;

import enums.BrowserName;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    public static WebDriver createNewDriver(String browser) {
        return createNewDriver(browser, new MutableCapabilities());
    }

    public static WebDriver createNewDriver(String browser, Capabilities options) {

        if (browser.equals(BrowserName.FIREFOX.toString())) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver(new FirefoxOptions().merge(options));
        } else if (browser.equals(BrowserName.CHROME.toString())) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(new ChromeOptions().merge(options));
        } else
            throw new IllegalArgumentException("Unknown browser name");
    }
}

