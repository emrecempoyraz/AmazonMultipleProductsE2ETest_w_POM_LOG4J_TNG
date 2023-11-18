package PageObjects;

import TestManager.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class ProductDetailPage extends BasePage{
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = ".a-size-large.a-spacing-none")
    private WebElement productDescription ;

    @FindBy (css = "input#add-to-cart-button")
    private WebElement addToCartButton ;

    @FindBy (css = "#NATC_SMART_WAGON_CONF_MSG_SUCCESS")
    private WebElement addedToCartText ;

    @FindBy (id = "nav-logo-sprites")
    private WebElement amazonLogoLocator ;

    public boolean isLaptopClicked () {
        String actualDescription = productDescription.getText();
        String expectedDescription = "HP Laptop 15 Dizüstü Bilgisayar" ;
        return actualDescription.contains(expectedDescription);
    }

    public void addLaptopToCart () {
        if (addToCartButton.isDisplayed()) {
            core.clickTo(addToCartButton,5);
            Log.pass("Laptop added to cart");
        } else Log.fail("Not added to cart");
    }

    public boolean isLaptopAddedToCart () {
        String actualText = addedToCartText.getText() ;
        String expectedText = " Sepete Eklendi" ;
        return expectedText.contains(actualText);
    }

    public void backToHomePage () {
        if (amazonLogoLocator.isDisplayed()) {
            core.clickTo(amazonLogoLocator,5);
            Log.pass("Back to home page");
        }else Log.fail("cant find to homepage");
    }

    public boolean isBackToHomePage () {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com.tr/ref=nav_logo" ;
        return expectedUrl.equals(actualUrl);
    }

}

