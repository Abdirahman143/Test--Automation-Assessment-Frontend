package com.ncba.testPages;

import com.ncba.base.TestBase;
import com.ncba.pages.RegisterUser;
import com.ncba.utilityTest.CustomTestListener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

@Listeners(CustomTestListener.class)
public class TC5_RegisterUserWithExistingEmailTest extends TestBase {
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
        registerUser.enterEmail("abdirahman.wrong@test.com");

    }

    @Test(priority = 5,description = "Click 'Signup' button")
    public void testClickSignUpButton() {
        registerUser.clickSignUpButton();

    }
    @Test(priority = 6, description = "Verify error 'Email Address already exist!' is visible")
    public void testExistingEmailAddressError() {

        boolean isErrorDisplayed = registerUser.isEmailExistsErrorMessageVisible();
      assertTrue(isErrorDisplayed, "The error message for an existing email address is not displayed.");
    }


}
