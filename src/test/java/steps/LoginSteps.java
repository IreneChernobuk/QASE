package steps;

import factorymanager.DriverFactory;
import factorymanager.DriverManager;
import factorymanager.DriverType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProjectPage;

public class LoginSteps {
    WebDriver driver;

    @Before
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        DriverManager driverManager = driverFactory.getManager(DriverType.FIREFOX);
        driverManager.createDriver();
        driverManager.setTimeout();
        driverManager.startMaximize();
        driver = driverManager.getDriver();
    }

    @Given("Login page opened")
    public void loginPageOpened() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
    }

    @When("Input EMAIL and PASSWORD and click Login button")
    public void inputEMAILAndPASSWORDAndClickLoginButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
    }

    @Then("Button Create new project  on page")
    public void buttonCreateNewProjectOnPage() {
        ProjectPage projectPage = new ProjectPage(driver);
        Assert.assertTrue(projectPage.isCreateNewProjectButtonOnDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}