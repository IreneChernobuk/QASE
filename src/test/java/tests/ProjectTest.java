package tests;

import data.PrepareNewProjectData;
import helpers.LoginHelper;
import modal.NewProjectModal;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.GenerateTestData;

import java.sql.DriverManager;

public class ProjectTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(ProjectTest.class.getName());
    String projectName;

    // WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    @Test
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
        projectName = newProjectModal.getProjectName();
        LOGGER.info(String.format("received project name: '%s'", projectName));
        ProjectPage project = new ProjectPage(getDriver());
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("user")));
        LOGGER.info(String.format("Form %s initialized", ProjectPage.class.getName()));
        Assert.assertTrue(project.receiveTitleProject().contains(newProjectModal.getProjectCode()), "project didn't create");
    }

    @Test(dependsOnMethods = "createNewProjectTest")
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
        LOGGER.info("Check that alert is displayed");
        Assert.assertTrue(settingsPage.isAlertOnDisplayed(),"project didn't update");
    }
}