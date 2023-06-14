package tests;

import helpers.LoginHelper;
import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AllProjectsPage;
import pages.LoginPage;
import utils.FakerMessageGenerator;

@Feature("Registration")
@Story("User Registration")
public class LoginTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());

    @Test
    @Description("Log in to website qase.io")
    @Severity(SeverityLevel.BLOCKER)
    public void loginTest() {
        LoginHelper.login(getDriver());
        AllProjectsPage projectPage = new AllProjectsPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", AllProjectsPage.class.getName()));
        LOGGER.info("Check that the button 'Create new project' is displayed");
        removeImplicitlyWait();
        Assert.assertTrue(projectPage.isCreateNewProjectButtonOnDisplayed(), "authorization failed");
    }

    @Test
    @Description("Log in to website qase.io")
    @Severity(SeverityLevel.BLOCKER)
    public void LoginRandomDataTest() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info(String.format("Page %s opened", LoginPage.class.getName()));
        LOGGER.info("Input random EMAIL and random PASSWORD");
        loginPage.clickLoginButton(FakerMessageGenerator.generateEmail(), FakerMessageGenerator.generatePassword());
        Assert.assertTrue(loginPage.isErrorAlertOnDisplayed(), "The user is logged in");
    }
}