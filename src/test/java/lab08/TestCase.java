package lab08;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class TestCase {
    protected WebDriver driver;

    @BeforeAll
    public void init() {
        System.setProperty("webdriver.gecko.driver"," ../geckodriver");
        driver=new FirefoxDriver();
    }
}
