package PageObjects;

import TestManager.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage{
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//i[@class='a-icon a-icon-checkbox'])[1]")
    private WebElement amazonPrimeFilter ;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    private WebElement amazonPrimeCheckBox;

    @FindBy(xpath = "(//i[@class='a-icon a-icon-checkbox'])[3]")
    private WebElement hpBrandFilter ;

    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    private WebElement hpBrandCheckBox;

    @FindBy (xpath = "(//a[@class='a-link-normal s-no-outline'])[2]")
    private WebElement laptopLocator ;


    public void pickPrimeFilter () {
        if (amazonPrimeFilter.isDisplayed()) {
            core.clickTo(amazonPrimeFilter,5);
            Log.pass("Selected Prime Filter");
        } else {Log.fail("Prime filter not selected");}
    }

    public void pickHpBrandFilter () {
        if (hpBrandFilter.isDisplayed()) {
            core.clickTo(hpBrandFilter,10);
            Log.pass("Selected Prime Filter");
        } else {Log.fail("Hp brand not selected");}
    }

    public void pickLaptopFromList () {
        if (laptopLocator.isDisplayed()) {
            core.clickTo(laptopLocator,5);
            Log.pass("Selected laptop from list");
        } else {Log.fail("Not selected laptop");}
    }


    public boolean isPrimeSelected () {
         boolean isPrimeSelected = false ;
         if (amazonPrimeCheckBox.isSelected()) isPrimeSelected = true ;
         return isPrimeSelected ;
    }

    public boolean isHPSelected () {
        boolean isHPSelected = false ;
        if (hpBrandCheckBox.isSelected()) isHPSelected = true ;
        return isHPSelected ;
    }


}
