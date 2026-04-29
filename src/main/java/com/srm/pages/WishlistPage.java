package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePage {

    private By wishlistIcon = By.cssSelector("[data-test='nav-favorites']");
    private By productCards = By.cssSelector(".card");
    private By emptyMsg = By.xpath("//*[contains(text(),'No favorites')]");

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public void openWishlist() {
        waitUtil.waitForClickable(wishlistIcon).click();
    }

    public boolean isProductPresent() {
        try {
            return driver.findElements(productCards).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isWishlistEmpty() {
        try {
            return driver.findElements(emptyMsg).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public String getWishlistMessage() {
        String message = "";
        for (int i = 0; i < 15; i++) {   

            if (driver.findElements(By.cssSelector(".alert-success")).size() > 0) {
                message = driver.findElement(By.cssSelector(".alert-success")).getText();
                break;
            }

            if (driver.findElements(By.cssSelector(".alert-danger")).size() > 0) {
                message = driver.findElement(By.cssSelector(".alert-danger")).getText();
                break;
            }
        }
        return message.toLowerCase().trim();
    }
   public boolean isWishlistValid() {
        return isProductPresent() || isWishlistEmpty();
    }
}