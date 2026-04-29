package com.srm.listener;

import com.aventstack.extentreports.*;
import com.srm.driver.DriverFactory;
import com.srm.utils.ExtentManager;
import com.srm.utils.ScreenshotUtil;
import org.testng.*;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String path = ScreenshotUtil.captureScreenshot(
                DriverFactory.getDriver(),
                result.getName()
        );

        if (path != null) {
            test.get().fail(result.getThrowable())
                    .addScreenCaptureFromPath(path);
        } else {
            test.get().fail("Screenshot capture failed");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}