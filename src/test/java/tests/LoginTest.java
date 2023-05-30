package tests;

import helpers.LoginHelper;
import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AllProjectsPage;
import pages.LoginPage;
import utils.RetryAnalyzer;


@Feature("Registration")
@Story("User Registration")
public class LoginTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class, invocationCount = 2, threadPoolSize = 2)
    @Parameters({"browser"})
    @Description("Log in to website qase.io")
    @Severity(SeverityLevel.BLOCKER)
    public void loginTest(@Optional("firefox") String browser) {
        LoginHelper.login(getDriver());
        AllProjectsPage projectPage = new AllProjectsPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", AllProjectsPage.class.getName()));
        LOGGER.info("Check that the button 'Create new project' is displayed");
        Assert.assertTrue(projectPage.isCreateNewProjectButtonOnDisplayed(), "authorization failed");
    }

    @Test
    @Description("Log in to website qase.io")
    @Severity(SeverityLevel.BLOCKER)
    public void LoginRandomDataTest() {
        LoginHelper.login(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isErrorMessageOnDisplayed(), "The user is logged in");
    }
}