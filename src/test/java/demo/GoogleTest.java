package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

    @Test
    public void testGoogleTitle() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");            // run without UI
        options.addArguments("--no-sandbox");          // required in CI
        options.addArguments("--disable-dev-shm-usage"); // prevents memory issues

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Google");
        driver.quit();
    }
}
