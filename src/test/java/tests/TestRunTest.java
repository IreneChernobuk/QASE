package tests;

import constants.ProjectName;
import helpers.LoginHelper;
import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllProjectsPage;
import pages.ProjectPage;
import pages.RunDashboardPage;
import pages.RunPage;

@Epic("Creating new functionality")
@Feature("Test run")
@Story("Start test run")
public class TestRunTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(TestRunTest.class.getName());

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Creating new test run")
    public void startTestRunTest() {
        LoginHelper.login(getDriver());
        AllProjectsPage allProjectsPagePage = new AllProjectsPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", AllProjectsPage.class.getName()));
        allProjectsPagePage.clickCelectedProject(ProjectName.QASE.getProjectName());
        LOGGER.info(String.format("Chose %s project", ProjectName.QASE));
        ProjectPage projectPage = new ProjectPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", ProjectPage.class.getName()));
        projectPage.clickTestRunsButton();
        RunPage runPage = new RunPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", AllProjectsPage.class.getName()));
        runPage.clickStartTestRunButton();
        LOGGER.info("Form opened");
        String testRunName = runPage.getTitleTestRun();
        LOGGER.info(String.format("Get title test run: '%s'", testRunName));
        runPage.fillTestRun();
        LOGGER.info("Form test run fill out");
        runPage.selectTestCase();
        LOGGER.info("Selected 'test case' for new 'test run");
        runPage.clickStartARunButton();
        RunDashboardPage dashboardPage = new RunDashboardPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", RunDashboardPage.class.getName()));
        Assert.assertEquals(dashboardPage.getCreatedTitleTestRun(), testRunName, "the name of test run not equal");
        LOGGER.info("Checked that title test run matches");
    }
}