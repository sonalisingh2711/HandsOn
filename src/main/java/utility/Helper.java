package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Helper {
    protected static WebDriver driver;
    protected static Logger logger = LogManager.getLogger(Helper.class);
    protected static WebElement element;
    public static List<WebElement> listOfElements;

    public static void getWebDriverInstance() {
        try {
            logger.info("-------Browser Opened--------");
            WebDriverManager.chromedriver().setup();
            // Create a new instance of ChromeDriver
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } catch (Exception e) {
            logger.error("Failed to open Browser" + e);
        }

    }

    public void switchToParticularWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    public String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    public void goToPage(String url) {
        driver.get(url);
    }

    public WebDriverWait Wait() {
        return new WebDriverWait(driver, Duration.ofSeconds(120));
    }

    public static WebElement findElement(WebDriver driver, final By locator) {
        logger.info("Using  findElement to locate:" + locator);
        try {
            return driver.findElement(locator);
        } catch (Exception e) {
            logger.error("Failed to use findElement to locate: " + locator + " WITH ERROR: " + e);
            return element;
        }
    }

    public static List<WebElement> findElements(WebDriver driver, final By locator) {
        logger.info("Using  findElement to locate:" + locator);
        try {
            return driver.findElements(locator);
        } catch (Exception e) {
            logger.error("Failed to use findElement to locate: " + locator + " WITH ERROR: " + e);
            return listOfElements;
        }
    }
}