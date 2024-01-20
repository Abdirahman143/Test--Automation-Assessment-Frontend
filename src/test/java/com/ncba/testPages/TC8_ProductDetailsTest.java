package com.ncba.testPages;

import com.ncba.base.TestBase;
import com.ncba.pages.Homepage;
import com.ncba.pages.ProductDetailsPage;
import com.ncba.pages.ProductPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TC8_ProductDetailsTest extends TestBase {
    ProductDetailsPage productDetailsPage;
    Homepage homepage;
    ProductPage productPage;


    @BeforeTest(description = "Launch browser and Navigate to Url")
    public void setUpBrowserAndLoadHomePage(){
        browser();
        setUp();
       productDetailsPage =new ProductDetailsPage(driver);
        homepage=new Homepage(driver);
        productPage=new ProductPage(driver);

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
        assertTrue(productDetailsPage.isOnAllProductsPage(), "Not navigated to the All Products page.");
    }

    @Test(priority = 4, description = "Click on 'View Product' of first product")
    public void clickViewProduct() {
          productDetailsPage.clickViewProduct();
    }
    @Test(priority = 5, description = "User is landed to product detail page")
    public void isProductDetailPageDisplayed(){
        assertTrue(productDetailsPage.isProductDetailReviewDisplayed(), "Product detail review is not displayed.");
    }
    @Test(priority = 6, description = "Verify that detail detail is visible: product name, category, price, availability, condition, brand")
    public void testProductDetailsVisibility() {
        assertTrue(productDetailsPage.isProductNameVisible(), "Product name is not visible");
      assertTrue(productDetailsPage.isProductCategoryVisible(), "Product category is not visible");
      assertTrue(productDetailsPage.isProductPriceVisible(), "Product price is not visible");
      assertTrue(productDetailsPage.isProductConditionVisible(), "Product condition is not visible");
      assertTrue(productDetailsPage.isProductAvailabilityVisible(), "Product availability is not visible");
      assertTrue(productDetailsPage.isProductBrandVisible(), "Product brand is not visible");
    }
}
