package com.ncba.testPages;

import com.ncba.base.TestBase;
import com.ncba.pages.Homepage;
import com.ncba.pages.ProductDetailsPage;
import com.ncba.pages.ProductPage;
import com.ncba.pages.SearchProductPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC9_SearchProductTest extends TestBase {
    private ProductPage productPage;
    private SearchProductPage searchProductPage;
    private  Homepage homepage;

    @BeforeTest(description = "Launch browser and Navigate to Url")
    public void setUpBrowserAndLoadHomePage(){
        browser();
        setUp();
        homepage =new Homepage(driver);
        productPage = new ProductPage(driver);
        searchProductPage = new SearchProductPage(driver);

    }

    @Test(priority = 1, description = "Verify that home page is visible successfully")
    public void testHomePageVisibility() {
        assertTrue(homepage.isHomePageVisible(), "Home page is not visible");
    }

    @Test(priority = 2, description = "Click on 'Products' button")
    public void clickProductButton(){
        productPage.clickProductButton();
    }

    @Test(priority = 3, description = "Verify user is navigated to ALL PRODUCTS page successfully")
    public void isUserOnAllProductsPage(){
        assertTrue(productPage.isOnAllProductsPage(), "Not navigated to the All Products page.");
    }

    @Test(priority = 4, description = "Enter product name in search input and click search button")
    public void enterProductName(){
        searchProductPage.enterProductName("Men Tshirt");
        searchProductPage.clickSearchIcon();
    }

    @Test(priority = 5, description = "Verify 'SEARCHED PRODUCTS' is visible")
    public void IsSearchedProductVisible(){
        assertTrue(searchProductPage.IsSearchedProductVisible(),  "Searched Product does not exist");
    }
}
