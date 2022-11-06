package CheckButtonsOfOrder;

import main.BrowserChoice;
import org.junit.Rule;
import org.junit.Test;
import PageObject.FirstPageOrder;
import PageObject.MainPageSamokat;
import PageObject.SecondPageOrder;

public class OrderSamokatWithTopButton {

    @Rule
    public BrowserChoice browserChoice = new BrowserChoice();

    @Test
    public void OrderWithTopButton() {

        MainPageSamokat objMainPageForTopButton = new MainPageSamokat(browserChoice.driver);

        objMainPageForTopButton.open();

        objMainPageForTopButton.clickTopButton();

        FirstPageOrder objFirstOrderPage = new FirstPageOrder(browserChoice.driver);

        objFirstOrderPage.enterInFirstForm("Петр","Петров", "Родионова, 23", "89990002233");

        SecondPageOrder objSecondPageOrder = new SecondPageOrder(browserChoice.driver);

        objSecondPageOrder.enterInSecondForm("04.11.2022","Хочу кататься");    }
}