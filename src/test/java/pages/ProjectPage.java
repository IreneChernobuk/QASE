package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(ProjectPage.class.getName());
    private By TITLE_PROJECT = By.xpath("//div[@id ='application-content']//h1");
    private By SETTINGS_BUTTON = By.xpath("//a[@title='Settings']");
    private By NEW_SUITE_BUTTON = By.id("create-suite-button");
    private By NEW_CASE_BUTTON = By.id("create-case-button");
    private By SHARED_STEP_BUTTON = By.xpath("//a[@title = 'Shared Steps']");
    private By TEST_RUNS_BUTTON = By.xpath("//a[@title= 'Test Runs']");
    private By DEFECTS_BUTTON = By.xpath("//a[@title= 'Defects']");

    public ProjectPage(WebDriver driver) {
        super(driver);
    }
    @Step("Click 'Settings 'button' on the in the list on the left")
    public void clickSettingsButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", SETTINGS_BUTTON));
        driver.findElement(SETTINGS_BUTTON).click();
    }
    @Step("Get  title of project")
    public String receiveTitleProject() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_PROJECT));
        LOGGER.debug(String.format("Receive text of element: %s", TITLE_PROJECT));
        return driver.findElement(TITLE_PROJECT).getText();
    }

    @Step("Click 'suite' button")
    public void clickNewSuiteButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", NEW_SUITE_BUTTON));
        driver.findElement(NEW_SUITE_BUTTON).click();
    }

    @Step("Click 'test case' button")
    public void clickNewCaseButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", NEW_CASE_BUTTON));
        driver.findElement(NEW_CASE_BUTTON).click();
    }

    @Step("Click 'shared step' button")
    public void clickSharedStepButton(){
        LOGGER.debug(String.format("Attempt to click element: %s", SHARED_STEP_BUTTON));
        driver.findElement(SHARED_STEP_BUTTON).click();
    }

    @Step("Click 'shared step' button")
    public void clickTestRunsButton(){
        LOGGER.debug(String.format("Attempt to click element: %s", TEST_RUNS_BUTTON));
        driver.findElement(TEST_RUNS_BUTTON).click();
    }

    @Step("Click 'defect' button")
    public void clickDefectsButton(){
        LOGGER.debug(String.format("Attempt to click element: %s", DEFECTS_BUTTON));
        driver.findElement(DEFECTS_BUTTON).click();
    }
}