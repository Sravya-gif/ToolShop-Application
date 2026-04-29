package com.srm.tests;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority=1)
    public void verifyValidLogin() {

        LoginPage login = new LoginPage(driver);
        login.openLogin();
        login.login("sravya@gmail.com", "AlahariSravya@11");
        Assert.assertTrue(login.isLoginSuccessful(),
                "Login failed - My Account page not displayed");
    }

}