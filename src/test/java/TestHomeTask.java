import config.ServerConfig;
import enums.BrowserName;
import factory.WebDriverFactory;
import listeners.ExecutionListener;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExecutionListener.class)
public class TestHomeTask {

    public static final String BROWSER_CHROME = "chrome";
    public static final String CREATE_DRIVER_MESSAGE = " драйвер поднят";
    public static final String OPEN_PAGE_IN_BROWSER_MESSAGE = "Открыта страница в браузере";
    public static final String BROWSER_CLOSED_MESSAGE = "Браузер закрыт";
    protected static WebDriver wd;
    private static final Logger logger = LogManager.getLogger(TestHomeTask.class);
    private String browser;
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @BeforeTest
    public void setUpDriver() {
        browser = System.getProperty("browser", System.getenv("browser"));
        if (browser == null) {
            browser = BROWSER_CHROME;
        }
        browser = browser.toUpperCase();
        BrowserName browserName = BrowserName.getBrowserName(browser);
        wd = WebDriverFactory.createNewDriver(browserName);
        logger.info(browser + CREATE_DRIVER_MESSAGE);
    }

    @Test
    public void openPageInBrowser() {
        wd.get(cfg.url());
        logger.info(OPEN_PAGE_IN_BROWSER_MESSAGE);
    }

    @AfterTest
    public void setDown() {
        if (wd != null) {
            wd.quit();
            logger.info(BROWSER_CLOSED_MESSAGE);
        }
    }
}
