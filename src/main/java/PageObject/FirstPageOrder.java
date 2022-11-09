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

    //Локатор поля Станция метро
    private By subway = By.xpath(".//input[@class='select-search__input']");

    //Локатор для выбора Станции метро
    private By subwaySelect = By.className("select-search__select");

    //Локатор ввода Телефон
    private By phone = By.xpath(".//input[contains(@class, 'Input_Responsible__1jDKN') and (@placeholder= '* Телефон: на него позвонит курьер')]");

    //Локатор Далее для оформления заказа
    private By next = By.xpath(".//button[text()='Далее']");
    //Локатор даты Когда привезти
    private By date = By.xpath(".//input[contains(@class, 'Input_Input__1iN_Z') and (@placeholder= '* Когда привезти самокат')]");

    //Локатор Срок аренды
    private By orderTime= By.className("Dropdown-control");

    //Локатор количества суток
    private By oneDay= By.xpath(".//div[contains(@class, 'Dropdown-option') and (text()= 'сутки')]");

    //Локатор выбора цвета
    private By pickcolor = By.className("Checkbox_Input__14A2w");

    //Локатор комментария курьеру
    private By comment = By.xpath(".//input[contains(@class, 'Input_Responsible__1jDKN') and (@placeholder= 'Комментарий для курьера')]");

    //Локатор кнопки Заказать
    private By finishOrderButton = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and (text()= 'Заказать')]");

    //Локатор кнопки Хотите фоормить заказ?
    private By agreementButton = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and (text()= 'Да')]");

    // локатор для cообщения об успешном создании заказа
    private By textMessage = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and (text()= 'Посмотреть статус')]");

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
    public void setSubway(String metroStations) {
        driver.findElement(subway).click();
        driver.findElement(subway).sendKeys(metroStations);
        driver.findElement(subwaySelect).click();
    }
    //Метод для заполнения поля * Телефон
    public void setPhone(String userPhone) {
        driver.findElement(phone).sendKeys(userPhone);
    }
    //Нажатие кнопки далее
    public void clickNext() {
        driver.findElement(next).click();
    }
    //Метод выбора даты заказа
    public void setDate(String userDate) {
        driver.findElement(date).sendKeys(userDate, Keys.ENTER);
    }
    //Метод выбора количества суток
    public void setOrderTime() {
        driver.findElement(orderTime).click();
        driver.findElement(oneDay).click();
    }
    //Метод выбора цвета самоката
    public void clickColor() {
        driver.findElement(pickcolor).click();
    }
    //Метод ввода комментария
    public void setComment(String userComment) {
        driver.findElement(comment).sendKeys(userComment);
    }
    //Метод кнопки "Заказать"
    public void clickNextButton() {
        driver.findElement(finishOrderButton).click();
    }
    //Метод кнопки подтверждения заказа "Да"
    public void clickAgreementButton() {
        driver.findElement(agreementButton).click();
    }
    //Метод проверки появился ли заказ - есть ли статус заказа
    public void orderCreationSuccessful() {driver.findElement(textMessage);}

    // метод заполнения полей на первой странице
    public void fillInFirstForm(String userName, String userSurname, String userAddress, String metroStations,
                                String userPhone) {
        setName(userName);
        setSurname(userSurname);
        setAddress(userAddress);
        setSubway(metroStations);
        setPhone(userPhone);
        clickNext();
    }
    // метод заполнения полей на второй странице
    public void fillInSecondForm(String userDate, String userComment) {
        setDate(userDate);
        setOrderTime();
        clickColor();
        setComment(userComment);
        clickNextButton();
        clickAgreementButton();
    }

}