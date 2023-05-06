package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProjectPage;

public class LoginSteps {
    WebDriver driver;
    @Given("Login page opened")
    public void loginPageOpened() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
        driver.quit();
    }
}