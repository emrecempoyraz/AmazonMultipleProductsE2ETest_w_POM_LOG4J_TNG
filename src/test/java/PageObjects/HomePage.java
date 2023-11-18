package PageObjects;

import TestManager.ConfigReader;
import TestManager.Log;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchBarLocator ;

    @FindBy (css = "#sp-cc-accept")
    private WebElement acceptCookies ;

    @FindBy (xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    private WebElement searchResultText ;

    public void acceptCookies () {
        if (acceptCookies.isDisplayed()) {
            core.clickTo(acceptCookies,5);
        }
    }

    public void searchProductOnSearchBar () {
        if (searchBarLocator.isDisplayed()) {
            core.clickTo(searchBarLocator,5);
            Log.pass("searched to product");
        } else Log.fail("cant find the searchbar !");
        if (searchBarLocator.isDisplayed()){
            core.sendKeysTo(searchBarLocator,ConfigReader.getProperty("product1") + Keys.ENTER);
            Log.pass("sent keys to searchBar");
        }else Log.fail("cant send keys to searchbar");
    }

    public boolean isSearchCompleted () {
        String actualSearchResult = searchResultText.getText();
        String expectedSearchResult = "laptop" ;
        return actualSearchResult.contains(expectedSearchResult) ;
    }
}
