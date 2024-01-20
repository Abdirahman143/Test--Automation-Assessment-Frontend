package com.ncba.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SubscriptionPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//h2[text()='Subscription']")
    private WebElement subscriptionHeader;
    @FindBy(id = "susbscribe_email")
    private WebElement email_input;
    @FindBy(id = "subscribe")
    private WebElement subscribeBtn;


    public SubscriptionPage(WebDriver driver){
        this.driver =driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    public void scrollToSubscription() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subscriptionHeader);
        boolean isSubscriptionVisible = subscriptionHeader.isDisplayed();

    }
    public boolean isSubscriptionTitleDisplayed(){
        return subscriptionHeader.isDisplayed();
    }
    public void subscribeToNewsletter(String email) {
        email_input.clear();
        email_input.click();
        email_input.sendKeys(email);

        subscribeBtn.click();
    }
    public boolean verifySuccessMessage() {
        try {
            WebElement successMessage = wait.until(ExpectedConditions.
                    visibilityOfElementLocated(By.xpath("//*[contains(text(), 'You have been successfully subscribed!')]")));
            return successMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
