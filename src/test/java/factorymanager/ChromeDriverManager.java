package factorymanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager{
    @Override
    public void createDriver() {
        WebDriverManager.chromedriver().setup();
      //  PropertyManager propertyManager = new PropertyManager(); //если что потом удалить и класс пропертиманаджер
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }
}