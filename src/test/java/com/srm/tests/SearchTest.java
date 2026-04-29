package com.srm.tests;

import com.srm.base.BaseTest;
import com.srm.pages.HomePage;
import com.srm.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void verifySearchResults() {

        HomePage home = new HomePage(driver);
        SearchPage search = new SearchPage(driver);
        search.searchProduct("Hammer");
        Assert.assertTrue(search.isResultsDisplayed(),
                "Search results not displayed");
    }

    @Test
    public void verifyNoResultsSearch() {

        SearchPage search = new SearchPage(driver);
        search.searchProduct("invalidproductxyz");
        Assert.assertTrue(search.isNoResultsDisplayed(),
                "No result message not shown");
    }
}