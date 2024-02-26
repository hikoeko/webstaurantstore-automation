package com.company.automation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManagerUtil {

    public static WebDriver setupChromeDriver() {
        // Use WebDriverManager to manage ChromeDriver setup
        WebDriverManager.chromedriver().setup();

        // Initialize and return a single ChromeDriver instance
        return new ChromeDriver();
    }
}