package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;

public class SecondPageOrder {

    private WebDriver driver;

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

    //Локатор кнопки просмотра успешного заказа
    private By statusButton = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and (text()= 'Посмотреть статус')]");


    public SecondPageOrder(WebDriver driver){
        this.driver = driver;
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
    //Метод кнопки статуса заказа
    public void orderCreationSuccessful() {
        Assert.assertTrue("Заказ не создан. Cтатуса нет", driver.findElement(statusButton).isDisplayed());
        driver.findElement(statusButton).click();
    }

    public void enterInSecondForm(String userDate, String userComment) {
        setDate(userDate);
        setOrderTime();
        clickColor();
        setComment(userComment);
        clickNextButton();
        clickAgreementButton();
        orderCreationSuccessful();
    }
}