package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private By addToCartBtn = By.cssSelector("[data-test='add-to-cart']");
    private By cartBadge = By.cssSelector("[data-test='cart-quantity']");
    private By wishlistBtn = By.cssSelector("[data-test='add-to-favorites']");
    private By toastMsg = By.cssSelector(".alert-success, .alert-danger");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        waitUtil.waitForClickable(addToCartBtn).click();
    }

    public boolean isAddToCartSuccess() {
        try {
            String msg = waitUtil.waitForToastMessage().toLowerCase();
            return msg.contains("added");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isProductAlreadyInCart() {
        try {
            return Integer.parseInt(waitForElement(cartBadge).getText()) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public void addToWishlist() {
        waitUtil.waitForClickable(wishlistBtn).click();
    }

    public String getWishlistMessage() {
        String msg = waitUtil.waitForToastMessage();
        return msg.toLowerCase().trim();
    }
  
    public boolean isWishlistUnauthorized(String message) {
        return message.contains("unauthorized");
    }

    public boolean isWishlistAddedOrExists(String message) {
        message = message.toLowerCase().trim();
        return message.contains("Product added to your favorites list.")
                || message.contains("Product already in your favorites list.");
    }
}