package CheckButtonsOfOrder;

import org.junit.Test;
import org.junit.After;
import pageobject.FirstPageOrder;
import pageobject.MainPageSamokat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;

public class OrderSamokatWithDownButton {

    private WebDriver driver;

    private final String textOrderPlaced = "Заказ оформлен";

    @Test
    // тест заказа через нижнию кнопку в FireFox (Успешный)
    public void orderWithDownButtonInFirefox() {
        // драйвер для браузера ff
        GeckoDriverService gecko = new GeckoDriverService.Builder()
                .usingDriverExecutable(new File("C:\\WebDriver\\bin\\geckodriver.exe"))
                .usingFirefoxBinary(new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe")))
                .build();
        driver = new FirefoxDriver(gecko);

        MainPageSamokat objMainPage = new MainPageSamokat(driver);
        objMainPage.open();
        objMainPage.clickDownButton();

        FirstPageOrder objOrderPage = new FirstPageOrder(driver);
        objOrderPage.fillInFirstForm("Иван", "Иванкович", "Нижегородская, 1", "Черкизовская", "89101234567");
        objOrderPage.fillInSecondForm("03.11.2022", "Жду свой самокат!");
        objOrderPage.orderCreationSuccessful(textOrderPlaced);
    }

    @Test
    // тест заказа через нижнию кнопку в Google Chrome (Баг!)
    public void orderWithDownButtonInChrome() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);

        MainPageSamokat objMainPage = new MainPageSamokat(driver);
        objMainPage.open();
        objMainPage.clickDownButton();

        FirstPageOrder objOrderPage = new FirstPageOrder(driver);
        objOrderPage.fillInFirstForm("Иван", "Иванкович", "Нижегородская, 1", "Черкизовская", "89101234567");
        objOrderPage.fillInSecondForm("03.11.2022", "Жду свой самокат!");
        objOrderPage.orderCreationSuccessful(textOrderPlaced);
    }
    @After
    public void teardown() {
        // close br
        driver.quit();
    }
