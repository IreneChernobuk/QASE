package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllProjectsPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(AllProjectsPage.class.getName());
    private By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");
    private By WORKSPACE= By.xpath("//a[contains(text(), 'Workspace')]") ;
    private static final String NAME_XPATH = "//table//a[contains(text(), '%s')]";

    public AllProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check that the button 'Create new project' is displayed")
    public boolean isCreateNewProjectButtonOnDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_NEW_PROJECT_BUTTON));
        LOGGER.debug(String.format("Check that the button %s is displayed", CREATE_NEW_PROJECT_BUTTON));
        return driver.findElement(CREATE_NEW_PROJECT_BUTTON).isDisplayed();
    }

    @Step("Create new project")
    public void clickNewProjectButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", CREATE_NEW_PROJECT_BUTTON));
        driver.findElement(CREATE_NEW_PROJECT_BUTTON).click();
    }

    @Step("Selecting project from existing projects")
    public void clickCelectedProject(String projectName) {
        String nameProjectFinalXpath = String.format(NAME_XPATH, projectName);
        LOGGER.debug(String.format("Creating new Xpath '%s' for '%s' project", nameProjectFinalXpath, projectName));
        LOGGER.debug(String.format("Attempt to click '%s' project", projectName));
        driver.findElement(By.xpath(nameProjectFinalXpath)).click();
    }

    @Step("Click 'workspace' button")
    public void clickWorkspaceButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", WORKSPACE));
        driver.findElement(WORKSPACE).click();
    }
}