package com.ncba.testPages;

import com.ncba.base.TestBase;
import com.ncba.pages.Homepage;
import com.ncba.pages.SubscriptionCartPage;
import com.ncba.pages.SubscriptionPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TC11_SubscriptionCartTest extends TestBase {
    private  Homepage homepage;
    private SubscriptionPage subscriptionPage;
    private SubscriptionCartPage subscriptionCartPage;

    @BeforeTest(description = "Launch browser and Navigate to Url")
    public void setUpBrowserAndLoadHomePage(){
        browser();
        setUp();
        homepage =new Homepage(driver);
        subscriptionPage = new SubscriptionPage(driver);
        subscriptionCartPage =new SubscriptionCartPage(driver);

    }

    @Test(priority = 1, description = "Verify that home page is visible successfully")
    public void testHomePageVisibility() {
        assertTrue(homepage.isHomePageVisible(), "Home page is not visible");
    }

    @Test(priority = 2,description = "Click 'Cart' button")
    public void clickCartButton(){
        subscriptionCartPage.clickCartLink();
    }

    @Test(priority = 3,description = " Scroll down to footer")
    public void scrollToSubscription() {
        subscriptionPage.scrollToSubscription();
    }

    @Test(priority = 4, description = "")
    public void isSubscriptionTitleDisplayed(){
        assertTrue(subscriptionPage.isSubscriptionTitleDisplayed());
    }
    @Test(priority = 5,description = "Enter email address in input and click arrow button")
    public void enterEmailAndClickSubscribe() {
        subscriptionPage.subscribeToNewsletter("abdi@test.com");
    }

    @Test(priority = 6, description = "Verify success message 'You have been successfully subscribed!' is visible")
    public void verifySuccessMessage(){
        assertTrue(subscriptionPage.verifySuccessMessage());
    }

}
