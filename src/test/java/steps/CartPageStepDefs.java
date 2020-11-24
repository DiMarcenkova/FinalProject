package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import models.ProductModel;
import org.junit.Assert;
import pages.*;

public class CartPageStepDefs {

    private CartPage cartPage = new CartPage();

    @And("Validate that product title is equal with the title on the product page")
    public void validateThatProductTitleIsEqualWithTheTitleOnTheProductPage() {
        String currentName = cartPage.getName();
        Assert.assertEquals("Choosen product name is different from expected.", ProductModel.getName(), currentName);
    }

    @Then("I proceed to check out")
    public void iProceedToCheckOut() {
        cartPage.goToCheckOut();
    }
}