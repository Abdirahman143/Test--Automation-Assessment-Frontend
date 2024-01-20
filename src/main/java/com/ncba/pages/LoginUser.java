package com.ncba.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginUser {
    private WebDriver driver;
    @FindBy(xpath = "//a[@href='/' and contains(., 'Home')]\n")
    private WebElement homepageLink;
    @FindBy(xpath = "//a[contains(@href, 'login') and contains(text(), 'Signup / Login')]\n")
    WebElement loginButtonLink;
    @FindBy(xpath = "//h2[text()='Login to your account']")
    private WebElement loginToYourAccountHeader;
    @FindBy(css = "input[data-qa='login-email']")
    private WebElement loginEmailInput;
    @FindBy(css = "input[data-qa='login-password']")
    private WebElement loginPasswordInput;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[contains(text(), 'Your email or password is incorrect!') and contains(@style, 'color: red;')]")
    private WebElement loginErrorMessage;

    @FindBy(xpath = "//a[contains(., 'Logged in as') and .//b]")
    private WebElement loggedInText;

    public LoginUser(WebDriver driver){
        this.driver =driver;

        PageFactory.initElements(driver, this);
    }


    //verify home page is loaded
    public boolean isHomePageVisible() {
        try {
            return homepageLink.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }




    // 'Sign Up / Login' button
    public void clickLoginButtonLik() {
        loginButtonLink.click();
    }


    public boolean isLoginHeaderVisible() {
        try {
            return loginToYourAccountHeader.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void enterLoginEmail(String email) {


        loginEmailInput.clear();
        loginEmailInput.click();
        loginEmailInput.sendKeys(email);

    }
    public void enterLoginPassword(String password){
      loginPasswordInput.clear();
      loginPasswordInput.click();
      loginPasswordInput.sendKeys(password);

    }
    public void clickLoginButton() {
        loginButton.click();
    }
    public boolean isLoginErrorMessageDisplayed() {
        try {
            return loginErrorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isLoggedInTextVisible() {
        try {
            return loggedInText.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
