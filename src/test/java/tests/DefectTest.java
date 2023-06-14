package tests;

import constants.ProjectName;
import data.PrepareDefectData;
import helpers.LoginHelper;
import io.qameta.allure.*;
import pages.modal.DefectsModal;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllProjectsPage;
import pages.DefectsPage;
import pages.ProjectPage;

@Epic("Creating new functionality")
@Feature("Defect")
@Story("Creating new Defect")
public class DefectTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(DefectTest.class.getName());

    @Test
    @Description("Creating new defect in 'QASE Project'")
    @Severity(SeverityLevel.CRITICAL)
    public void createDefectTest() {
        LoginHelper.login(getDriver());
        AllProjectsPage allProjectsPagePage = new AllProjectsPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", AllProjectsPage.class.getName()));
        allProjectsPagePage.clickCelectedProject(ProjectName.QASE.getProjectName());
        LOGGER.info(String.format("Chose %s project", ProjectName.QASE));
        ProjectPage projectPage = new ProjectPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", ProjectPage.class.getName()));
        projectPage.clickDefectsButton();
        DefectsPage defectsPage = new DefectsPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", DefectsPage.class.getName()));
        defectsPage.clickNewDefectButton();
        LOGGER.info(String.format("Page %s open", DefectsPage.class.getName()));
        DefectsModal defectsModal = PrepareDefectData.getValidDefectData();
        defectsPage.fillDefectForm(defectsModal);
        LOGGER.info("filled defect form with following details:" + defectsModal);
        defectsPage.clickSaveDefectButton();
        Assert.assertTrue(defectsPage.isAlertSuccessDefectOnDisplayed(), "Test case didn't create");
        LOGGER.info("Checked that alert with successful message on displayed");
    }
}