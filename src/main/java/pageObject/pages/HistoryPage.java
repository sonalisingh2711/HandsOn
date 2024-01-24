package pageObject.pages;

import org.openqa.selenium.By;
import pageObject.basePage.Base;

public class HistoryPage extends Base {
    private static final String  studentName = "tr div.UserDetailsRow_userProfile__2FoAI div p.krayon__Para-module__VmUAA";

    public String  getstudentName()
    {
        return findElement(driver,By.cssSelector(studentName)).getText();
    }
}
