package steps;

import cucumber.api.java.en.Then;
import pages.*;

public class ProductSearchPageStepDefs {
    private ProductSearchPage productSearchPage = new ProductSearchPage();

    @Then("I select a {string} product from list")
    public void iSelectAProductFromList(String selectFromList) {
        productSearchPage.selectProductFromList(Integer.parseInt(selectFromList));
    }
}