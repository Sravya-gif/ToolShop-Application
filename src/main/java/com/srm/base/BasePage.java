package com.srm.base;

import com.srm.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtil waitUtil;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitUtil = new WaitUtil(driver);
    }

    public WebElement waitForElement(By locator) {
        return waitUtil.waitForElement(locator);
    }
}