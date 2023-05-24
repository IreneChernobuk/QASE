package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(ProjectPage.class.getName());
    private By TITLE_PROJECT = By.xpath("//div[@id ='application-content']//h1");
    private By SETTINGS_BUTTON = By.xpath("//a[@title='Settings']");
    private By NEW_SUITE_BUTTON = By.id("create-suite-button");
    private By NEW_CASE_BUTTON = By.id("create-case-button");

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    public void clickSettingsButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", SETTINGS_BUTTON));
        driver.findElement(SETTINGS_BUTTON).click();
    }

    public String receiveTitleProject() {
        return driver.findElement(TITLE_PROJECT).getText();
    }

    public void clickNewSuiteButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", NEW_SUITE_BUTTON));
        driver.findElement(NEW_SUITE_BUTTON).click();
    }

    public void clickNewCaseButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", NEW_CASE_BUTTON));
        driver.findElement(NEW_CASE_BUTTON).click();
    }
}