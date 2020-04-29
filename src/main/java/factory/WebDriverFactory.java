package factory;

import enums.BrowserName;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    public static WebDriver createNewDriver(String browser) {

        if (browser.equals(BrowserName.FIREFOX.name())) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browser.equals(BrowserName.CHROME.name())) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else
            throw new IllegalArgumentException("Unknown browser name");
    }

    public static WebDriver createNewDriver(String browser, String options) {

        if (browser.equals(BrowserName.FIREFOX.name())) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments(options);
            return new FirefoxDriver(firefoxOptions);

        } else if (browser.equals(BrowserName.CHROME.name())) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(options);
            return new ChromeDriver(chromeOptions);
        } else
            throw new IllegalArgumentException("Unknown browser name");
    }
}

