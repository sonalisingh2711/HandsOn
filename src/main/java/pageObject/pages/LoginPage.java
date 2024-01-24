package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObject.basePage.Base;

import java.util.List;

public class LoginPage extends Base {
    private static final String otpButtonId = "send-otp-btn-id";
    private static final String otpField = "//input[@data-group-idx]";
    private static final String  submitOtpButton = "submit-otp-btn-id";
    private static final String  accountNameText = "//div[@class='profile-user-name']/..//div[text()='%s']";
    private static final String  dashboard = "//a[text()='Dashboard']";
    private static final String  skipText = "//span[contains(text(),'Skip for now')]";

    private void sendPhoneNumberText(String phoneNumber) {
        String phoneNumberText = "user-input";
        Wait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(phoneNumberText)));
        findElement(driver,By.id(phoneNumberText)).sendKeys(phoneNumber);
    }

    private void clickOtpButton() {
        findElement(driver,By.id(otpButtonId)).click();
    }

    private void enterOtp(String otp) {
        Wait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(otpField)));
        List<WebElement> otpFields = findElements(driver,By.xpath(otpField));
        for (int i = 0; i < otp.length(); i++) {
            otpFields.get(i).sendKeys(String.valueOf(otp.charAt(i)));
        }
    }

    private void submitOtp() {
        findElement(driver,By.id(submitOtpButton)).click();
    }

    private void clickOnAccountName(String accountName) {
        WebElement accountNameElement = findElement(driver,By.xpath(String.format(accountNameText, accountName)));
        accountNameElement.click();
    }

    private void waitFordashboard() {
        Wait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(dashboard)));
    }

    private void skipForNow() {
        Wait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(skipText)));
        findElement(driver,By.xpath(skipText)).click();
    }

    public void login(String phoneNumber, String otp, String accountName) {
        waitForLoaderClass();
        sendPhoneNumberText(phoneNumber);
        clickOtpButton();
        enterOtp(otp);
        submitOtp();
        skipForNow();
        waitForLoaderClass();
        clickOnAccountName(accountName);
        waitFordashboard();
    }
}
