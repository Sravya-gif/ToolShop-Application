package com.srm.utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    public static ExtentReports getInstance() {

        if (extent == null) {

            new java.io.File("reports").mkdirs();
            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("reports/ExtentReport.html");

            reporter.config().setReportName("Automation Report");
            reporter.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Sravya");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}