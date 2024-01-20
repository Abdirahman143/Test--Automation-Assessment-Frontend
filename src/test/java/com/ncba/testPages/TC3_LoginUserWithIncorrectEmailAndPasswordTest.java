package com.ncba.testPages;

import com.ncba.base.TestBase;
import com.ncba.pages.LoginUser;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TC3_LoginUserWithIncorrectEmailAndPasswordTest extends TestBase {
    LoginUser loginUser;

    @BeforeTest(description = "Launch browser and Navigate to Url")
    public void setUpBrowserAndLoadHomePage(){
        browser();
        setUp();
        loginUser= new LoginUser(driver);
    }

    @Test(priority = 1, description = "Verify that home page is visible successfully")
    public void testHomePageVisibility() {
        assertTrue(loginUser.isHomePageVisible(), "Home page is not visible");
    }

    @Test(priority = 2, description = "Click on 'Signup / Login' button")
    public void testClickLoginLik() {
        loginUser. clickLoginButtonLik();
    }
@Test(priority = 3,description = "Verify 'Login to your account' is visible")
public void IsLoginHeaderIsVisible(){
  assertTrue(loginUser.isLoginHeaderVisible(), "Login header is not visible.");

}

@Test(priority = 4, description = "Enter incorrect email address and password")
public void enterEmailAndPassword(){
loginUser.enterLoginEmail("bashir@gmail.com");
loginUser.enterLoginPassword("1234567");
}

@Test(priority = 5, description = "Click 'login' button")
    public void clickLoginButton(){
        loginUser.clickLoginButton();
}

@Test(priority = 6, description = "Verify error 'Your email or password is incorrect!' is visible")
    public void isLoginErrorMessageIsDisplayed(){
  assertTrue(loginUser.isLoginErrorMessageDisplayed(), "Error message for invalid login is not displayed.");
}


}
