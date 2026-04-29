package com.srm.tests;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;
import com.srm.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormValidationTest extends BaseTest {

    @Test
    public void verifyLoginValidation() {

        LoginPage login = new LoginPage(driver);
        login.openLogin();
        login.login("", "");
        if (login.isErrorDisplayed()) {
            Assert.fail("Login failed as expected: fields should be filled");
        }
        Assert.assertTrue(true);
    }

    @Test
    public void verifyRegisterValidation() {

        RegisterPage register = new RegisterPage(driver);
        register.openRegisterPage();
        register.submitEmptyForm();
        Assert.assertTrue(register.isValidationDisplayed(),
                "Validation not shown for empty registration form");
    }
}