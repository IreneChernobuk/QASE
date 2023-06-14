package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.FakerMessageGenerator;

public class RunPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(RunPage.class.getName());
    private By START_TEST_RUN_BUTTON = By.xpath("//div[@class = 'filters-block']/parent::div//preceding-sibling::button");
    private By TITLE_TEST_RUN = By.xpath("//input[@placeholder = 'Give a name to the test run']");
    private By RADIO_BUTTON_REPOSITORY = By.xpath("//input[@value = 'repo']");
    private By SELECT_CASES_BUTTON = By.xpath("//span[text() = 'Select cases']/parent::button");
    private By DESCRIPTION = By.id("description");
    private By SELECT_TEST_CASE = By.xpath("//div[@id = 'suite-0']//span");
    private By DONE_BUTTON = By.xpath("//span[text() = 'Done']/parent::button");
    private By START_A_RUN_BUTTON = By.xpath("//span[text() = 'Start a run']/parent::button");

    public RunPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'Start test run' button")
    public void clickStartTestRunButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", START_TEST_RUN_BUTTON));
        driver.findElement(START_TEST_RUN_BUTTON).click();
    }

    @Step("Get  title of test run")
    public String getTitleTestRun() {
        LOGGER.debug(String.format("Receive text of element: %s", TITLE_TEST_RUN));
        return driver.findElement(TITLE_TEST_RUN).getAttribute("value");
    }

    @Step("Fill test run form")
    public void fillTestRun() {
        driver.findElement(DESCRIPTION).sendKeys(FakerMessageGenerator.generateText());
        driver.findElement(RADIO_BUTTON_REPOSITORY).click();
        driver.findElement(SELECT_CASES_BUTTON).click();
    }

    @Step("Select 'test case' for new 'test run'")
    public void selectTestCase() {
        LOGGER.debug(String.format("Attempt to click element: %s", SELECT_TEST_CASE));
        driver.findElement(SELECT_TEST_CASE).click();
        LOGGER.debug(String.format("Attempt to click element: %s", DONE_BUTTON));
        driver.findElement(DONE_BUTTON).click();
    }

    @Step("Save 'test run'")
    public void clickStartARunButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", START_A_RUN_BUTTON));
        driver.findElement(START_A_RUN_BUTTON).click();
    }
}