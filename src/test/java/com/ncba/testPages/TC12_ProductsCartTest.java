package com.ncba.testPages;

import com.ncba.base.TestBase;
import com.ncba.pages.Homepage;
import com.ncba.pages.ProductDetailsPage;
import com.ncba.pages.ProductPage;
import com.ncba.pages.ProductsCart;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC12_ProductsCartTest extends TestBase {
  private  ProductPage productPage;
  private Homepage homepage;
  private ProductsCart productsCart;

    @BeforeTest(description = "Launch browser and Navigate to Url")
    public void setUpBrowserAndLoadHomePage(){
        browser();
        setUp();
        productsCart = new ProductsCart(driver);
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

    @Test(priority = 3, description = "Hover over first product and click 'Add to cart'")
    public void hoverOverFirstProductAndAddToCart() {
        productsCart.hoverOverFirstProductAndAddToCart();
    }

    @Test(priority = 4,description = " Click 'Continue Shopping' button")
    public void clickContinueButton(){
        productsCart.clickContinueButton();
    }

    @Test(priority = 5,description = "Hover over second product and click 'Add to cart'")
    public void hoverOverSecondProductAndAddToCart() {
        productsCart.hoverOverFirstProductAndAddToCart();
    }

    @Test(priority = 6, description = "Click 'View Cart' button")
    public void clickViewCart() {
        productsCart.clickViewCart();
    }
    @Test(priority = 7,description = "Verify both products are added to Cart")
    public void IsProductsAddedToCart() {
        assertEquals(productsCart.IsProductsAddedToCart(),"2","Quantity text does not match expected value");
    }
    @Test(priority = 8,description = "Verify their prices, quantity and total price")
    public void getTotalPriceText() {
        assertEquals(productsCart.getTotalPriceText(),"Rs. 1000", "Total price text does not match expected value.");
    }



   }
