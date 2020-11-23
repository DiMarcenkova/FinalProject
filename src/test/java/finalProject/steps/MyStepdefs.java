package finalProject.steps;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import finalProject.models.CustomerModel;
import finalProject.models.ProductModel;
import finalProject.pageObjects.*;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MyStepdefs {
    private Page page = new Page();
    private ProductSearchPage productSearchPage = new ProductSearchPage();
    private ProductPage productPage = new ProductPage();
    private CartPage cartPage = new CartPage();
    private CheckoutAuthentication checkoutAuthentication = new CheckoutAuthentication();
    private CheckoutShippingPage checkoutShippingPage = new CheckoutShippingPage();
    private CheckoutBillingPage checkoutBillingPage = new CheckoutBillingPage();
    private CustomerModel customerModel = new CustomerModel();
    private ProductModel productModel;

    @Given("Open Chrome browser")
    public void openChromeBrowser() {
        page.setUpSelenide();
    }

    @When("I open web page {string}")
    public void iOpenWebPage(String homePageAddress) {
        page.openHomepage();
    }

    @Then("I validate that page title is {string}")
    public void iValidateThatPageTitleIs(String expectedTitle) {
        String pageTitle = page.getPageTitle();
        Assert.assertEquals("Title is incorrect", expectedTitle, pageTitle);
    }

    @When("I search product {string}")
    public void iSearchProduct(String searchProduct) {
        page.productSearch(searchProduct);
    }

    @Then("I choose from filter {string} value {string}")
    public void iChooseFromFilterValue(String filterName, String filterValue) {
        productSearchPage.filterApply(filterName, filterValue);
    }

    @Then("I select a {string} product from list")
    public void iSelectAProductFromList(String selectFromList) {
        productModel = productSearchPage.selectProductFromList(Integer.parseInt(selectFromList));
    }

    @And("I validate selected product title and price on product page")
    public void iValidateSelectedProductTitleAndPriceOnProductPage() {
        String currentPrice = productPage.getProductPrice();
        String currentName = productPage.getProductName();

        Assert.assertEquals("Choosen product price is different from expected.", productModel.getPrice(), currentPrice);
        Assert.assertEquals("Choosen product name is different from expected.", productModel.getName(), currentName);
    }

    @Then("I add to cart chosen product")
    public void iAddToCartChosenProduct() {
        productPage.addToCart();
    }

    @And("Go to cart")
    public void goToCart() {
        productPage.goToCart();
    }

    @And("Validate that product title is equal with the title on the product page")
    public void validateThatProductTitleIsEqualWithTheTitleOnTheProductPage() {
        String currentName = cartPage.getName();
        Assert.assertEquals("Choosen product name is different from expected.", productModel.getName(), currentName);
    }

    @Then("I proceed to check out")
    public void iProceedToCheckOut() {
        cartPage.goToCheckOut();
    }

    @And("I choose authentication type {string}")
    public void iChooseAuthenticationType(String authorizationType) {
        checkoutAuthentication.proceed(authorizationType, customerModel);
    }

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
        $(By.xpath("//button[@class='main-button upcase fr small-radius button-min-width checkout-shipping-continue-button']")).scrollTo().click();
    }

    @Then("I choose payment type {string} on a billing page")
    public void iChoosePaymentTypeOnABillingPage(String paymentType) {
        checkoutBillingPage.choosePaymentType(paymentType);
    }

    @And("Validate that final price is equal with the price on the product page")
    public void validateThatFinalPriceIsEqualWithThePriceOnTheProductPage() {
        String finalPrice = checkoutBillingPage.getFinalPrice();
        Assert.assertEquals("Choosen product price is different from expected.", productModel.getPrice(), finalPrice);
    }

    @Then("Close browser")
    public void closeBrowser() {
        sleep( 5000);
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}