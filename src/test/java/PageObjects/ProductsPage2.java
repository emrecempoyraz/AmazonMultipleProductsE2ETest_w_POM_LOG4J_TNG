package PageObjects;

import TestManager.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage2 extends BasePage{


    public ProductsPage2(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//i[@class='a-icon a-icon-checkbox'])[4]")
    private WebElement xiaomiBrandFilter ;
    
    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    private WebElement xiaomiCheckbox ;

    @FindBy(xpath = "(//input[@type='checkbox'])[4]")
    private WebElement primeFilterXiaomi;

    @FindBy (xpath = "(//a[@class='a-link-normal s-no-outline'])[4]")
    private WebElement xiaomiProductLink ;

    public void pickXiaomiBrandFilter () {
        if (xiaomiBrandFilter.isDisplayed()) {
            core.clickTo(xiaomiBrandFilter,10);
            Log.pass("Selected Prime Filter");
        } else {Log.fail("Hp brand not selected");}
    }

    public boolean isXiaomiSelected () {
        boolean isXiaomiSelected = false ;
        if (xiaomiCheckbox.isSelected()) isXiaomiSelected = true ;
        return isXiaomiSelected ;
    }

    public void pickPrimeFilter () {
        if (primeFilterXiaomi.isDisplayed()) {
            core.clickTo(primeFilterXiaomi,5);
            Log.pass("Selected Prime Filter");
        } else {Log.fail("Prime filter not selected");}
    }

    public boolean isPrimeSelected () {
        boolean isPrimeSelected = false ;
        if (xiaomiCheckbox.isSelected()) isPrimeSelected = true ;
        return isPrimeSelected ;
    }

    public void pickPowerbankFromList () {
        if (xiaomiProductLink.isDisplayed()) {
            core.clickTo(xiaomiProductLink,5);
            Log.pass("Selected power bank from list");
        }else Log.fail("Power bank not selected ");
    }
}
