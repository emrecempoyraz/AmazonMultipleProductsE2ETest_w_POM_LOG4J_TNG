package TestClass;

import PageObjects.*;
import TestManager.BaseTest;
import TestManager.ConfigReader;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonMultipleProductsTest extends BaseTest {


    HomePage homePage ;
    ProductsPage productsPage ;

    ProductDetailPage productDetailPage ;
    BackHomePage bhp ;
    ProductsPage2 productsPage2 ;
    Product2DetailPage product2DetailPage ;
    CartPage cartPage ;

    @Description("AMAZONE2ETESTWMULTIPLESEARCH")
    @Test(priority = 1 ,description = "Search product on searchbar")
    public void searchProductOnHomePage () {
        homePage = new HomePage(driver);
        driver.get(ConfigReader.getProperty("baseUrl"));
        homePage.acceptCookies();
        homePage.searchProductOnSearchBar();
        Assert.assertTrue(homePage.isSearchCompleted(),"Product Search is successfull");
    }

    @Description("Filter product features")
    @Test(priority = 2 , description = "Filter product details",dependsOnMethods = "searchProductOnHomePage")
    public void filterProductNeeds () {
        productsPage = new ProductsPage(driver);
        productsPage.pickPrimeFilter();
        Assert.assertTrue(productsPage.isPrimeSelected(),"Not selected to prime");
        productsPage.pickHpBrandFilter();
        Assert.assertTrue(productsPage.isHPSelected(),"Not Selected HP checkbox");
    }

    @Description("Pick laptop from product list")
    @Test(priority = 3 , description = "Pick Laptop",dependsOnMethods = "filterProductNeeds")
    public void laptopSelection () {
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        productsPage.pickLaptopFromList();
        Assert.assertTrue(productDetailPage.isLaptopClicked(),"Cant find to product description");
    }

    @Description("Add laptop to cart")
    @Test (priority = 4 , description = "add laptop to cart" , dependsOnMethods = "laptopSelection")
    public void addProductToCart () {
        productDetailPage = new ProductDetailPage(driver) ;
        productDetailPage.addLaptopToCart();
        Assert.assertTrue(productDetailPage.isLaptopAddedToCart(),"product not added to cart");
    }

    @Description("Go back to Homepage")
    @Test (priority = 5,description = "back to Homepage" , dependsOnMethods = "addProductToCart")
    public void backToHomePage () {
        productDetailPage.backToHomePage();
        Assert.assertTrue(productDetailPage.isBackToHomePage(),"Not back to homepage");
    }

    @Description("Search 2nd product on Searchbar")
    @Test(priority = 6,description = "search power bank",dependsOnMethods = "backToHomePage")
    public void searchPowerbank () {
        bhp = new BackHomePage(driver);
        bhp.searchProduct2_OnSearchBar();
        Assert.assertTrue(bhp.isSearchCompleted(),"Product not found");
    }

    @Description("Filter power bank options")
    @Test(priority = 7,description = "filter power bank",dependsOnMethods = "searchPowerbank")
    public void filterPowerbank () {
        productsPage2 = new ProductsPage2(driver);
        productsPage2.pickPrimeFilter();
        Assert.assertTrue(productsPage2.isPrimeSelected(),"Prime not selected for Xiaomi");
        productsPage2.pickXiaomiBrandFilter();
        Assert.assertTrue(productsPage2.isXiaomiSelected(),"Xiaomi is not selected");
    }

    @Description("Choose power bank from product list")
    @Test (priority = 8,description = "choose power bank" , dependsOnMethods = "filterPowerbank")
    public void choosePowerbank () {
        productsPage2 = new ProductsPage2(driver);
        product2DetailPage = new Product2DetailPage(driver);
        productsPage2.pickPowerbankFromList();
        Assert.assertTrue(product2DetailPage.isProduct2Selected());
    }

    @Description("Add Powerbank to cart")
    @Test (priority = 9,description = "add power bank to cart" , dependsOnMethods = "choosePowerbank")
    public void addToCartPowerbank () {
        product2DetailPage = new Product2DetailPage(driver);
        product2DetailPage.addPowerbankToCart();
        Assert.assertTrue(product2DetailPage.isPowerbankAddedToCart(),"Power bank not added to cart");
    }

    @Description("Go to cart page")
    @Test(priority = 10,description = "Go to cart",dependsOnMethods = "addToCartPowerbank")
    public void goToCart () {
        product2DetailPage = new Product2DetailPage(driver);
        cartPage = new CartPage(driver);
        product2DetailPage.goToCart();
        Assert.assertTrue(cartPage.isOnCartPage(),"Not on cart page");
    }

}
