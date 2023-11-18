package PageObjects;

import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnCartPage () {
        String actualResult = driver.getCurrentUrl();
        String expectedResult = "https://www.amazon.com.tr/cart?ref_=ewc_gtc";
        return actualResult.equals(expectedResult);
    }
}
