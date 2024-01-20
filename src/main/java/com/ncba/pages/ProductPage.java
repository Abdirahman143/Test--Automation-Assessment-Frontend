package com.ncba.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(css = "a[href='/products']")
    private WebElement productsBtn;
    @FindBy(xpath = "//h2[@class='title text-center' and contains(text(), 'All Products')]")
    private WebElement allProductsHeader;
    private WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }


    //click product button

    public void clickProductButton(){
        productsBtn.click();
    }

    public boolean isOnAllProductsPage() {
        try {
            return allProductsHeader.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
