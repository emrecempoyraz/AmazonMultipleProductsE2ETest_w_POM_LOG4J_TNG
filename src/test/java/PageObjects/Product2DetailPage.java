package PageObjects;

import TestManager.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product2DetailPage extends BasePage {

    public Product2DetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//h1[@id='title']")
    private WebElement productDescription ;

    @FindBy(css = "input#add-to-cart-button")
    private WebElement addToCartButton ;

    @FindBy (css = "#NATC_SMART_WAGON_CONF_MSG_SUCCESS")
    private WebElement addedToCartText ;

    @FindBy (className = "a-button a-button-span11 a-button-base a-button-small")
    private WebElement goToCartButton ;

    public boolean isProduct2Selected () {
        String actualResult = productDescription.getText();
        String expectedResult = "Xiaomi Redmi 20000 Mah Powerbank Taşınabilir Hızlı Şarj Cihazı - Siyah" ;
        return actualResult.contains(expectedResult);
    }

    public void addPowerbankToCart () {
        if (addToCartButton.isDisplayed()) {
            core.clickTo(addToCartButton,5);
            Log.pass("Second product added to cart");
        }else Log.fail("Second product not added to cart");
    }

    public boolean isPowerbankAddedToCart () {
        String actualText =addedToCartText.getText() ;
        String expectedText = " Sepete Eklendi" ;
        return expectedText.contains(actualText);
    }

    public void goToCart () {
        if (goToCartButton.isDisplayed()) {
            core.clickTo(addToCartButton,5);
            Log.pass("Product added to cart");
        }else Log.fail("Not added to cart");
    }


}
