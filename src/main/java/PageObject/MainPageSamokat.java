package PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class MainPageSamokat {
    private WebDriver driver;
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    ///Кнопка заказа вверху страницы
    private By topButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    ///Кнопка Cookie
    private By cookieButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    ///Кнопка заказа внизу страницы
    private By downButton = By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and (text()='Заказать')]");

    ///Первый вопрос
    private By questionFirst = By.id("accordion__heading-0");
    ///Первый ответ
    private By answerFirst = By.id("accordion__panel-0");

    ///Второй вопрос
    private By questionTwo = By.id("accordion__heading-1");
    ///Второй ответ
    private By answerTwo = By.id("accordion__panel-1");

    ///Третий вопрос
    private By questionThree = By.id("accordion__heading-2");
    ///Третий ответ
    private By answerThree = By.id("accordion__panel-2");

    ///Четвертый вопрос
    private By questionFour = By.id("accordion__heading-3");
    ///Четвертый ответ
    private By answerFour = By.id("accordion__panel-3");

    ///Пятый вопрос
    private By questionFive = By.id("accordion__heading-4");
    ///Пятый ответ
    private By answerFive = By.id("accordion__panel-4");

    ///Шестой вопрос
    private By questionSix = By.id("accordion__heading-5");
    ///Шестой ответ
    private By answerSix = By.id("accordion__panel-5");

    ///Седьмой вопрос
    private By questionSeven = By.id("accordion__heading-6");
    ///Седьмой ответ
    private By answerSeven = By.id("accordion__panel-6");

    ///Восьмой вопрос
    private By questionEight = By.id("accordion__heading-7");
    ///Восьмой ответ
    private By answerEight = By.id("accordion__panel-7");

    public MainPageSamokat(WebDriver driver){
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void clickTopButton() {
        driver.findElement(topButton).click();
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }
    public void clickDownButton() {
        clickCookieButton();
        driver.findElement(downButton).click();
    }

    public void checkAnswerToQuestionFirst() {
        driver.findElement(questionFirst).sendKeys(Keys.RETURN);;
        Assert.assertTrue("Вопрос №1- нет ответа", driver.findElement(answerFirst).isDisplayed());

    }

    public void checkAnswerToQuestionTwo() {
        driver.findElement(questionTwo).sendKeys(Keys.RETURN);
        Assert.assertTrue("Вопрос №2- нет ответа", driver.findElement(answerTwo).isDisplayed());
    }

    public void checkAnswerToQuestionThree() {
        driver.findElement(questionThree).sendKeys(Keys.RETURN);
        Assert.assertTrue("Вопрос №3- нет ответа", driver.findElement(answerThree).isDisplayed());
    }

    public void checkAnswerToQuestionFour() {
        driver.findElement(questionFour).sendKeys(Keys.RETURN);
        Assert.assertTrue("Вопрос №4- нет ответа", driver.findElement(answerFour).isDisplayed());
    }

    public void checkAnswerToQuestionFive() {
        driver.findElement(questionFive).sendKeys(Keys.RETURN);
        Assert.assertTrue("Вопрос №5- нет ответа", driver.findElement(answerFive).isDisplayed());
    }

    public void checkAnswerToQuestionSix() {
        driver.findElement(questionSix).sendKeys(Keys.RETURN);
        Assert.assertTrue("Вопрос №6- нет ответа", driver.findElement(answerSix).isDisplayed());
    }

    public void checkAnswerToQuestionSeven() {
        driver.findElement(questionSeven).sendKeys(Keys.RETURN);
        Assert.assertTrue("Вопрос №7- нет ответа", driver.findElement(answerSeven).isDisplayed());
    }

    public void checkAnswerToQuestionEight() {
        driver.findElement(questionEight).sendKeys(Keys.RETURN);
        Assert.assertTrue("Вопрос №8- нет ответа", driver.findElement(answerEight).isDisplayed());
    }
}