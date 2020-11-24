package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import models.CustomerModel;
import pages.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class CheckOutShippingPageStepDefs {
    private CheckOutShippingPage checkoutShippingPage = new CheckOutShippingPage();
    private CustomerModel customerModel = new CustomerModel();


    @And("Choose delivery option {string} on shipping page")
    public void chooseDeliveryOptionOnShippingPage(String deliveryType) {
        checkoutShippingPage.selectDeliveryType(deliveryType);
    }

    @And("Choose delivery clientCenter address on a shipping page")
    public void chooseDeliveryClientCenterAddressOnAShippingPage() {
        checkoutShippingPage.selectShopAddress();
    }

    @Then("I fill customer data on a shipping page")
    public void iFillCustomerDataOnAShippingPage() {
        checkoutShippingPage.fillUserData(customerModel);
    }

    @And("I press next on a shipping page")
    public void iPressNextOnAShippingPage() {
        sleep(2000);
        checkoutShippingPage.proceedNext();
    }
}