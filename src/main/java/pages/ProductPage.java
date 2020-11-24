package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class ProductPage {
    private By productPriceDetailsBlock = By.className("product-price-details__block");
    private By spansPrice = By.className("price");
    private By productName = By.className("product-righter");
    private By cardButton = By.id("add_to_cart_btn");
    private By confirmPopUp = By.id("cart-popup-container");
    private By continueShoppingButton = By.className("main-button-border");
    private By goToCartBlock = By.className("cart-block");

    public String getProductPrice() {
        SelenideElement productPriceElement = $(productPriceDetailsBlock);
        ElementsCollection spans = productPriceElement.$$(spansPrice);
        String price = spans.get(0).getText().split(" ")[0];

        return price;
    }

    public String getProductName() {
        SelenideElement productNameElement = $(productName);
        String name = productNameElement.$(byCssSelector("h1")).getText();

        return name;
    }

    public void addToCart() {
        sleep(200);
        $(cardButton).scrollTo().click();
        sleep(200);

        SelenideElement cartPopup = $(confirmPopUp);
        SelenideElement button = cartPopup.$(continueShoppingButton);
        button.hover();
        button.click();
    }

    public void goToCart() {
        $(goToCartBlock).click();
    }
}
