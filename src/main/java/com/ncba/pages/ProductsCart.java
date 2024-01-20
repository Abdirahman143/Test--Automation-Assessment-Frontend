package com.ncba.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ProductsCart {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    @FindBy(css = "div.productinfo.text-center")
    private WebElement firstProduct;

    @FindBy(css = "div.productinfo.text-center a.add-to-cart[data-product-id='1']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[contains(@class, 'btn-success') and contains(text(), 'Continue Shopping')]")
    private WebElement continueShoppingButton;
    @FindBy(css = "a[href='/view_cart']")
    private WebElement viewCartLink;
    @FindBy(css = "button.disabled")
    private WebElement quantityButton;

    @FindBy(className = "cart_total_price")
    private WebElement totalPriceElement;

    public ProductsCart(WebDriver driver)
    {
        this.driver =driver;
        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    public void hoverOverFirstProductAndAddToCart() {
        action.moveToElement(firstProduct).perform();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

    public void clickContinueButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", continueShoppingButton);
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();

    }

    public void clickViewCart() {
        viewCartLink.click();
    }
    public String IsProductsAddedToCart() {
        return quantityButton.getText();
    }
    public String getTotalPriceText() {
        return totalPriceElement.getText();
    }

    }
