package factorymanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        driver = WebDriverManager.chromedriver().create();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }
}