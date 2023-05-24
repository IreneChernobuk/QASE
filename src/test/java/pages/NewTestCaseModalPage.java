package pages;

import elements.DropdownList;
import elements.TextInput;
import modal.TestCaseModal;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTestCaseModalPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(NewTestCaseModalPage.class.getName());
    private By ADD_STEP_BUTTON = By.xpath("//span[text() =' Add step']/parent::button");
    private By STEP_ACTION_INPUT = By.xpath("//p[@data-placeholder = 'Step Action']");
    private By STEP_DATA_INPUT = By.xpath("//p[@data-placeholder = 'Data']");
    private By EXPECTED_RESULT_INPUT = By.xpath("//p[@data-placeholder = 'Expected result']");

    private By SAVE_CASE_BUTTON = By.id("save-case");
    private By ALERT_SUCCESS_CASE = By.xpath("//span[text()= 'Test case was created successfully!']");

    public NewTestCaseModalPage(WebDriver driver) {
        super(driver);
    }

    public void fillTestCaseForm(TestCaseModal testCase) {
        new TextInput(driver, "Title").inputText(testCase.getTitle());
        new TextInput(driver, "Description").inputText(testCase.getDescription());
        new TextInput(driver, "Pre-conditions").inputText(testCase.getPreConditions());
        new TextInput(driver, "Post-conditions").inputText(testCase.getPostConditions());
        new DropdownList(driver, "Severity").selectOptionInList(testCase.getSeverity());
        new DropdownList(driver, "Priority").selectOptionInList(testCase.getPriority());
        new DropdownList(driver, "Status").selectOptionInList(testCase.getStatus());
        new DropdownList(driver, "Type").selectOptionInList(testCase.getType());
        new DropdownList(driver, "Layer").selectOptionInList(testCase.getLayer());
        new DropdownList(driver, "Is flaky").selectOptionInList(testCase.getIsFlaky());
        new DropdownList(driver, "Behavior").selectOptionInList(testCase.getBehavior());
        new DropdownList(driver, "Automation status").selectOptionInList(testCase.getAutomationStatus());
        driver.findElement(ADD_STEP_BUTTON).click();
        driver.findElement(STEP_ACTION_INPUT).sendKeys(testCase.getStepAction());
        driver.findElement(STEP_DATA_INPUT).sendKeys(testCase.getStepAction());
        driver.findElement(EXPECTED_RESULT_INPUT).sendKeys(testCase.getExpectedResult());
    }

    public void clickSaveTestCaseButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", SAVE_CASE_BUTTON));
        driver.findElement(SAVE_CASE_BUTTON).click();
    }

    public boolean isAlertSuccessCaseOnDisplayed() {
        LOGGER.debug("Check that alert with successful message on displayed");
        return driver.findElement(ALERT_SUCCESS_CASE).isDisplayed();
    }
}