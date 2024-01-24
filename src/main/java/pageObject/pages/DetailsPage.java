package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObject.basePage.Base;

public class DetailsPage extends Base {
    private static final String  lastNameTextBox = "input[placeHolder= 'Last Name']";
    private static final String  remarksTextBox = "input[placeHolder= 'Remarks']";
    private static final String  generateButton = "//div[text()= 'Generate']";
    private static final String  downloadButton = "download";

    private void enterLastName() {
        findElement(driver,By.cssSelector(lastNameTextBox)).sendKeys("Singh");
    }

    private void enterRemarkTextBox() {
        findElement(driver,By.cssSelector(remarksTextBox)).sendKeys("Good");
    }

    public void clickOnGenerateButton() {
        Wait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(generateButton)));
        findElement(driver,By.xpath(generateButton)).click();
    }

    public void clickOnDownloadButton() {
        findElement(driver,By.id(downloadButton)).click();
    }

    public void fillInformation() {
        enterLastName();
        enterRemarkTextBox();
    }
}
