package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    private By proceedStep2 = By.cssSelector("[data-test='proceed-2']");
    private By houseNumber = By.id("house_number");
    private By proceedStep3 = By.cssSelector("[data-test='proceed-3']");
    private By paymentDropdown = By.cssSelector("[data-test='payment-method']");
    private By confirmBtn = By.cssSelector("[data-test='finish']");
    private By paymentSuccess = By.xpath("//*[contains(text(),'Payment was successful')]");
    private By orderSuccess = By.xpath("//*[contains(text(),'Thanks for your order!')]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickProceedIfLoggedIn() {
        try {
            waitUtil.waitForClickable(proceedStep2).click();
        } catch (Exception ignored) {}
    }

    public void enterHouseNumber(String value) {
        WebElement ele = waitForElement(houseNumber);
        ele.clear();
        ele.sendKeys(value);
    }

    public void proceedToPayment() {
        waitUtil.waitForClickable(proceedStep3).click();
    }
 
    public void selectCashOnDelivery() {
        Select select = new Select(waitForElement(paymentDropdown));
        select.selectByVisibleText("Cash on Delivery");
    }

    public void clickFirstConfirm() {
        WebElement btn = waitUtil.waitForClickable(confirmBtn);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", btn);
        try {
            btn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", btn);
        }
    }

    public void waitForPaymentSuccess() {
        waitForElement(paymentSuccess);
    }

    public void clickSecondConfirm() {
        WebElement btn = waitUtil.waitForClickable(confirmBtn);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", btn);
        try {
            btn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", btn);
        }
    }

    public boolean isOrderSuccess() {
        return waitForElement(orderSuccess).isDisplayed();
    }
}