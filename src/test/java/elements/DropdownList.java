package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropdownList {
    private WebDriver driver;
    private String labelText;
    private static final String LIST_XPATH = "//label[text()='%s']/following::div[1]";
    private static final String OPTION_XPATH = "//div[@id = 'modals']//div[text() = '%s']";

    public DropdownList(WebDriver driver, String labelText) {
        this.driver = driver;
        this.labelText = labelText;
    }

    public void selectOptionInList(String option) {
        String ListFinalXpath = String.format(LIST_XPATH, labelText);
        driver.findElement(By.xpath(ListFinalXpath)).click();
        String optionFinalXpath = String.format(OPTION_XPATH, option);
        driver.findElement(By.xpath(optionFinalXpath)).click();
    }
}