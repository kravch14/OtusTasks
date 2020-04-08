import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.net.MalformedURLException;

public class HomeTask {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(HomeTask.class);
    private String browser;


    @Before
    public void setUpDriver() {
        browser = System.getProperty("BROWSER");
        if (browser == null) {
            browser = System.getenv("BROWSER");
            if (browser == null) {
                browser = "chrome";
            }
        }
        switch (browser) {
            case ("chrome"): {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                logger.info(browser + " драйвер поднят");
                break;
            }

            case ("firefox"): {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                logger.info(browser + " драйвер поднят");
                break;
            }
            default: {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                logger.info("chrome драйвер поднят");
                break;
            }
        }
    }

    @Test
    public void openPageInBrowser() {
        driver.get("https://otus.ru/");
        if (!browser.equals("chrome") && !browser.equals("firefox"))
            logger.info("Открыта страница в браузере chrome");
        else
            logger.info("Открыта страница в браузере " + browser);
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
