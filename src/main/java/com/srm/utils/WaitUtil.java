package com.srm.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

    WebDriver driver;
    public WaitUtil(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        return wait.until(d -> d.findElement(locator));
    }

    public WebElement waitForClickable(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        return wait.until(d -> {
            WebElement ele = d.findElement(locator);
            if (ele.isDisplayed() && ele.isEnabled()) {
                return ele;
            }
            return null;
        });
    }

    public String waitForToastMessage() {

        By toast = By.cssSelector(".alert-success, .alert-danger");
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        try {
            WebElement element = wait.until(driver -> {
                WebElement el = driver.findElement(toast);
                if (el.isDisplayed() && !el.getText().isEmpty()) {
                    return el;
                }
                return null;
            });

            return element.getText();

        } catch (Exception e) {
            return "";
        }
    }
}