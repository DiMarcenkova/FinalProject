package steps;

import cucumber.api.java.en.Then;
import models.ProductModel;
import pages.*;

public class ProductSearchPageSteps {
    private ProductSearchPage productSearchPage = new ProductSearchPage();

    @Then("I select a {string} product from list")
    public void iSelectAProductFromList(String selectFromList) {
        productSearchPage.selectProductFromList(Integer.parseInt(selectFromList));
    }
}