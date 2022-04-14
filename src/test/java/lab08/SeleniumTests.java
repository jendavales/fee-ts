package lab08;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTests extends TestCase {

    @Test
    public void findElementTest() {
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName"));
        System.out.println();
    }
}
