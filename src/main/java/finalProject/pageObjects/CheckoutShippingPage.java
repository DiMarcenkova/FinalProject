package finalProject.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import finalProject.models.CustomerModel;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CheckoutShippingPage {
    private By deliveryMenu = By.className("menu");
    private By deliveryMenuChooseOptions = By.className("for-radio");
    private By deliveryMenuRadioButton = By.name("shipping_unused");

    private By checkoutOrderSummaryBlock = By.className("checkout-order-summary");
    private By checkoutOrderSummaryBlockPrice = By.className("checkout-order-summary-total__price");

    private By storesBlock = By.className("stores-list");
    private By storesBlockPickUpPoints = By.name("pickup_point_id");

    private By userdataBlock = By.className("choose-address");
    private By userdataBlockName = By.id("address_first_name");
    private By userdataBlockLastName = By.id("address_last_name");
    private By userdataBlockPhoneNumber = By.id("address_phone_number");

    private By nextBtn = By.id("button");

    public void selectDeliveryType(String deliveryType) {
        SelenideElement deliveryTypesElement = $(deliveryMenu);
        ElementsCollection deliveryTypeCollection = deliveryTypesElement.$$(deliveryMenuChooseOptions);
        assert deliveryTypeCollection.size() == 3 : "Delivery radio buttons was not found or was changet it count";
        SelenideElement checkBox;
        switch (deliveryType) {
            case "address":
                checkBox = deliveryTypeCollection.get(0).$(deliveryMenuRadioButton);
                checkBox.setSelected(true);
                break;
            case "clientCenter":
                checkBox = deliveryTypeCollection.get(1).$(deliveryMenuRadioButton);
                checkBox.setSelected(true);
                break;
            case "sendingReceivingPoints":
                checkBox = deliveryTypeCollection.get(2).$(deliveryMenuRadioButton);
                checkBox.setSelected(true);
                break;
        }
    }

    public void selectShopAddress() {
        // wait until shops will be loaded
        sleep(2000);
        SelenideElement storesBlockElement = $(storesBlock);
        ElementsCollection radioWrappersCollection = storesBlockElement.$$(storesBlockPickUpPoints);
        radioWrappersCollection.get(1).setSelected(true);
    }

    public void fillUserData(CustomerModel customerModel) {
        SelenideElement userDataBlockElement = $(userdataBlock);

        SelenideElement userNameElement = userDataBlockElement.$(userdataBlockName);
        SelenideElement userLastnameElement = userDataBlockElement.$(userdataBlockLastName);
        SelenideElement userPhoneElement = userDataBlockElement.$(userdataBlockPhoneNumber);

        userNameElement.sendKeys(customerModel.getName());
        userLastnameElement.sendKeys(customerModel.getSurname());
        userPhoneElement.sendKeys(customerModel.getPhone());
    }

    private void goNext() {
        ElementsCollection buttonsOnPageCollection = $$(By.name("button"));
        SelenideElement nextButton = buttonsOnPageCollection.get(1);
        nextButton.scrollTo().click();


    }

    private String getFinalPrice() {
        SelenideElement checkoutOrderSummaryBlockElement = $(checkoutOrderSummaryBlock);
        SelenideElement priceElement = checkoutOrderSummaryBlockElement.$(checkoutOrderSummaryBlockPrice);
        String price = priceElement.getText().split(" ")[0];

        return price;
    }
}
