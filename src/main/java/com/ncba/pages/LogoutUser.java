package com.ncba.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutUser {
    private WebDriver driver;
    @FindBy(css = "a[href='/logout']")
    private WebElement logoutButton;

    public LogoutUser(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void clickLogoutButton() {
        logoutButton.click();
    }
}
