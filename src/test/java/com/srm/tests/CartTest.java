package com.srm.tests;

import com.srm.base.BaseTest;
import com.srm.pages.CartPage;
import com.srm.pages.HomePage;
import com.srm.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void verifyAddToCart() {

        HomePage home = new HomePage(driver);
        ProductPage product = home.openFirstProduct();
        product.addToCart();
        CartPage cart = new CartPage(driver);
        cart.openCart();
        Assert.assertTrue(cart.isProductDisplayed(),
                "Product not present in cart");
    }
}