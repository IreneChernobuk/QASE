package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextInput {
    private String labelText;
    private WebDriver driver;
    private static final String INPUT_XPATH =
            "//div[contains(@class, 'form-group')]/label[text()='%s']/following::div//input";

    public TextInput(WebDriver driver, String labelText) {
        this.labelText = labelText;
        this.driver = driver;
    }

    public void inputText(String text) {
        String finalXpath = String.format(INPUT_XPATH, labelText);
        driver.findElement(By.xpath(finalXpath)).sendKeys(text);
    }
}