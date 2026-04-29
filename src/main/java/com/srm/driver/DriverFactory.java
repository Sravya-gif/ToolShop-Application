package com.srm.driver;

import com.srm.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        String browser = ConfigReader.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            if (ConfigReader.isHeadless()) {
                options.addArguments("--headless=new");
            }
            driver.set(new ChromeDriver(options));

        } else {

            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            if (ConfigReader.isHeadless()) {
                options.addArguments("--headless");
            }
            driver.set(new FirefoxDriver(options));
        }
        getDriver().manage().window().maximize();
        getDriver().get(ConfigReader.getBaseUrl());
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        getDriver().quit();
    }
}