package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import models.ProductModel;
import org.junit.Assert;
import pages.*;

public class ProductPageSteps {

    private ProductPage productPage = new ProductPage();

    @And("I validate selected product title and price on product page")
    public void iValidateSelectedProductTitleAndPriceOnProductPage() {
        String currentPrice = productPage.getProductPrice();
        String currentName = productPage.getProductName();

        Assert.assertEquals("Choosen product price is different from expected.", ProductModel.getPrice(), currentPrice);
        Assert.assertEquals("Choosen product name is different from expected.", ProductModel.getName(), currentName);
    }

    @Then("I add to cart chosen product")
    public void iAddToCartChosenProduct() {
        productPage.addToCart();
    }

    @And("Go to cart")
    public void goToCart() {
        productPage.goToCart();
    }

}