package com.ncba.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchProductPage {
    private WebDriver driver;
    @FindBy(id = "search_product")
    private WebElement searchInput;
    @FindBy(id = "submit_search")
    private  WebElement searchBtn;
    @FindBy(xpath = "//div[@class='productinfo text-center']/h2")
    private WebElement productPrice;



    public SearchProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    //search product by Product name
    public  void enterProductName(String name){
        searchInput.clear();
        searchInput.click();
        searchInput.sendKeys(name);

    }

    public void clickSearchIcon(){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));

        searchBtn.click();
    }

    public boolean IsSearchedProductVisible(){
        try{
            return productPrice.isDisplayed();
        }catch (NoSuchElementException e){
            return  false;
        }

    }


}
