package tests;

import constants.ProjectName;
import data.PrepareSuiteData;
import helpers.LoginHelper;
import io.qameta.allure.*;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.modal.SuiteModal;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.RetryAnalyzer;

@Epic("Creating new functionality")
@Feature("Test suite")
@Story("Creating new test suite")
public class SuiteTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(SuiteTest.class.getName());

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Creating new test suite in 'QASE Project'")
    public void createNewTestSuiteTest() {
        LoginHelper.login(getDriver());
        AllProjectsPage allProjectsPagePage = new AllProjectsPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", AllProjectsPage.class.getName()));
        allProjectsPagePage.clickCelectedProject(ProjectName.QASE.getProjectName());
        LOGGER.info(String.format("Chose %s project", ProjectName.QASE));
        ProjectPage projectPage = new ProjectPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", ProjectPage.class.getName()));
        projectPage.clickNewSuiteButton();
        LOGGER.info("Form for filling in the data of new suite test opened");
        NewSuitePage suitePage = new NewSuitePage(getDriver());
        LOGGER.info(String.format("Form %s initialized", NewSuitePage.class.getName()));
        SuiteModal suiteModal = PrepareSuiteData.getValidSuiteData();
        suitePage.fillNewSuiteForm(suiteModal);
        LOGGER.info("filled suite case with following details:" + suiteModal);
        LOGGER.info("Check that alert with successful message on displayed");
        Assert.assertTrue(suitePage.isAlertSuccessSuiteOnDisplayed(), "Suite case didn't create");
    }
}