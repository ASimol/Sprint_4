package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;


public class FirstPageOrder {

    private WebDriver driver;

    //Локатор ввода Имя
    private By name = By.xpath(".//input[contains(@class, 'Input_Responsible__1jDKN') and (@placeholder= '* Имя')]");

    //Локатор ввода Фамилия
    private By surname = By.xpath(".//input[contains(@class, 'Input_Responsible__1jDKN') and (@placeholder= '* Фамилия')]");

    //Локатор ввода Адрес
    private By address = By.xpath(".//input[contains(@class, 'Input_Responsible__1jDKN') and (@placeholder= '* Адрес: куда привезти заказ')]");

    //Локатор выбора Станция метро
    private By subway = By.xpath(".//input[@class='select-search__input']");

    //Локатор ввода Телефон
    private By phone = By.xpath(".//input[contains(@class, 'Input_Responsible__1jDKN') and (@placeholder= '* Телефон: на него позвонит курьер')]");

    //Локатор Далее для оформления заказа
    private By next = By.xpath(".//button[text()='Далее']");

    public FirstPageOrder(WebDriver driver){
        this.driver = driver;
    }

    //Метод для заполнения поля * Имя
    public void setName(String userName) {
        driver.findElement(name).sendKeys(userName);
    }
    //Метод для заполнения поля * Фамилия
    public void setSurname(String userSurname) {
        driver.findElement(surname).sendKeys(userSurname);
    }
    //Метод для заполнения поля * Адрес
    public void setAddress(String userAddress) {
        driver.findElement(address).sendKeys(userAddress);
    }
    //Метод для заполнения поля * Метро
    public void setSubway() {
        driver.findElement(subway).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }
    //Метод для заполнения поля * Телефон
    public void setPhone(String userPhone) {
        driver.findElement(phone).sendKeys(userPhone);
    }
    //Нажатие кнопки далее
    public void clickNext() {
        driver.findElement(next).click();
    }
    //Заполнение данными первой страницы заказа
    public void enterInFirstForm(String userName, String userSurname, String userAddress,
                                 String userPhone) {
        setName(userName);
        setSurname(userSurname);
        setAddress(userAddress);
        setSubway();
        setPhone(userPhone);
        clickNext();
    }
}