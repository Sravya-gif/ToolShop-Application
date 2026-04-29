package com.srm.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        try {
            String folderPath = "screenshots/";
            new File(folderPath).mkdirs();

            String timestamp = new SimpleDateFormat("yyyyMMdd").format(new Date());
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = folderPath + testName + "_" + timestamp + ".png";

            File dest = new File(path);
            Files.copy(src.toPath(), dest.toPath());
            
            return dest.getAbsolutePath();

        } catch (Exception e) {
            return null;
        }
    }
}