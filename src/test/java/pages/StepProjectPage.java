package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.FakerMessageGenerator;

public class StepProjectPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(StepProjectPage.class.getName());
    private By CREATE_SHARED_STEP_BUTTON = By.xpath("//div[@class= 'filters-block']//preceding-sibling::a");
    private By TITLE_INPUT = By.id("title");
    private By ADD_STEP_BUTTON = By.id("addStep");
    private By ACTION_STEP_INPUT = By.id("action[0]");
    private By DATA_STEP_INPUT = By.id("data[0]");
    private By EXPECTED_RESULT_STEP_INPUT = By.id("expected_result[0]");
    private By SAVE_BUTTON = By.xpath("//button[text() = 'Create']");
    private By ALERT_SUCCESS_SHARED_STEP = By.xpath("//span[text()= 'Shared step was created successfully!']");

    public StepProjectPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'shared step' button")
    public void clickCreateSharedStepButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", CREATE_SHARED_STEP_BUTTON));
        driver.findElement(CREATE_SHARED_STEP_BUTTON).click();
    }

    @Step("Fill title 'shared step'")
    public void inputTitle() {
        LOGGER.info("Input TITLE");
        driver.findElement(TITLE_INPUT).sendKeys(FakerMessageGenerator.generateTitle());
    }

    @Step("Fill 'shared step' form")
    public void addStep() {
        LOGGER.debug(String.format("Attempt to click element: %s", ADD_STEP_BUTTON));
        driver.findElement(ADD_STEP_BUTTON).click();
        LOGGER.info("Input ACTION_STEP");
        driver.findElement(ACTION_STEP_INPUT).sendKeys(FakerMessageGenerator.generateText());
        LOGGER.info("Input DATA_STEP");
        driver.findElement(DATA_STEP_INPUT).sendKeys(FakerMessageGenerator.generateText());
        LOGGER.info("Input EXPECTED_RESULT");
        driver.findElement(EXPECTED_RESULT_STEP_INPUT).sendKeys(FakerMessageGenerator.generateText());
    }

    @Step("Save shared button")
    public void clickSaveButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", SAVE_BUTTON));
        driver.findElement(SAVE_BUTTON).click();
    }

    @Step("Check that the alert with successful message is displayed")
    public boolean isAlertSuccessSharedStepOnDisplayed() {
        LOGGER.info("Check that alert with successful message on displayed");
        return driver.findElement(ALERT_SUCCESS_SHARED_STEP).isDisplayed();
    }
}