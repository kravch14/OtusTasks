package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static properties.GetProperty.getProp;


public class WebDriverFactory {

    public static WebDriver createNewDriver() {

        switch (getProp("browser").orElse("default").toLowerCase()) {
            case "chrome":
            case "google chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(getProp("options").orElse("").split(";"));
                return new ChromeDriver(chromeOptions);
            case "ff":
            case "firefox":
                //System.setProperty("webdriver.gecko.driver", "D:\\OTUS\\Geckodriver\\geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(getProp("options").orElse("").split(";"));
                //firefoxOptions.addArguments(getProp("options").orElse("").split(";"));
                //firefoxOptions.setCapability("marionette", true);
                //System.out.println("debag1");
                return new FirefoxDriver(firefoxOptions);
            case "default":
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }
}