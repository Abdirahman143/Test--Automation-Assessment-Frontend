package com.ncba.testPages;

import com.ncba.base.TestBase;
import com.ncba.pages.ContactUs;
import com.ncba.pages.TestCasesPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TC7_TestCasesTest extends TestBase {

    TestCasesPage testCasesPage;

    @BeforeTest(description = "Launch browser and Navigate to Url")
    public void setUpBrowserAndLoadHomePage(){
        browser();
        setUp();
        testCasesPage =new TestCasesPage(driver);

    }
    @Test(priority = 1, description = "Verify that home page is visible successfully")
    public void testHomePageVisibility() {
        assertTrue(testCasesPage.isHomePageVisible(), "Home page is not visible");
    }

    @Test(priority = 2, description = "Click on 'Test Cases' button")
    public void clickTestCasesButton(){
        testCasesPage.clickTestCasesButton();
    }

    @Test(priority = 3, description = "Verify user is navigated to test cases page successfully")
    public void isTestCasePageIsVisible(){
        testCasesPage.isOnTestCasesPage();
    }
}
