package com.ncba.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage {
    private WebDriver driver;
    @FindBy(css = "a[href='/test_cases']")
    private WebElement testCasesButton;
    @FindBy(xpath = "//b[text()='Test Cases']")
    private WebElement testCasesHeader;


    public TestCasesPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }




    public void clickTestCasesButton() {
        testCasesButton.click();
    }

    public boolean isOnTestCasesPage() {
        return testCasesHeader.isDisplayed();
    }
}
