package lab10;

import lab09.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DemoQAFormTests extends TestCase {
    @Test
    public void endToEndFillForm() {
        DemoQAMainPage page = new DemoQAMainPage(driver)
                .clickForms()
                .clickPraciseForm();
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }
}
