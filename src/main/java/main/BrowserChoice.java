package main;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserChoice extends ExternalResource {

    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    protected void before() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:/WebDriver/bin/geckodriver.exe");

        String br = System.getenv("browser");

        if ("chrome".equals(br)) {
            driver = new ChromeDriver();
        } else if ("ff".equals(br)) {
            WebDriver driver = new FirefoxDriver();
        }

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Override
    protected void after() {
        driver.quit();
    }
}