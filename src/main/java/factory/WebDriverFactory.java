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
                return new ChromeDriver(new ChromeOptions() {{
                    addArguments(getProp("options").orElse("").split(";"));
                }});
            case "ff":
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(new FirefoxOptions() {{
                    addArguments(getProp("options").orElse("").split(";"));
                }});
            case "default":
            default:
                return new ChromeDriver();
        }
    }
}
