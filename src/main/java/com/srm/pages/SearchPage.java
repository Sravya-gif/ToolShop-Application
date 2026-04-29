package com.srm.pages;

import com.srm.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    private By searchBox = By.cssSelector("input[placeholder='Search']");
    private By productResults = By.cssSelector(".card");
    private By noResults = By.xpath("//*[contains(text(),'No results')]");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String productName) {
        waitForElement(searchBox).clear();
        waitForElement(searchBox).sendKeys(productName);
    }

    public boolean isResultsDisplayed() {
        return waitForElement(productResults).isDisplayed();
    }

    public boolean isNoResultsDisplayed() {
        try {
            return waitForElement(noResults).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}