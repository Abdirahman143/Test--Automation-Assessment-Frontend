package com.ncba.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage {
    private WebDriver driver;
    @FindBy(xpath = "//a[@href='/' and contains(., 'Home')]\n")
    private WebElement homepageLink;
    @FindBy(css = "a[href='/test_cases']")
    private WebElement testCasesButton;
    @FindBy(xpath = "//b[text()='Test Cases']")
    private WebElement testCasesHeader;


    public TestCasesPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isHomePageVisible() {
        try {
            return homepageLink.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void clickTestCasesButton() {
        testCasesButton.click();
    }

    public boolean isOnTestCasesPage() {
        return testCasesHeader.isDisplayed();
    }
}
