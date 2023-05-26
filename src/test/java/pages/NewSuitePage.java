package pages;

import io.qameta.allure.Step;
import pages.modal.SuiteModal;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewSuitePage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(NewSuitePage.class.getName());
    public NewSuitePage(WebDriver driver) {
        super(driver);
    }

    private By SUITE_NAME = By.id("title");
    private By DESCRIPTION = By.id("description");
    private By PRECONDITIONS = By.id("preconditions");
    private By CREATE_SUITE_BUTTON = By.xpath("//span[text()= 'Create']/parent::button");
    private By ALERT_SUCCESS_SUITE = By.xpath("//span[text()= 'Suite was successfully created.']");

    @Step("Fill new suite form")
    public void fillNewSuiteForm(SuiteModal suiteModal) {
        LOGGER.info("Input 'SUITE_NAME'");
        driver.findElement(SUITE_NAME).sendKeys(suiteModal.getSuiteName());
        LOGGER.info("Input 'DESCRIPTION'");
        driver.findElement(DESCRIPTION).sendKeys(suiteModal.getDescription());
        LOGGER.info("Input 'PRECONDITIONS'");
        driver.findElement(PRECONDITIONS).sendKeys(suiteModal.getPreconditions());
        LOGGER.debug(String.format("Attempt to click element: %s", CREATE_SUITE_BUTTON));
        driver.findElement(CREATE_SUITE_BUTTON).click();
    }

    @Step("Check that the alert with successful message is displayed")
    public boolean isAlertSuccessSuiteOnDisplayed() {
        LOGGER.info("Check that alert with successful message on displayed");
        return driver.findElement(ALERT_SUCCESS_SUITE).isDisplayed();
    }
}