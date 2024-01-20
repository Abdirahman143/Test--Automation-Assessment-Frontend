package com.ncba.utilityTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports getReporter() {
        if (extent == null) {
            // Create an instance of ExtentSparkReporter
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-reports.html");
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("Automation Test Results");
            sparkReporter.config().setReportName("Automation Test Results");

            // Attach reporter
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }

    public static void startTest(String testName, String description) {
        test.set(getReporter().createTest(testName, description));
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void endTest() {
        getReporter().flush();
    }
}