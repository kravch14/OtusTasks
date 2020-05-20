import config.ServerConfig;
import factory.WebDriverFactory;
import listeners.ExecutionListener;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(ExecutionListener.class)
public class TestHomeTask {

    public static final String BROWSER_CHROME = "chrome";
    public static final String CREATE_DRIVER_MESSAGE = " драйвер поднят";
    public static final String OPEN_PAGE_IN_BROWSER_MESSAGE = "Открыта страница в браузере";
    public static final String BROWSER_CLOSED_MESSAGE = "Браузер закрыт";
    protected static WebDriver wd;
    private static final Logger logger = LogManager.getLogger(TestHomeTask.class);
    private String browser;
    private String option;
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @BeforeTest
    public void setUpDriver() {

        browser = System.getProperty("browser", System.getenv("browser"));
        if (browser == null) {
            browser = BROWSER_CHROME;
        }
        browser = browser.toUpperCase();

        option = System.getProperty("options", System.getenv("options"));
        if (option == null) {
            wd = WebDriverFactory.createNewDriver(browser);
        } else {
            wd = WebDriverFactory.createNewDriver(browser, option);
        }
        logger.info(browser + CREATE_DRIVER_MESSAGE);
        wd.manage().window().maximize();
        logger.info("Размер страницы на весь экран установлен");
    }

    /*@Test
    public void openPageInBrowser() {
        wd.get(cfg.url1());
        logger.info(OPEN_PAGE_IN_BROWSER_MESSAGE);
        /*wd.manage().addCookie(new Cookie("auth_token", "w01Pw5RHXt-vY0IiA97_0Q"));
        wd.manage().addCookie(new Cookie("auth_token_expires", "1589230847"));
        wd.manage().addCookie(new Cookie("carrotquest_session_started", "1"));
    }*/
public WebElement visible(WebDriver driver, String xPath) {
    return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
}

    @Test
    public void openYandexMarketPage() {
        wd.get(cfg.url2());
        logger.info("Открыта страница Яндекс Маркет");
        WebDriverWait waitAllCategories = new WebDriverWait(wd, 30);

        ((JavascriptExecutor) wd).executeScript("arguments[0].remove();", visible(wd, "//div[contains(@data-bem, 'market-searchFeature-onboarding')]"));
        /*waitAllCategories.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='PXL2nleaah']")));

            try {
            WebElement pp = (new WebDriverWait(wd, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='popup2__content']"))));
            while (pp.isDisplayed() && pp.isEnabled()) {
                if (!(pp.isEnabled() && pp.isDisplayed())) {
                    break;
                }
            }
        } catch (NoSuchElementException e) {
                System.out.println(e);
        }
        WebElement electronics = wd.findElement(By.cssSelector("a._3Lwc_UVFq4[href*=elektronika] > span"));
        electronics.click();
        WebElement mobilePhoneLink = wd.findElement(By.cssSelector("a[href*=catalog--mobilnye-telefony]"));
        mobilePhoneLink.click();
        //logger.info("Открыт раздел Все категории");*/
    }

    /*@AfterTest
    public void setDown() {
        if (wd != null) {
            wd.quit();
            logger.info(BROWSER_CLOSED_MESSAGE);
        }
    }*/
}
