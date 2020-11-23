package finalProject.pageObjects;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import finalProject.models.ProductModel;
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

    public void filterApply(String filterName, String value) {
        ElementsCollection listOfFilters = elements(filterBlocks);
        SelenideElement filterBlock = null;

        for (SelenideElement currentEl : listOfFilters) {
            String currentText = currentEl.$(By.className("filter-title")).getText();

            if (currentText.equals(filterName)) {
                currentEl.$(By.className("sn-facetExpand")).scrollIntoView(true);
                currentEl.$(By.xpath("//a[contains(@href)]")).click();

                filterBlock = currentEl;
                break;
            }
        }

        ElementsCollection listOfFilterCheckboxes = elements(filterBlockCheckbox);

        for (SelenideElement currentCheckBoxInFilter : listOfFilterCheckboxes) {
            String currentText = currentCheckBoxInFilter.$(By.className("filter-link")).getText();

            if (currentText.startsWith(value)) {
                currentCheckBoxInFilter.$(By.className("indicator")).scrollIntoView(true);
                currentCheckBoxInFilter.$(By.className("indicator")).setSelected(true);
                break;
            }
        }

        $(filterByBrand).click();
    }

    public ProductModel selectProductFromList(int selectFromList) {
        sleep(1000);
        SelenideElement productsElement = element(productsListFull);
        ElementsCollection productElementsCollection = productsElement.$$(newProductItem);

        assert productElementsCollection.size() != 0 : "productElementsCollection size is 0";
        assert productElementsCollection.size() >= selectFromList : "productElementsCollection size is 0";

        SelenideElement selectedProduct = productElementsCollection.get(selectFromList - 1);

        // Replacing every non-digit number
        String selectedProductPrice = selectedProduct.$(itemPrice).getText();
        selectedProductPrice = selectedProductPrice.split(" ")[0];

        String selectedProductName = selectedProduct.$(itemName).getText();

        ProductModel productModel = new ProductModel(selectedProductName, selectedProductPrice);

        selectedProduct.$(itemImage).scrollTo();
        selectedProduct.click();

        return productModel;
    }
}