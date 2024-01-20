package com.ncba.testPages;

import com.ncba.base.TestBase;
import com.ncba.pages.ContactUs;
import com.ncba.pages.LoginUser;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class TC6_ContactUsTest extends TestBase {
    private ContactUs contactUs;

    @BeforeTest(description = "Launch browser and Navigate to Url")
    public void setUpBrowserAndLoadHomePage(){
        browser();
        setUp();
        contactUs = new ContactUs(driver);
    }

    @Test(priority = 1, description = "Verify that home page is visible successfully")
    public void testHomePageVisibility() {
        assertTrue(contactUs.isHomePageVisible(), "Home page is not visible");
    }
    @Test(priority = 2, description = "Click on 'Contact Us' button")
    public void clickContactUsButton(){
        contactUs.clickContactUsLink();
    }

    @Test(priority = 3, description = "Verify 'GET IN TOUCH' is visible")
    public void isGetInTouchTextIsVisible(){
        assertTrue(contactUs.isHomePageVisible(), "Home page is not visible.");
    }


    @Test(priority = 4, description = "Enter name, email, subject and message")
    public void enterContactDetails(){
        // Enter details in the contact form
        contactUs.enterName("Abdirahman");
        contactUs.enterEmail("abdirahma.test@test.com");
        contactUs.enterSubject("Test Automation Report");
        contactUs.enterMessage("This is the body of the message");
    }




    @Test(priority = 5, description = "Upload file")
    public void uploadFile() throws InterruptedException {
        String relativePath = "src/main/java/com/ncba/config/images/TestImage.png";
        File file = new File(relativePath);
        if (!file.exists()) {
            throw new IllegalArgumentException("File not found at " + file.getAbsolutePath());
        }
        String absolutePath = file.getAbsolutePath();

        contactUs.uploadFile(absolutePath);
        Thread.sleep(10);

    }
    @Test(priority = 6, description = "Click 'Submit' button")
    public void clickSubmitButton(){
        contactUs.clickSubmitButton();
    }
    @Test(priority = 7, description = "Click OK button")
    public void clickOkayOnTheAlert(){
        contactUs.acceptAlert();
    }
    @Test(priority = 8, description = "Verify success message 'Success! Your details have been submitted successfully.' is visible")
    public void iSuccessMessageSDisplayed(){
        assertTrue(contactUs.isSuccessMessageDisplayed(), "Success message is not displayed after form submission.");

    }

    @Test(priority = 9, description = "Click 'Home' button and verify that landed to home page successfully")
    public void clickHomeButtonToNavigateBackToHomePage(){
        contactUs.clickHomeButton();
      assertTrue(contactUs.isHomePageVisible(), "Did not return to home page successfully after submitting contact form.");
    }

}
