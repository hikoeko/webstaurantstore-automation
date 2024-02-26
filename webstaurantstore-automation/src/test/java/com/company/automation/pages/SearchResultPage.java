package com.company.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locator for product titles in search results
    private By productTitles = By.cssSelector(".description .title");

    // Locator for the 'Add to Cart' button of the last item
    private By addToCartButtonOfLastItem = By.xpath("(//input[@value='Add to Cart'])[last()]");

    // Locator for the 'View Cart' button
    private By viewCartButton = By.xpath("//a[contains(text(),'View Cart')]");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10); // 10 seconds timeout for explicit waits
    }
    public boolean verifyProductTitlesContain(String keyword) {
        List<WebElement> titles = driver.findElements(productTitles);
        for (WebElement title : titles) {
            if (!title.getText().contains(keyword)) {
                return false;
            }
        }
        return true;
    }
    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void addLastItemFromLastPageToCart() {
        // Navigate to the last page of search results
        WebElement lastPageButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='9']")));
        lastPageButton.click();

        WebElement selectType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[4]/div[1]/div[3]/div[60]/div[4]/form/div/select")));
        selectType.click();

        WebElement selectFirstElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[4]/div[1]/div[3]/div[60]/div[4]/form/div/select/option[2]")));
        selectFirstElement.click();

        // Add the last item on the last page to the cart
        List<WebElement> addToCartButtons = driver.findElements(addToCartButtonOfLastItem);
        addToCartButtons.get(addToCartButtons.size() - 1).click();
    }
    public void emptyCartAndVerify() {
        // Navigate to the cart
        WebElement viewCartButton = wait.until(ExpectedConditions.elementToBeClickable(this.viewCartButton));
        viewCartButton.click();

        // Delete all items in the cart
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[contains(@class, 'emptyCartButton')]"));
        for (WebElement button : deleteButtons) {
            button.click();
        }

        WebElement confirmEmptyCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='td']/div[11]/div/div/div/footer/button[1]")));
        confirmEmptyCart.click();

        // Verify the cart is empty
        WebElement emptyCartMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[1]/div[1]/div/div[2]/p[1]")));
        Assert.assertTrue("Your cart is empty.", emptyCartMessage.isDisplayed());
    }
}
