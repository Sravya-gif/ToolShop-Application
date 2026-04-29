package com.srm.tests;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;
import com.srm.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

	@Test
	public void verifySuccessfulRegistration() {

	    RegisterPage register = new RegisterPage(driver);
	    register.openRegisterPage();
	    String email = "sravya1"+ "@gmail.com";
	    register.registerUser("Sravya", "SRM", email);
	    LoginPage login = new LoginPage(driver);
	    Assert.assertTrue(login.isLoginPageDisplayed(),
	            "Registration failed - Login page not displayed");
	}
	
	
}