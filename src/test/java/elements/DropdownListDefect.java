package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropdownListDefect {
    private WebDriver driver;
    private String labelText;
    private static final String LIST_XPATH = "//label[contains(text(), '%s')]//following-sibling::div/span";
    private static final String OPTION_XPATH = "//div[@id = 'layout']/div[last()]//div[contains(text(), '%s')]";

    public DropdownListDefect(WebDriver driver, String labelText) {
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
