package pageObject.basePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObject.pages.FrontendPage;
import utility.Environment;
import utility.Helper;

import java.util.Set;

public class Base extends Helper {
    private static final String loaderSelector = ".loader";
    private static final String loaderClass = "loader";

    @BeforeMethod(alwaysRun = true)
    public static void login() {
        getWebDriverInstance();
        driver.get(Environment.getValue("UI","URL"));
        FrontendPage.loginpage.login(Environment.getValue("UI","PHONENUMBER"), Environment.getValue("UI","OTP"), Environment.getValue("UI","ACCOUNTNAME"));
    }

    public void waitForLoaderClass() {
        Wait().until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loaderSelector)));
        Wait().until(ExpectedConditions.invisibilityOfElementLocated(By.className(loaderClass)));
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
        logger.info("-----Closed the Browser---------");
    }

    public static Set<String> getWindowHandles(WebDriver driver) {
        return driver.getWindowHandles();
    }


}

