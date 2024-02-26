package com.company.automation.tests;

import com.company.automation.pages.HomePage;
import com.company.automation.pages.SearchResultPage;
import com.company.automation.utils.WebDriverManagerUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class WebstaurantStoreTest {

    private WebDriver driver;
    private HomePage homePage;
    private SearchResultPage searchResultPage;

    @Before
    public void setUp() {
        System.out.println("Setting up the test environment...");
        driver = WebDriverManagerUtil.setupChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @Test
    public void testProductSearchAndAddToCart() {
        System.out.println("Step 1: Navigating to Home Page...");
        homePage.navigateTo("https://www.webstaurantstore.com/");
        System.out.println("Successfully navigated to Home Page.");

        System.out.println("Step 2: Searching for 'stainless work table'...");
        homePage.searchFor("stainless work table");
        System.out.println("Search completed.");

        System.out.println("Step 3: Verifying product titles contain 'Table'...");
        Assert.assertTrue("Not all product titles contain 'Table'", searchResultPage.verifyProductTitlesContain("Table"));
        System.out.println("Verification successful: All product titles contain 'Table'.");

        System.out.println("Step 4: Adding the last item from the last page to the Cart...");
        searchResultPage.addLastItemFromLastPageToCart();
        System.out.println("Last item added to the cart successfully.");

        System.out.println("Step 5: Emptying the cart and verifying it's empty...");
        searchResultPage.emptyCartAndVerify();
        System.out.println("Cart is emptied and verified successfully.");
    }

    @After
    public void tearDown() {
        System.out.println("Tearing down the test environment...");
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Test environment cleaned up successfully.");
    }
}
