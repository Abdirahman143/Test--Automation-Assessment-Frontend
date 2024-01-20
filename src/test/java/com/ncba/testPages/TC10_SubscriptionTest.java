package com.ncba.testPages;

import com.ncba.base.TestBase;
import com.ncba.pages.Homepage;
import com.ncba.pages.ProductPage;
import com.ncba.pages.SearchProductPage;
import com.ncba.pages.SubscriptionPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TC10_SubscriptionTest extends TestBase {
    Homepage homepage ;
    SubscriptionPage subscriptionPage;
    @BeforeTest(description = "Launch browser and Navigate to Url")
    public void setUpBrowserAndLoadHomePage(){
        browser();
        setUp();
        homepage =new Homepage(driver);
        subscriptionPage = new SubscriptionPage(driver);

    }

    @Test(priority = 1, description = "Verify that home page is visible successfully")
    public void testHomePageVisibility() {
        assertTrue(homepage.isHomePageVisible(), "Home page is not visible");
    }

    @Test(priority = 2,description = " Scroll down to footer")
    public void scrollToSubscription() {
        subscriptionPage.scrollToSubscription();
    }

    @Test(priority = 3, description = "")
    public void isSubscriptionTitleDisplayed(){
        assertTrue(subscriptionPage.isSubscriptionTitleDisplayed());
    }
    @Test(priority = 3,description = "Enter email address in input and click arrow button")
    public void enterEmailAndClickSubscribe() {
        subscriptionPage.subscribeToNewsletter("abdi@test.com");
    }

    @Test(priority = 4, description = "Verify success message 'You have been successfully subscribed!' is visible")
    public void verifySuccessMessage(){
        assertTrue(subscriptionPage.verifySuccessMessage());
    }
}
