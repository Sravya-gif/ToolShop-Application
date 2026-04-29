package com.srm.tests;

import com.srm.base.BaseTest;
import com.srm.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

	@Test
	public void verifyCheckoutFlow() {

	    LoginPage login = new LoginPage(driver);
	    login.openLogin();
	    login.login("sravya@gmail.com", "AlahariSravya@11");

	    Assert.assertTrue(login.isLoginSuccessful(),
	            "Login failed");

	    HomePage home = new HomePage(driver);
	    home.goToHome();

	    ProductPage product = home.openFirstProduct();
	    product.addToCart();

	    CartPage cart = new CartPage(driver);
	    cart.openCart();

	    CheckoutPage checkout = cart.goCheckout();
	    checkout.clickProceedIfLoggedIn();
	    checkout.enterHouseNumber("11-82");
	    checkout.proceedToPayment();
	    checkout.selectCashOnDelivery();
	    checkout.clickFirstConfirm();       
	    checkout.waitForPaymentSuccess();   
	    checkout.clickSecondConfirm();      

	    Assert.assertTrue(checkout.isOrderSuccess(),
	            "Order not successful");
	}
}