package factory;
import enums.BrowserName;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    private static Instance instance;

    public static WebDriver createNewDriver(BrowserName browserName) {

        switch(browserName) {
            case CHROME:
                instance = new ChromeInstance();
                break;
            case FIREFOX:
                instance = new FirefoxInstance();
                break;
            default:
                throw new IllegalArgumentException("Unknown browser name");
        }

        return instance.createDriver();
    }
}

