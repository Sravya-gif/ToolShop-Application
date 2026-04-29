package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    private By signInLink = By.linkText("Sign in");
    private By registerLink = By.linkText("Register your account");
    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By dob = By.id("dob");
    private By country = By.id("country");
    private By postcode = By.id("postal_code");
    private By houseNo = By.id("house_number");
    private By street = By.id("street");
    private By city = By.id("city");
    private By state = By.id("state");
    private By phone = By.id("phone");
    private By email = By.id("email");
    private By password = By.id("password");
    private By registerBtn = By.cssSelector("[data-test='register-submit']");
    private By successMsg = By.cssSelector(".alert-success");
    private By errorMsg = By.cssSelector(".alert-danger");
    private By validation = By.cssSelector(".invalid-feedback");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void openRegisterPage() {
        waitForElement(signInLink).click();
        waitForElement(registerLink).click();
    }

    public void registerUser(String fName, String lName, String mail) {

        waitForElement(firstName).sendKeys(fName);
        waitForElement(lastName).sendKeys(lName);
        waitForElement(dob).sendKeys("2005-03-11");
        waitForElement(country).sendKeys("India");
        waitForElement(postcode).sendKeys("522034");
        waitForElement(houseNo).sendKeys("11-82");
        waitForElement(street).sendKeys("Venkateswara colony");
        waitForElement(city).sendKeys("Guntur");
        waitForElement(state).sendKeys("Andhra Pradesh");
        waitForElement(phone).sendKeys("9876543210");
        waitForElement(email).sendKeys(mail);
        waitForElement(password).sendKeys("AlahariSravya@11");
        waitForElement(registerBtn).click();
    }

    public boolean isRegistrationSuccess() {
        return waitForElement(successMsg).isDisplayed();
    }

    public boolean isErrorDisplayed() {
        return waitForElement(errorMsg).isDisplayed();
    }

    public void submitEmptyForm() {
        waitForElement(registerBtn).click();
    }
    
    public boolean isValidationDisplayed() {
        try {
            return driver.findElements(By.cssSelector(".invalid-feedback"))
                         .stream()
                         .anyMatch(e -> e.isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }
}