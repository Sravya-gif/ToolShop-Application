package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By cart = By.cssSelector("[data-test='nav-cart']");
    private By product = By.cssSelector(".product-title");
    private By checkout = By.cssSelector("[data-test='proceed-1']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCart() {
        waitForElement(cart).click();
    }

    public boolean isProductDisplayed() {
        return waitForElement(product).isDisplayed();
    }

    public CheckoutPage goCheckout() {
        waitForElement(checkout).click();
        return new CheckoutPage(driver);
    }
}