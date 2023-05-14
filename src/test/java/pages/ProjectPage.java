package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());
    private By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check that the button 'Create new project' is displayed")
    public boolean isCreateNewProjectButtonOnDisplayed() {
        LOGGER.debug(String.format("Check that the button %s is displayed", CREATE_NEW_PROJECT_BUTTON));
        return driver.findElement(CREATE_NEW_PROJECT_BUTTON).isDisplayed();
    }
}