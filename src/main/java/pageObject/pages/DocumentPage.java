package pageObject.pages;

import org.openqa.selenium.By;
import pageObject.basePage.Base;

public class DocumentPage extends Base {
    private static final String  checkbox = "div:nth-child(1)  tbody > tr>td";
    private static final String  generateButton = "//div[text()='Generate']";
    private static final String  studentname = "div.UserDetailsRow_userProfile__2FoAI p.krayon__Para-module__VmUAA";

    public void clickOnStudentCheckbox() {
        findElement(driver,By.cssSelector(checkbox)).click();
    }

    public void clickOnGenerateButton() {
        driver.findElement(By.xpath(generateButton)).click();
    }
    public String getStudentName()
    {
        return driver.findElement(By.cssSelector(studentname)).getText();
    }
}
