package CheckButtonsOfOrder;

import main.BrowserChoice;
import org.junit.Rule;
import org.junit.Test;
import PageObject.FirstPageOrder;
import PageObject.MainPageSamokat;
import PageObject.SecondPageOrder;

public class OrderSamokatWithDownButton {

    @Rule
    public BrowserChoice browserChoice = new BrowserChoice();

    @Test
    public void OrderWithTopButton() {

        MainPageSamokat objMainPageForDownButton = new MainPageSamokat(browserChoice.driver);

        objMainPageForDownButton.open();

        objMainPageForDownButton.clickDownButton();

        FirstPageOrder objFirstPageOrder = new FirstPageOrder(browserChoice.driver);

        objFirstPageOrder.enterInFirstForm("Иван","Иванкович", "Нижегородская, 1", "89101234567");

        SecondPageOrder objSecondPageOrder = new SecondPageOrder(browserChoice.driver);

        objSecondPageOrder.enterInSecondForm("03.11.2022","Жду свой самокат!");
    }
}