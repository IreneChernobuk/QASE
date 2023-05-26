package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.FakerMessageGenerator;

public class WorkspacePage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(WorkspacePage.class.getName());
    private By SETTINGS_BUTTON = By.xpath("//a[@title = 'Settings']");
    private By WORKSPACE_NAME_INPUT = By.id("inputTitle");
    private By UPDATE_WORKSPACE_NAME_BUTTON = By.xpath(" //button[text() ='Update settings']");
    String WORKSPACE_NAME_XPATH = "//div[@id = 'layout']//div[contains(text(), '%s')]";

    public WorkspacePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'Settings' button on the in the list on the left")
    public void clickSettingsButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", SETTINGS_BUTTON));
        driver.findElement(SETTINGS_BUTTON).click();
    }

    @Step("Fill 'Workspace' field")
    public void fillWorkspaceName() {
        LOGGER.info("input 'WORKSPACE_NAME_INPUT'");
        driver.findElement(WORKSPACE_NAME_INPUT).sendKeys(FakerMessageGenerator.generateName());
    }

    @Step("Get 'Workspace name'")
    public String getWorkspaceName() {
        LOGGER.debug(String.format("Receive text of element: %s", WORKSPACE_NAME_INPUT));
        return driver.findElement(WORKSPACE_NAME_INPUT).getText();
    }

    @Step("Update workspace name")
    public void clickUpdateWorkspaceNameButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", UPDATE_WORKSPACE_NAME_BUTTON));
        driver.findElement(UPDATE_WORKSPACE_NAME_BUTTON).click();
    }

    @Step("Checking that  the entered 'workspace name' is displayed")
    public boolean checkWorkspaceNameIsDisplayed(String name) {
        String nameWorkspaceFinalXpath = String.format(WORKSPACE_NAME_XPATH, name);
        LOGGER.debug(String.format("Creating new Xpath '%s' for '%s' workspace", WORKSPACE_NAME_XPATH, name));
        LOGGER.debug("Check update workspace name");
        return driver.findElement(By.xpath(nameWorkspaceFinalXpath)).isDisplayed();
    }
}