package com.ncba.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscriptionCartPage {

    private WebDriver driver;
    @FindBy(css = "a[href='/view_cart']")
    private WebElement cartLink;

    public SubscriptionCartPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public void clickCartLink() {
        cartLink.click();
    }
}
