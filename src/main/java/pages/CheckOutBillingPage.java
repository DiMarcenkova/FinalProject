package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CheckOutBillingPage {

    private By checkoutOrderSummaryBlock = By.className("checkout-order-summary");
    private By checkoutOrderSummaryBlockPrice = By.className("checkout-order-summary-total__price");

    private By paymentTypeBlock = By.className("for-radio");
    private By paymentTypeBlockRadio = By.name("payment_unused");

    public void choosePaymentType(String paymentType) {
        ElementsCollection paymentTypeCollection = $$(paymentTypeBlock);
        SelenideElement paymentElementRadio;
        switch (paymentType) {
            case "other":
                paymentElementRadio = paymentTypeCollection.get(0).$(paymentTypeBlockRadio);
                paymentElementRadio.setSelected(true);
                break;
            case "cash":
                paymentElementRadio = paymentTypeCollection.get(1).$(paymentTypeBlockRadio);
                paymentElementRadio.setSelected(true);
                break;
            case "bank":
                paymentElementRadio = paymentTypeCollection.get(2).$(paymentTypeBlockRadio);
                paymentElementRadio.setSelected(true);
                break;
            case "card":
                paymentElementRadio = paymentTypeCollection.get(3).$(paymentTypeBlockRadio);
                paymentElementRadio.setSelected(true);
                break;
            default:
                break;
        }
    }

    public String getFinalPrice() {
        SelenideElement checkoutOrderSummaryBlockElement = $(checkoutOrderSummaryBlock);
        SelenideElement priceElement = checkoutOrderSummaryBlockElement.$(checkoutOrderSummaryBlockPrice);
        String price = priceElement.getText().split(" ")[0];

        return price;
    }
}
