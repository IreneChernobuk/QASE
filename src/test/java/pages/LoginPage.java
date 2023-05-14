package pages;

import constants.Credentials;
import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.FakerMessageGenerator;

public class LoginPage extends BasePage {
    private By EMAIL_INPUT = By.id("inputEmail");
    private By PASSWORD_INPUT = By.id("inputPassword");
    private By LOGIN_BUTTON = By.id("btnLogin");
    private By MESSAGE_ERROR = By.xpath("//div[@data-qase-test = 'login-error']");
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open login page")
    public void openLoginPage() {
        LOGGER.debug(String.format("Attempt to open: %s", Urls.QASE_LOGIN));
        driver.get(Urls.QASE_LOGIN);
    }

    @Step("input email and password")
    public void clickLoginButton() {
        LOGGER.info("Input EMAIL");
        driver.findElement(EMAIL_INPUT).sendKeys(Credentials.EMAIL);
        driver.findElement(PASSWORD_INPUT).sendKeys(Credentials.PASSWORD);
        LOGGER.debug(String.format("Attempt to click element: %s", LOGIN_BUTTON));
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("input email and password")
    public void clickLoginButtonWithRandomData() {
        LOGGER.info("Input EMAIL");
        driver.findElement(EMAIL_INPUT).sendKeys(FakerMessageGenerator.generateEmail());
        driver.findElement(PASSWORD_INPUT).sendKeys(FakerMessageGenerator.generatePassword());
        LOGGER.debug(String.format("Attempt to click element: %s", LOGIN_BUTTON));
        driver.findElement(LOGIN_BUTTON).click();
    }

    public boolean isErrorMessageOnDisplayed() {
        LOGGER.debug("Check the error message is displayed");
        return driver.findElement(MESSAGE_ERROR).isDisplayed();
    }
}