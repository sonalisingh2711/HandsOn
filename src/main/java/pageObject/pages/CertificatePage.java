package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObject.basePage.Base;

public class CertificatePage extends Base {
    private static final String schoolLeavingCertificate = "//div//h6[text()='School leaving certificate']";
    private static final String generateButton = "button[body='Generate']";
    private static final String historyViewAll = "//div//h6[text()='Recently generated certificates and documents']//following-sibling::span";

    public void clickschoolLeavingCertificate() {
        Wait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(schoolLeavingCertificate)));
        findElement(driver,By.xpath(schoolLeavingCertificate)).click();
    }

    public void clickOnGenerateButton() {
        findElement(driver,By.cssSelector(generateButton)).click();
    }

    public void viewAllHistory() {
        Wait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(historyViewAll)));
        findElement(driver,By.xpath(historyViewAll)).click();
    }
}
