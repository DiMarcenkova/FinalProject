package pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import models.ProductModel;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ProductSearchPage {

    private By filterBlocks = By.className("filter-block");
    private By filterBlockCheckbox = By.className("ck-check");
    private By searchFilter = By.className("form-control");
    private By filterByBrand = By.className("filter-link__label");

    private By productsListFull = By.className("products-list-full");
    private By newProductItem = By.className("new-product-item");
    private By itemPrice = By.className("item-price");
    private By itemName = By.className("new-product-name");
    private By itemImage = By.className("new-product-image");

    public void selectProductFromList(int selectFromList) {
        sleep(1500);
        SelenideElement productsElement = element(productsListFull);
        ElementsCollection productElementsCollection = productsElement.$$(newProductItem);

        assert productElementsCollection.size() != 0 : "productElementsCollection size is 0";
        assert productElementsCollection.size() >= selectFromList : "No such element in list";

        SelenideElement selectedProduct = productElementsCollection.get(selectFromList - 1);

        // Replacing every non-digit number
        String selectedProductPrice = selectedProduct.$(itemPrice).getText();
        selectedProductPrice = selectedProductPrice.split(" ")[0];

        String selectedProductName = selectedProduct.$(itemName).getText();

        ProductModel.setName(selectedProductName);
        ProductModel.setPrice(selectedProductPrice);

        selectedProduct.$(itemImage).scrollTo();
        selectedProduct.click();
    }
}