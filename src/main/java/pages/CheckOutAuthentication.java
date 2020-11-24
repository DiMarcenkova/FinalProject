package pages;

import com.codeborne.selenide.SelenideElement;
import models.CustomerModel;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckOutAuthentication {
    private By newUserGuestBlock = By.id("new_user_guest");
    private By newUserGuestEmailInput = By.className("users-session-form__input");
    private By newUserGuestButton = By.name("commit");

    public void proceed(String authType, CustomerModel customerModel) {
        if (authType.equals("unauthorized")) {
            SelenideElement guestBlockElement = $(newUserGuestBlock);
            guestBlockElement.scrollTo();

            // 1. fill email
            SelenideElement guestEmailInputElement = guestBlockElement.$(newUserGuestEmailInput);
            guestEmailInputElement.sendKeys(customerModel.getEmail());

            // 2. push continue button
            SelenideElement guestButtonElement = guestBlockElement.$(newUserGuestButton);
            guestButtonElement.hover();
            guestButtonElement.click();

        } else if (authType.equals("authorized")) {
            // TODO if we need authorization
        } else {
            assert true : "wrong authorization type.";
        }

    }
}
