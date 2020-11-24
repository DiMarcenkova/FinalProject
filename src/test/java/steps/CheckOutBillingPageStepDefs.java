package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import models.ProductModel;
import org.junit.Assert;
import pages.*;

public class CheckOutBillingPageStepDefs {

    private CheckOutBillingPage checkoutBillingPage = new CheckOutBillingPage();

    @Then("I choose payment type {string} on a billing page")
    public void iChoosePaymentTypeOnABillingPage(String paymentType) {
        checkoutBillingPage.choosePaymentType(paymentType);
    }

    @And("Validate that final price is equal with the price on the product page")
    public void validateThatFinalPriceIsEqualWithThePriceOnTheProductPage() {
        String finalPrice = checkoutBillingPage.getFinalPrice();
        Assert.assertEquals("Choosen product price is different from expected.", ProductModel.getPrice(), finalPrice);
    }
}