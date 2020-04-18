import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExecutionListener.class)
public class TestHomeTask {

    public static final String BROWSER_CHROME = "chrome";
    public static final String BROWSER_FIREFOX = "firefox";
    public static final String CREATE_DRIVER_MESSAGE = " драйвер поднят";
    public static final String CREATE_DRIVER_MESSAGE_DEFAULT = "chrome драйвер поднят";
    public static final String OPEN_PAGE_IN_BROWSER_MESSAGE = "Открыта страница в браузере";
    public static final String BROWSER_CLOSED_MESSAGE = "Браузер закрыт";
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(TestHomeTask.class);
    private String browser;
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @BeforeTest
    public void setUpDriver() {
        browser = System.getProperty("browser", System.getenv("browser"));
        if (browser == null) {
            browser = BROWSER_CHROME;
        }
        browser = browser.toLowerCase();

        switch (browser) {
            case BROWSER_FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                logger.info(browser + CREATE_DRIVER_MESSAGE);
                break;
            }
            default: {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                logger.info(CREATE_DRIVER_MESSAGE_DEFAULT);
                break;
            }
        }
    }

    @Test
    public void openPageInBrowser() {
        driver.get(cfg.url());
        logger.info(OPEN_PAGE_IN_BROWSER_MESSAGE);
    }

    @AfterTest
    public void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info(BROWSER_CLOSED_MESSAGE);
        }
    }
}
