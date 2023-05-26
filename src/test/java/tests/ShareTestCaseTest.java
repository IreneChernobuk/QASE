package tests;

import constants.ProjectName;
import helpers.LoginHelper;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllProjectsPage;
import pages.ProjectPage;
import pages.StepProjectPage;

public class ShareTestCaseTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(ShareTestCaseTest.class.getName());

    @Test
    public void createStareTestCaseTest() {
        LoginHelper.login(getDriver());
        AllProjectsPage allProjectsPagePage = new AllProjectsPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", AllProjectsPage.class.getName()));
        allProjectsPagePage.clickCelectedProject(ProjectName.QASE.getProjectName());
        LOGGER.info(String.format("Chose %s project", ProjectName.QASE));
        ProjectPage projectPage = new ProjectPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", ProjectPage.class.getName()));
        projectPage.clickSharedStepButton();
        StepProjectPage stepPage = new StepProjectPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", StepProjectPage.class.getName()));
        stepPage.clickCreateSharedStepButton();
        LOGGER.info(String.format("Form %s opened", StepProjectPage.class.getName()));
        stepPage.inputTitle();
        LOGGER.info("Input title 'shared step'");
        stepPage.addStep();
        LOGGER.info("Input details of step");
        stepPage.clickSaveButton();
        LOGGER.info("Saved shared step and check that alert with successful message on displayed");
        Assert.assertTrue(stepPage.isAlertSuccessSharedStepOnDisplayed(), "Shared step didn't create");
    }
}