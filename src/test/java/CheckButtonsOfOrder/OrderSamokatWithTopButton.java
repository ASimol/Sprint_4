package CheckButtonsOfOrder;

import org.junit.After;
import org.junit.Test;
import pageobject.FirstPageOrder;
import pageobject.MainPageSamokat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;

public class OrderSamokatWithTopButton {
    private WebDriver driver;
    @Test
    // тест заказа через кнопку сверху в FireFox (Успешный)
    public void orderWithTopButtonInFireFox() {
        // драйвер для браузера ff
        GeckoDriverService gecko = new GeckoDriverService.Builder()
                .usingDriverExecutable(new File("C:\\WebDriver\\bin\\geckodriver.exe"))
                .usingFirefoxBinary(new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe")))
                .build();
        driver = new FirefoxDriver(gecko);

        MainPageSamokat objMainPage = new MainPageSamokat(driver);
        objMainPage.open();
        objMainPage.clickTopButton();

        FirstPageOrder objPageOrder = new FirstPageOrder(driver);
        objPageOrder.fillInFirstForm("Петр","Петров", "Родионова, 23", "Измайлово", "89990002233");
        objPageOrder.fillInSecondForm("04.11.2022","Хочу кататься");
        objPageOrder.orderCreationSuccessful();}

    @Test
    // тест заказа через кнопку сверху в Google Chrome (Баг!)
    public void orderWithTopButtonInChrome() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        MainPageSamokat objMainPage = new MainPageSamokat(driver);
        objMainPage.open();
        objMainPage.clickTopButton();

        FirstPageOrder objPageOrder = new FirstPageOrder(driver);
        objPageOrder.fillInFirstForm("Петр","Петров", "Родионова, 23", "Измайлово", "89990002233");
        objPageOrder.fillInSecondForm("04.11.2022","Хочу кататься");
        objPageOrder.orderCreationSuccessful();}

    @After
    public void teardown() {
        // close br
        driver.quit();
    }
}