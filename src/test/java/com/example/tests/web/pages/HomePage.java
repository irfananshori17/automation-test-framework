package com.example.tests.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By firstProduct = By.cssSelector(".card-title a");
    private By productLink = By.cssSelector(".hrefch"); // Alternatif selector yang lebih spesifik

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://www.demoblaze.com/");
    }

    public void openFirstProduct() {
        // Tunggu sampai element clickable
        WebElement product = wait.until(
                ExpectedConditions.elementToBeClickable(firstProduct)
        );
        product.click();
    }
}