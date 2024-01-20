package com.ncba.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUs {
    private WebDriver driver;
    @FindBy(xpath = "//a[@href='/' and contains(., 'Home')]\n")
    private WebElement homepageLink;
    @FindBy(css = "a[href='/contact_us']")
    private WebElement contactUsLink;
    @FindBy(xpath = "//h2[contains(@class, 'title text-center') and text()='Get In Touch']")
    private WebElement getInTouchHeader;

    @FindBy(css = "input[data-qa='name']")
    private WebElement nameInput;

    @FindBy(css = "input[data-qa='email']")
    private WebElement emailInput;

    @FindBy(css = "input[data-qa='subject']")
    private WebElement subjectInput;

    @FindBy(css = "textarea[data-qa='message']")
    private WebElement messageTextArea;
    @FindBy(name = "upload_file")
    private WebElement fileUploadInput;

    @FindBy(css = "input[data-qa='submit-button']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[contains(@class, 'alert-success') and contains(text(), 'Success! Your details have been submitted successfully.')]")
    private WebElement successMessage;
    @FindBy(xpath = "//span[.//i[contains(@class, 'fa-angle-double-left')] and contains(text(), 'Home')]")
    private WebElement homeButton;
    public ContactUs(WebDriver driver){
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
    public void clickContactUsLink() {
        contactUsLink.click();
    }


    public boolean isGetInTouchHeaderVisible() {
        try {
            return getInTouchHeader.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void enterSubject(String subject) {
        subjectInput.clear();
        subjectInput.click();
        subjectInput.sendKeys(subject);
    }

    public void enterMessage(String message) {
        messageTextArea.clear();
        messageTextArea.click();
        messageTextArea.sendKeys(message);
    }


    public void uploadFile(String filePath) {
        fileUploadInput.sendKeys(filePath);
    }
    public void clickSubmitButton() {
        submitButton.click();
    }
    public void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept(); // Clicks the 'OK' button in the alert
    }
    public boolean isSuccessMessageDisplayed() {
        try {
            return successMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void clickHomeButton() {
        homeButton.click();
    }

}

