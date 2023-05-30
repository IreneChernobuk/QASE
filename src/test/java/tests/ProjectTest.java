package tests;

import data.PrepareNewProjectData;
import helpers.LoginHelper;
import io.qameta.allure.*;
import pages.modal.NewProjectModal;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.GenerateTestData;

@Epic("Creating new functionality")
@Feature("Project")

public class ProjectTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(ProjectTest.class.getName());
    String projectCode;
    String projectName;

    @Story("Creating new Project")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Creating new Project")
    public void createNewProjectTest() {
        LoginHelper.login(getDriver());
        AllProjectsPage allProjectsPagePage = new AllProjectsPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", AllProjectsPage.class.getName()));
        allProjectsPagePage.clickNewProjectButton();
        LOGGER.info("Form for filling in the data of new project opened");
        NewProjectPage newProjectPage = new NewProjectPage(getDriver());
        LOGGER.info(String.format("Form %s initialized", NewProjectPage.class.getName()));
        NewProjectModal newProjectModal = PrepareNewProjectData.getValidProjectData();
        newProjectPage.fillNewProjectForm(newProjectModal);
        LOGGER.info("filled project with following details:" + newProjectModal);
        projectCode = newProjectModal.getProjectCode();
        projectName = newProjectModal.getProjectName();
        LOGGER.info(String.format("received project name: '%s'", projectCode));
        ProjectPage project = new ProjectPage(getDriver());
        LOGGER.info(String.format("Form %s initialized", ProjectPage.class.getName()));
        removeImplicitlyWait();
        Assert.assertTrue(project.receiveTitleProject().contains(newProjectModal.getProjectCode()), "project didn't create");
    }

    @Story("Updating project")
    @Test(dependsOnMethods = "createNewProjectTest")
    @Severity(SeverityLevel.NORMAL)
    @Description("Updating project that was created in the test 'createNewProjectTest'")
    public void updateSettingsProjectTest() {
        LoginHelper.login(getDriver());
        AllProjectsPage allProjectsPagePage = new AllProjectsPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", AllProjectsPage.class.getName()));
        allProjectsPagePage.clickCelectedProject(projectName);
        LOGGER.info(String.format("Chose %s project", projectName));
        ProjectPage projectPage = new ProjectPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", ProjectPage.class.getName()));
        projectPage.clickSettingsButton();
        LOGGER.info(String.format("Page %s open", SettingsProjectPage.class.getName()));
        SettingsProjectPage settingsPage = new SettingsProjectPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", SettingsProjectPage.class.getName()));
        settingsPage.clearRegistrationForm();
        LOGGER.info("Registration form cleared");
        NewProjectModal newProjectModal = PrepareNewProjectData.getValidProjectData();
        settingsPage.refillRegistrationForm(newProjectModal);
        LOGGER.info("update project with following details:" + newProjectModal);
        settingsPage.chooseProjectAccessType(GenerateTestData.getAccessTypeProject());
        LOGGER.info("chose the type of access for the project");
        settingsPage.clickUpdateSettingsButton();
        LOGGER.info("saved updated project data");
        Assert.assertTrue(settingsPage.isAlertOnDisplayed(), "project didn't update");
        LOGGER.info("Checked that alert is displayed");
    }
}