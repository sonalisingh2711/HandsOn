package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pageObject.basePage.Base;
import org.openqa.selenium.WebElement;

public class DashBoardPage extends Base {

    private static final String dashboardLink = "a.Sidebar_sidebarLink__39rXm";
    private static final String administrationDropdown = "//div[text()='Administration']";
    private static final String certificateLink = "//a[text()='Certificates']";

    public void hoverDashBoardLink() {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.cssSelector(dashboardLink));
        actions.moveToElement(element).perform();
    }

    public void expandAdministration() {findElement(driver,By.xpath(administrationDropdown)).click();
    }

    public void clickCertificateLink() {
        findElement(driver,By.xpath(certificateLink)).click();
    }

    public void closePopUp() {
        Actions actions = new Actions(driver);
        WebElement nonPopupElement = findElement(driver,By.cssSelector(dashboardLink));
        actions.moveToElement(nonPopupElement).click().perform();
    }
}
