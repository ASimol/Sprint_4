package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPageSamokat {
    private WebDriver driver;
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    //Кнопка заказа вверху страницы
    private By topButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    //Кнопка Cookie
    private By cookieButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    // локатор для элемента 'вопросы о важном'
    private By questionsImportant = By.xpath(".//div[text()='Вопросы о важном']");

    // локатор для элемента аккордеона
    private By elementAccordion;

    //локатор для текста элемента аккордеона
    private By elementTextAccordion;

    //Кнопка заказа внизу страницы
    private By downButton = By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and (text()='Заказать')]");

    // конструктор класса
    public MainPageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    //метод для перехода на тестовую страницу
    public void open() {
        driver.get(url);
    }
    //метод прокрутки до элемента Вопросы о важном
    public void scrollQuestionsImportant() {
        WebElement element = driver.findElement(questionsImportant);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //метод нажатия на стрелочку элемента аккордеона
    public void clickAccordionArrow(int number) {
        if (number >= 1) {
            elementAccordion = By.id("accordion__heading-" + (number - 1));
        }
        driver.findElement(elementAccordion).click();
    }
    //метод проверки появления текста
    public void waitTextAppear(String textAccordion, int number) {
        if (number >= 1) {
            elementTextAccordion = By.id("accordion__panel-" + (number - 1));
        }
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.textToBePresentInElementLocated(elementTextAccordion, textAccordion));
    }

    //метод для нажатия на кнопку сверху заказать
    public void clickTopButton() {
        driver.findElement(topButton).click();
    }
    //метод для нажатия на кнопку cookie
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }
    //метод для нажатия на нижнию кнопку заказать
    public void clickDownButton() {
        clickCookieButton();
        driver.findElement(downButton).click();
    }
    // метод для прокрутки до нижней кнопки заказать
    public void scrollDownButton() {
        WebElement element = driver.findElement(downButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}