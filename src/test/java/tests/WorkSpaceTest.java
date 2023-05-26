package tests;

import helpers.LoginHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllProjectsPage;
import pages.WorkspacePage;

public class WorkSpaceTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(WorkSpaceTest.class.getName());

    @Test
    public void changeNameWorkspace() {
        LoginHelper.login(getDriver());
        AllProjectsPage allProjectsPagePage = new AllProjectsPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", AllProjectsPage.class.getName()));
        allProjectsPagePage.clickWorkspaceButton();
        WorkspacePage workspace = new WorkspacePage(getDriver());
        LOGGER.info(String.format("Page %s initialized", WorkspacePage.class.getName()));
        workspace.clickSettingsButton();
        LOGGER.info("Clicked 'Settings' button on the in the list on the left");
        workspace.fillWorkspaceName();
        String workspaceName = workspace.getWorkspaceName();
        LOGGER.info(String.format("filled 'Workspace Name': '%s'", workspaceName));
        workspace.clickUpdateWorkspaceNameButton();
        LOGGER.info("Saved undating and check that 'Workspace Name' matches");
        Assert.assertTrue(workspace.checkWorkspaceNameIsDisplayed(workspaceName), "workspace name didn't change");
    }
}