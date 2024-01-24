package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.basePage.Base;
import pageObject.pages.FrontendPage;

public class CertificatePageTest extends Base {

    @Test
    public void generateSchoolLeavingCertificate() {
        FrontendPage.dashBoardPage.closePopUp();
        FrontendPage.dashBoardPage.hoverDashBoardLink();
        FrontendPage.dashBoardPage.expandAdministration();
        FrontendPage.dashBoardPage.clickCertificateLink();
        String certificateLink = FrontendPage.dashBoardPage.getCurrentPageUrl();
        FrontendPage.certificatePage.clickschoolLeavingCertificate();
        FrontendPage.detailsPage.waitForLoaderClass();
        FrontendPage.certificatePage.clickOnGenerateButton();
        FrontendPage.detailsPage.waitForLoaderClass();
        FrontendPage.documentPage.clickOnStudentCheckbox();
        String expectedName = FrontendPage.documentPage.getStudentName();
        FrontendPage.documentPage.clickOnGenerateButton();
        FrontendPage.detailsPage.waitForLoaderClass();
        FrontendPage.detailsPage.fillInformation();
        FrontendPage.detailsPage.clickOnGenerateButton();
        FrontendPage.detailsPage.waitForLoaderClass();
        String currentWindowHandle = FrontendPage.detailsPage.getCurrentWindowHandle();
        FrontendPage.detailsPage.clickOnDownloadButton();
        FrontendPage.detailsPage.switchToParticularWindow(currentWindowHandle);
        FrontendPage.detailsPage.goToPage(certificateLink);
        FrontendPage.certificatePage.viewAllHistory();
        FrontendPage.certificatePage.waitForLoaderClass();
        String actualName = FrontendPage.historyPage.getstudentName();
        Assert.assertEquals(actualName, expectedName);
    }
}
