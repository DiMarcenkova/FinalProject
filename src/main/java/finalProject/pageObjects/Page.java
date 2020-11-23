package finalProject.pageObjects;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Page {

    private By mainSearch = By.className("sn-suggest-input");
    private By mainSearchButton = By.className("main-search-submit");

    public void setUpSelenide() {
        Configuration.baseUrl = "https://www.1a.lv/";
        Configuration.holdBrowserOpen = true;
        Configuration.startMaximized = true;
    }

    public void openHomepage() {
        open("");
    }

    public String getPageTitle() {
        String pageTitle = Selenide.title();
        return pageTitle;
    }

    // method that use global search of website to find product
    public void productSearch(String searchProduct) {
        $(mainSearch).sendKeys(searchProduct);
        $(mainSearchButton).click();
    }
}