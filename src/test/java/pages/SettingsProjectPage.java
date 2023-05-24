package pages;

import modal.NewProjectModal;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsProjectPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(SettingsProjectPage.class.getName());
    private By PROJECT_NAME = By.id("project-name");
    private By PROJECT_CODE = By.id("project-code");
    private By DESCRIPTION = By.id("description-area");
    private static String RADIO_XPATH = "//input[@value = '%s']";
    private By UPDATE_SETTINGS_BUTTON = By.xpath("//span[text() = ' Update settings']/parent::button");
    private By ALERT = By.xpath("//div[@role = 'alert']//span/span");

    public SettingsProjectPage(WebDriver driver) {
        super(driver);
    }

    public void clearRegistrationForm() {
        LOGGER.info("Clear PROJECT_NAME");
        driver.findElement(PROJECT_NAME).clear();
        LOGGER.info("Clear PROJECT_CODE");
        driver.findElement(PROJECT_CODE).clear();
        LOGGER.info("Clear DESCRIPTION");
        driver.findElement(DESCRIPTION).clear();
    }

    public void refillRegistrationForm(NewProjectModal projectModel) {
        LOGGER.info("Input PROJECT_NAME");
        driver.findElement(PROJECT_NAME).sendKeys(projectModel.getProjectName());
        LOGGER.info("Input PROJECT_CODE");
        driver.findElement(PROJECT_CODE).sendKeys(projectModel.getProjectCode());
        LOGGER.info("Input DESCRIPTION");
        driver.findElement(DESCRIPTION).sendKeys(projectModel.getDescription());
    }

    public void chooseProjectAccessType(String accessType) {
        String typeAccessFinalXpath = String.format(RADIO_XPATH, accessType);
        LOGGER.debug(String.format("Creating new Xpath '%s' for '%s' access type", typeAccessFinalXpath, accessType));
        LOGGER.debug(String.format("Attempt to click radio button with access type: %s", accessType));
        driver.findElement(By.xpath(typeAccessFinalXpath)).click();
    }

    public void clickUpdateSettingsButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", UPDATE_SETTINGS_BUTTON));
        driver.findElement(UPDATE_SETTINGS_BUTTON).click();
    }

    public boolean isAlertOnDisplayed() {
        LOGGER.info("Check that alert with successful message on displayed");
        return driver.findElement(ALERT).isDisplayed();
    }
}