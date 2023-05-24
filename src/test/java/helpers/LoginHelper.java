package helpers;

import constants.Credentials;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginHelper {
    private static final Logger LOGGER = LogManager.getLogger(LoginHelper.class.getName());

    public static void login(WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        loginPage.openLoginPage();
        LOGGER.info(String.format("Page %s opened", LoginPage.class.getName()));
        LOGGER.info("Input EMAIL and PASSWORD");
        loginPage.clickLoginButton(Credentials.EMAIL, Credentials.PASSWORD);
        LOGGER.info("Login completed successfully");
    }
}