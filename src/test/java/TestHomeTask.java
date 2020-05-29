import config.ServerConfig;
import listeners.ExecutionListener;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static factory.WebDriverFactory.createNewDriver;


//@Listeners(ExecutionListener.class)
public class TestHomeTask {

    public static final String CREATE_DRIVER_MESSAGE = "Драйвер поднят";
    public static final String OPEN_PAGE_IN_BROWSER_MESSAGE = "Открыта страница в браузере";
    public static final String BROWSER_CLOSED_MESSAGE = "Браузер закрыт";
    protected WebDriver wd;
    private static final Logger logger = LogManager.getLogger(TestHomeTask.class);
    private String browser;
    private String option;
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @BeforeTest
    public void setUpDriver() {
        wd = createNewDriver();
        logger.info(CREATE_DRIVER_MESSAGE);
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
