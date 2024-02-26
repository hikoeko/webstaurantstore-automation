package com.company.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    // Locator for the search input field
    private By searchInput = By.id("searchval");

    // Locator for the search button
    private By searchButton = By.xpath("//button[@value='Search']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void searchFor(String searchTerm) {
        // Find the search input field and enter the search term
        WebElement searchInputField = driver.findElement(searchInput);
        searchInputField.clear();
        searchInputField.sendKeys(searchTerm);

        // Click the search button
        driver.findElement(searchButton).click();
    }
}