package com.ncba.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RegisterUser {
    private WebDriver driver;

    @FindBy(xpath = "//a[@href='/' and contains(., 'Home')]\n")
    private WebElement homepageLink;
    @FindBy(xpath = "//a[contains(@href, 'login') and contains(text(), 'Signup / Login')]\n")
    private WebElement signUpButton;
    @FindBy(how = How.XPATH,using = "//h2[text()='New User Signup!']\n")
    private WebElement newUserTitle;
    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement nameInput;
    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement emailInput;
    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signupButton;
    @FindBy(xpath = "//b[text()='Enter Account Information']\n")
    private WebElement accountInfo;
    @FindBy(xpath = "//label[.//span/input[@type='radio' and @name='title' and @value='Mr']]\n")
    private WebElement gender1;
    @FindBy(css = "input[data-qa='name']")
    private WebElement name_textInput;
    @FindBy(css = "input[data-qa='email']")
    private WebElement email_textInput;
    @FindBy(css = "input[data-qa='password']")
    private WebElement password_textInput;
     @FindBy(css = "select[data-qa='days']")
    private WebElement daysDropdown;
    @FindBy(css = "select[data-qa='months']")
    private WebElement monthsDropdown;
    @FindBy(css = "select[data-qa='years']")
    private WebElement yearsDropdown;
    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;
    @FindBy(id = "optin")
    private WebElement receiveOffersCheckbox;
    @FindBy(css = "input[data-qa='first_name']")
    private WebElement firstName;
    @FindBy(css = "input[data-qa='last_name']")
    private WebElement lastName;
    @FindBy(css = "input[data-qa='company']")
    private WebElement company;
    @FindBy(css = "input[data-qa='address1']")
    private WebElement address1;
    @FindBy(css = "input[data-qa='address2']")
    private WebElement address2;

    @FindBy(css = "input[data-qa='country']")
    private WebElement countryDropDown;
    @FindBy(css = "input[data-qa='state']")
    private WebElement state;

    @FindBy(css = "input[data-qa='city']")
    private WebElement city;
    @FindBy(css = "input[data-qa='zipcode']")
    private WebElement zipcode;
    @FindBy(css = "input[data-qa='mobile_number']")
    private WebElement mobileNumber;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//b[text()='Account Created!']")
    private WebElement accountCreatedText;

    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement continueButton;
    @FindBy(xpath = "//a[contains(., 'Logged in as') and .//b]")
    private WebElement loggedInText;

    @FindBy(xpath = "//a[contains(@href, '/delete_account') and contains(text(), 'Delete Account')]")
    private WebElement deleteAccountLink;
    @FindBy(xpath = "//b[text()='Account Deleted!']")
    private WebElement accountDeletedText;

    public RegisterUser (WebDriver driver){
        this.driver = driver;
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
    public void clickSignUp() {
        signUpButton.click();
    }

    //verify user signup title
    public boolean isNewUserSignupVisible(){
        try {
            return newUserTitle.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //enter name
    public void enterUserName(String name) {
        nameInput.sendKeys(name);
    }

    // Enter email
    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    //click the 'Sign Up' button
    public void clickSignUpButton() {
        signupButton.click();
    }
//Verify that 'ENTER ACCOUNT INFORMATION' is visible
    public boolean isEnterAccountInfoVisible(){
        try {
            return accountInfo.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    //  select Title
    public void selectTitle(String gender) {
        if(gender.equalsIgnoreCase("Mr")) {
            gender1.click();
        }

    }

    // enter password
    public void enterPassword(String password) {
        password_textInput.clear();
        password_textInput.click();
        password_textInput.sendKeys(password);
    }

    //  select date of birth
    public void selectDateOfBirth(String day, String month, String year) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(daysDropdown));
        new Select(daysDropdown).selectByValue(day);

        wait.until(ExpectedConditions.visibilityOf(monthsDropdown));
        new Select(monthsDropdown).selectByValue(month);

        wait.until(ExpectedConditions.visibilityOf(yearsDropdown));
        new Select(yearsDropdown).selectByValue(year);
    }

    // check newsletter subscription
    public void toggleNewsletter(boolean subscribe) {
        if (subscribe != newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }
    }

    // check receive offers
    public void toggleReceiveOffers(boolean optIn) {
        if (optIn != receiveOffersCheckbox.isSelected()) {
            receiveOffersCheckbox.click();
        }
    }


    // enter address details
    public void enterAddressDetails(String firstName, String lastName, String company,
                                    String address1, String address2, String country,
                                    String state, String city, String zipcode,
                                    String mobileNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.company.sendKeys(company);
        this.address1.sendKeys(address1);
        this.address2.sendKeys(address2);

        wait.until(ExpectedConditions.visibilityOf(countryDropDown));
        new Select(countryDropDown).selectByVisibleText(country);
        this.state.sendKeys(state);
        this.city.sendKeys(city);
        this.zipcode.sendKeys(zipcode);
        this.mobileNumber.sendKeys(mobileNumber);
    }

    // click the 'Create Account' button
    public void createAccount() {
        createAccountButton.click();
    }

    //account created
    public boolean isAccountCreatedVisible() {
        try {
            return accountCreatedText.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    // click the 'Continue' button
    public void clickContinueButton() {
        continueButton.click();
    }
    //check if the logged-in text is visible
    public boolean isLoggedInTextVisible() {
        try {
            return loggedInText.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //click the 'Delete Account' link
    public void clickDeleteAccount() {
        deleteAccountLink.click();
    }
    //check if the 'Account Deleted!' text is visible
    public boolean isAccountDeletedVisible() {
        try {
            return accountDeletedText.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
