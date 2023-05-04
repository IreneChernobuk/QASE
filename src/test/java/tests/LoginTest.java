package tests;

import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectPage;
import utils.RetryAnalyzer;
@Feature("Registration")
@Story("User Registration")
public class LoginTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());
    @Test(retryAnalyzer = RetryAnalyzer.class, invocationCount = 2, threadPoolSize = 2)
    @Description("Log in to website qase.io")
    @Severity(SeverityLevel.BLOCKER)
    public void loginTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info(String.format("Page %s opened", LoginPage.class.getName()));
        LOGGER.info("Input EMAIL and PASSWORD");
        loginPage.clickLoginButton();
        ProjectPage projectPage = new ProjectPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", ProjectPage.class.getName()));
        LOGGER.info("Check that the button 'Create new project' is displayed");
        Assert.assertTrue(projectPage.isCreateNewProjectButtonOnDisplayed(), "authorization failed");
    }
}