package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By loginLink = By.linkText("Sign in");
    private By email = By.id("email");
    private By password = By.id("password");
    private By errorMsg = By.cssSelector(".alert-danger");
    private By accountName = By.xpath("//*[contains(text(),'Sravya SRM')]");
    private By myAccountHeader = By.xpath("//h1[contains(text(),'My account')]");

    public boolean isLoginSuccessful() {
        return waitForElement(myAccountHeader).isDisplayed();
    }
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLogin() {
        waitForElement(loginLink).click();
    }

    public void login(String e, String p) {
        waitForElement(email).sendKeys(e);
        waitForElement(password).sendKeys(p);
        waitForElement(loginBtn).click();
    }
    
    private By loginBtn = By.cssSelector("input[type='submit']");
    public boolean isLoginPageDisplayed() {
        return waitForElement(loginBtn).isDisplayed();
    }

    public boolean isErrorDisplayed() {
        try {
            return waitForElement(errorMsg).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isErrorMessageCorrect() {
        try {
            String text = waitForElement(errorMsg).getText();
            return text.contains("Invalid");
        } catch (Exception e) {
            return false;
        }
    }
}