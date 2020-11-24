package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private By detailedCartItemName = By.className("detailed-cart-item__name-link");
    private By cartCheckOutBlock = By.className("cart-totals-block");
    private By cartCheckOutButton = By.className("main-button");

    public String getName() {
        String cartSelectedItemName = $(detailedCartItemName).getText();

        return cartSelectedItemName;
    }

    public void goToCheckOut() {
        SelenideElement checkOutBlock = $(cartCheckOutBlock);
        SelenideElement checkOutButton = checkOutBlock.$(cartCheckOutButton);
        checkOutButton.hover();
        checkOutBlock.scrollTo();
        checkOutButton.click();
    }
}