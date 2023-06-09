package pages;

import io.qameta.allure.Step;
import pages.modal.NewProjectModal;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewProjectPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(NewProjectPage.class.getName());
    private By PROJECT_NAME = By.id("project-name");
    private By PROJECT_CODE = By.id("project-code");
    private By DESCRIPTION = By.id("description-area");
    private By PUBLIC_INPUT = By.xpath("//input[@value = 'public']");
    private By CREATE_PROJECT_BUTTON = By.xpath("//span[text()= 'Create project']/parent::button");

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill new project form")
    public void fillNewProjectForm(NewProjectModal projectModel) {
        LOGGER.info("Input 'PROJECT_NAME'");
        driver.findElement(PROJECT_NAME).sendKeys(projectModel.getProjectName());
        LOGGER.info("Input 'PROJECT_CODE'");
        WebElement code = driver.findElement(PROJECT_CODE);
        code.clear();
        code.sendKeys(projectModel.getProjectCode());
        LOGGER.info("Input DESCRIPTION");
        driver.findElement(DESCRIPTION).sendKeys(projectModel.getDescription());
        LOGGER.info("Input the type of access for the project");
        driver.findElement(PUBLIC_INPUT).click();
        LOGGER.debug(String.format("Attempt to click element: %s", CREATE_PROJECT_BUTTON));
        driver.findElement(CREATE_PROJECT_BUTTON).click();
    }
}