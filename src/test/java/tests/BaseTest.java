package tests;

import factorymanager.DriverFactory;
import factorymanager.DriverManager;
import factorymanager.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.TestListeners;

import java.util.concurrent.TimeUnit;

@Listeners(TestListeners.class)
public class BaseTest {
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("firefox") String browser) {
        DriverFactory driverFactory = new DriverFactory();
        DriverType type = null;
        if (browser.equals("chrome")){
            type = DriverType.CHROME;
        } else if (browser.equals("firefox")){
            type = DriverType.FIREFOX;
        }
        DriverManager driverManager = driverFactory.getManager(type);
        driverManager.createDriver();
        driverManager.setTimeout();
        driverManager.startMaximize();
        driver = driverManager.getDriver();
        threadLocalDriver.set(driver);
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }
    public void removeImplicitlyWait(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }
    public void setTimeout() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        getDriver().quit();
        threadLocalDriver.remove();
    }
}