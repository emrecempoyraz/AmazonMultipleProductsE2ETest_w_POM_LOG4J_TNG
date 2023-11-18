package PageObjects;

import TestManager.ConfigReader;
import TestManager.Log;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BackHomePage extends BasePage{
    public BackHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchBar ;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    private WebElement searchResultText ;

    public void searchProduct2_OnSearchBar () {
        if (searchBar.isDisplayed()) {
            core.clickTo(searchBar,5);
            Log.pass("searched to product2");
        } else Log.fail("cant find the searchbar !");
        if (searchBar.isDisplayed()){
            core.sendKeysTo(searchBar, ConfigReader.getProperty("product2") + Keys.ENTER);
            Log.pass("sent keys to searchBar");
        }else Log.fail("cant send keys to searchbar");
    }

    public boolean isSearchCompleted () {
        String actualSearchResult = searchResultText.getText();
        String expectedSearchResult = "power bank" ;
        return actualSearchResult.contains(expectedSearchResult) ;
    }
}
