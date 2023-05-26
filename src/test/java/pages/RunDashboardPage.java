package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RunDashboardPage extends BasePage{
    private static final Logger LOGGER = LogManager.getLogger(RunDashboardPage.class.getName());
    private By TITLE_TEST_RUN = By.xpath("//div[@class = 'run-dashboard-header-title']/h1");

    public RunDashboardPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get  title of test run")
    public String getCreatedTitleTestRun() {
        LOGGER.debug(String.format("Receive text of element: %s", TITLE_TEST_RUN));
        return driver.findElement(TITLE_TEST_RUN).getText();
    }
}