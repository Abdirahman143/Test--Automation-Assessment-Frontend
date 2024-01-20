package com.ncba.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
    private WebDriver driver;


    @FindBy(css = "a[href='/product_details/1']")
    private WebElement viewProductLink;
    @FindBy(css = "a[href='#reviews'][data-toggle='tab']")
    private WebElement writeReviewLink;

    @FindBy(xpath = "//h2[text()='Blue Top']")
    private WebElement productName;

    @FindBy(xpath = "//p[contains(text(), 'Category: Women > Tops')]")
    private WebElement productCategory;

    @FindBy(xpath = "//span[text()='Rs. 500']")
    private WebElement productPrice;

    @FindBy(xpath = "//b[contains(text(), 'Condition:')]")
    private WebElement productCondition;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]")
    private WebElement productAvailability;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]")
    private WebElement productBrand;

    public ProductDetailsPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }




    public void clickViewProduct() {
        viewProductLink.click();
    }
    public boolean isProductDetailReviewDisplayed() {
        try {
            return writeReviewLink.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isProductNameVisible() {
        return productName.isDisplayed();
    }

    public boolean isProductCategoryVisible() {
        return productCategory.isDisplayed();
    }

    public boolean isProductPriceVisible() {
        return productPrice.isDisplayed();
    }

    public boolean isProductConditionVisible() {
        return productCondition.isDisplayed();
    }

    public boolean isProductAvailabilityVisible() {
        return productAvailability.isDisplayed();
    }

    public boolean isProductBrandVisible() {
        return productBrand.isDisplayed();
    }

}
