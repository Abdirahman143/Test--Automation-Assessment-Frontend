package com.ncba.utilityTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {
private  final static Logger logger = LoggerFactory.getLogger(CustomTestListener.class);
    @Override
    public void onTestStart(ITestResult result) {
        // This will be executed when a test method starts.
        logger.info("Test Started: " + getTestDescription(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // This will be executed when a test method finishes successfully.

        logger.info("Test Passed: " + getTestDescription(result));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // This will be executed when a test method fails.
        logger.info("Test Failed: " + getTestDescription(result));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // This will be executed when a test method is skipped.
        logger.info("Test Skipped: " + getTestDescription(result));
    }

    @Override
    public void onStart(ITestContext context) {
        // This will be executed before the start of all tests in the <test> tag in testng.xml.
        logger.info("Starting Test: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // This will be executed after all tests in the <test> tag in testng.xml have run.
       logger.info("Finished Test: " + context.getName());
    }

    private String getTestDescription(ITestResult result) {
        String description = result.getMethod().getDescription();
        return (description != null) ? description : result.getMethod().getMethodName();
    }


}
