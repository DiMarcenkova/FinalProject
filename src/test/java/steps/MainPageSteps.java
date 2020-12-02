package steps;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.*;
import static com.codeborne.selenide.Selenide.sleep;

public class MainPageSteps {
    private MainPage mainPage = new MainPage();

    @Given("Open Chrome browser")
    public void openChromeBrowser() {
        mainPage.setUpSelenide();
    }

    @When("I open web page {string}")
    public void iOpenWebPage(String homePageAddress) {
        mainPage.openHomepage(homePageAddress);
    }

    @Then("I validate that page title is {string}")
    public void iValidateThatPageTitleIs(String expectedTitle) {
        String pageTitle = mainPage.getPageTitle();
        Assert.assertEquals("Title is incorrect", expectedTitle, pageTitle);
    }

    @When("I search product {string}")
    public void iSearchProduct(String searchProduct) {
        mainPage.productSearch(searchProduct);
    }

    @And("Close browser")
    public void closeBrowser() {
        sleep( 5000);
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}