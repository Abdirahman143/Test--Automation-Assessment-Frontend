package com.ncba.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(css = "a[href='/products']")
    private WebElement productsBtn;

    private WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }


    //click product button

    public void clickProductButton(){
        productsBtn.click();
    }
}
