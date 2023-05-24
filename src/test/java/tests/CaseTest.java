package tests;

import constants.ProjectName;
import data.PrepareTestCaseData;
import helpers.LoginHelper;
import modal.TestCaseModal;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CaseTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(CaseTest.class.getName());

    @Test
    public void createNewTestCaseTest() {
        LoginHelper.login(getDriver());
        AllProjectsPage allProjectsPagePage = new AllProjectsPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", AllProjectsPage.class.getName()));
        allProjectsPagePage.clickCelectedProject(ProjectName.QASE.getProjectName());
        LOGGER.info(String.format("Chose %s project", ProjectName.QASE));
        ProjectPage projectPage = new ProjectPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", ProjectPage.class.getName()));
        projectPage.clickNewCaseButton();
        NewTestCaseModalPage testCasePage = new NewTestCaseModalPage(getDriver());
        LOGGER.info(String.format("Form %s initialized", NewTestCaseModalPage.class.getName()));
        TestCaseModal testCaseModal = PrepareTestCaseData.detValidData();
        testCasePage.fillTestCaseForm(testCaseModal);
        LOGGER.info("filled suite case with following details:" + testCaseModal);
        testCasePage.clickSaveTestCaseButton();
        LOGGER.info("Saved test case and check alert with successful message on displayed");
        Assert.assertTrue(testCasePage.isAlertSuccessCaseOnDisplayed(), "Test case didn't create");
    }
}