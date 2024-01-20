package com.ncba.testPages;

import com.ncba.base.TestBase;
import com.ncba.pages.RegisterUser;
import com.ncba.utilityTest.CustomTestListener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.testng.Assert.*;
@Listeners(CustomTestListener.class)
public class TC1_RegisterUserTest extends TestBase {
    private RegisterUser registerUser;

    @BeforeTest(description = "Launch browser and Navigate to Url")
    public void setUpBrowserAndLoadHomePage(){
        browser();
        setUp();
        registerUser= new RegisterUser(driver);

    }

    @Test(priority = 1, description = "Verify that home page is visible successfully")
    public void testHomePageVisibility() {
        assertTrue(registerUser.isHomePageVisible(), "Home page is not visible");
    }

    @Test(priority = 2, description = "Click on 'Signup / Login' button")
    public void testClickSignUp() {
        registerUser.clickSignUp();
    }

    @Test(priority = 3,description = "Verify 'New User Signup!' is visible")
    public void testNewUserSignupVisibility() {
        assertThat(registerUser.isNewUserSignupVisible()).isTrue();
    }

    @Test(priority = 4,description = "Enter name and email address")
    public void testEnterUserNameAndEmail() {
        registerUser.enterUserName("Abdirahman");
        registerUser.enterEmail("abdirahman@test.com");

    }

    @Test(priority = 5,description = "Click 'Signup' button")
    public void testClickSignUpButton() {
        registerUser.clickSignUpButton();

    }

    @Test(priority = 6,description = "Verify that 'ENTER ACCOUNT INFORMATION' is visible")
    public void testEnterAccountInfoVisibility() {
        assertTrue(registerUser.isEnterAccountInfoVisible(), "Enter Account Information is not visible");
    }

    @Test(priority = 7,description = "Fill details: Title, Name, Email, Password, Date of birth")
    public void testFillDetails() throws InterruptedException {
        //title
        registerUser.selectTitle("Mr");
        //password
        registerUser.enterPassword("yourPassword123");
        //date of birth
        registerUser.selectDateOfBirth("1", "3", "1990");

    }



    @Test(priority = 8,description = "Select checkbox 'Sign up for our newsletter!'")
    public void testToggleNewsletter() {
        registerUser.toggleNewsletter(true);
    }

    @Test(priority = 9,description = "Select checkbox 'Receive special offers from our partners!'")
    public void testToggleReceiveOffers() {
        registerUser.toggleReceiveOffers(true);
    }

    @Test(priority = 10,description = "Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void testEnterAddressDetails() {
        registerUser.enterAddressDetails("Abdirahman", "Abdi", "Cellulant", "state house road", "Viena", "Canada", "Nairobi", "Nairobi", "23456", "0700816522");

    }

    @Test(priority = 11,description = "Click 'Create Account button'")
    public void testCreateAccount() {
        registerUser.createAccount();

    }

    @Test(priority = 12,description = "Verify that 'ACCOUNT CREATED!' is visible")
    public void testAccountCreatedVisibility() {
        assertTrue(registerUser.isAccountCreatedVisible(), "Account creation confirmation is not visible");
    }

    @Test(priority = 13,description = "Click 'Continue' button")
    public void testClickContinueButton() {
        registerUser.clickContinueButton();
    }

    @Test(priority = 14, description = "Verify that 'Logged in as username' is visible")
    public void testLoggedInTextVisibility() {
        assertThat(registerUser.isLoggedInTextVisible()).isTrue();
    }

    @Test(priority = 15,description = "Click 'Delete Account' button")
    public void testClickDeleteAccount() {
        registerUser.clickDeleteAccount();
    }

    @Test(priority = 16,description = "Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button")
    public void testAccountDeletedVisibility() {
       assertThat(registerUser.isAccountDeletedVisible()).isTrue();
    }


}
