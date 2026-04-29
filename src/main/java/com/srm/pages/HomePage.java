package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By search = By.cssSelector("input[placeholder='Search']");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By homeLink = By.linkText("Home");
    public void goToHome() {
        waitForElement(homeLink).click();
    }
    
    public void searchProduct(String name) {
        waitForElement(search).sendKeys(name);
    }

    private By firstProduct = By.xpath("(//a[contains(@href,'product')])[1]");
    public ProductPage openFirstProduct() {
        waitForElement(firstProduct).click();
        return new ProductPage(driver);
    }
}