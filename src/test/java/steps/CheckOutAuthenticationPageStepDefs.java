package steps;

import cucumber.api.java.en.And;
import models.CustomerModel;
import pages.*;

public class CheckOutAuthenticationPageStepDefs {
    private CheckOutAuthentication checkoutAuthentication = new CheckOutAuthentication();
    private CustomerModel customerModel = new CustomerModel();

    @And("I choose authentication type {string}")
    public void iChooseAuthenticationType(String authorizationType) {
        checkoutAuthentication.proceed(authorizationType, customerModel);
    }
}