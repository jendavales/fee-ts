package lab09;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SeleniumTests extends TestCase {

    @Test
    public void findElementTest() {
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName"));
        System.out.println();
    }
}
