package pages;

import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());
    private By EMAIL_INPUT = By.name("email");
    private By PASSWORD_INPUT = By.name("password");
    private By LOGIN_BUTTON = By.xpath("//span[text() = 'Sign in']/..");
    private By MESSAGE_ERROR = By.xpath("//span[text() = 'These credentials do not match our records.']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open login page")
    public void openLoginPage() {
        LOGGER.debug(String.format("Attempt to open: %s", Urls.QASE_LOGIN));
        driver.get(Urls.QASE_LOGIN);
    }

    @Step("Input email and password")
    public void clickLoginButton(String email, String password) {
        LOGGER.info("Input EMAIL");
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        LOGGER.debug(String.format("Attempt to click element: %s", LOGIN_BUTTON));
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Check the error alert is displayed")
    public boolean isErrorAlertOnDisplayed() {
        LOGGER.info("Check the error alert is displayed");
        return driver.findElement(MESSAGE_ERROR).isDisplayed();
    }
}