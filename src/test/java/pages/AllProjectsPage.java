package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllProjectsPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(AllProjectsPage.class.getName());
    private By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");
    private static final String NAME_XPATH = "//table//a[contains(text(), '%s')]";

    public AllProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check that the button 'Create new project' is displayed")
    public boolean isCreateNewProjectButtonOnDisplayed() {
        LOGGER.debug(String.format("Check that the button %s is displayed", CREATE_NEW_PROJECT_BUTTON));
        return driver.findElement(CREATE_NEW_PROJECT_BUTTON).isDisplayed();
    }

    public void clickNewProjectButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", CREATE_NEW_PROJECT_BUTTON));
        driver.findElement(CREATE_NEW_PROJECT_BUTTON).click();
    }

    public void clickCelectedProject(String projectName) {
        String nameProjectFinalXpath = String.format(NAME_XPATH, projectName);
        LOGGER.debug(String.format("Creating new Xpath '%s' for '%s' project", nameProjectFinalXpath, projectName));
        LOGGER.debug(String.format("Attempt to click '%s' project", projectName));
        driver.findElement(By.xpath(nameProjectFinalXpath)).click();
    }
}