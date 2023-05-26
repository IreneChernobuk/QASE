package pages;

import io.qameta.allure.Step;
import pages.modal.DefectsModal;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DefectsPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(DefectsPage.class.getName());
    private By CREATE_DEFECT_BUTTON = By.xpath("//div[@class = 'filters-block']/parent::div//a");
    private By TITLE_INPUT = By.id("title");
    private By ACTUAL_RESULT_INPUT = By.id("actual_result");
    private By SAVE_BUTTON = By.xpath("//button[text() = 'Create defect']");
    private By ALERT_DEFECT_CASE = By.xpath("//span[text()= 'Defect was created successfully!']");

    public DefectsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Create new defect")
    public void clickNewDefectButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", CREATE_DEFECT_BUTTON));
        driver.findElement(CREATE_DEFECT_BUTTON).click();
    }

    @Step("Fill defect form")
    public void fillDefectForm(DefectsModal defect) {
        LOGGER.info("input 'TITLE_INPUT' and 'ACTUAL_RESULT_INPUT'");
        driver.findElement(TITLE_INPUT).sendKeys(defect.getDefectTitle());
        driver.findElement(ACTUAL_RESULT_INPUT).sendKeys(defect.getDefectTitle());
    }

    @Step("Save defect")
    public void clickSaveDefectButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", SAVE_BUTTON));
        driver.findElement(SAVE_BUTTON).click();
    }

    @Step("Check that the alert with successful message is displayed")
    public boolean isAlertSuccessDefectOnDisplayed() {
        LOGGER.info("Check that alert with successful message on displayed");
        return driver.findElement(ALERT_DEFECT_CASE).isDisplayed();
    }
}