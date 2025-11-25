package com.example.tests.web.steps;

import org.openqa.selenium.By;
import com.example.tests.web.pages.HomePage;
import com.example.tests.web.pages.ProductPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class WebSteps {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private ProductPage productPage;

    @Given("I open the demoblaze home page")
    public void openHome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize browser
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        homePage = new HomePage(driver);
        homePage.open();
    }

    @When("I open the first product")
    public void openFirstProduct() {
        homePage.openFirstProduct();
        // Inisialisasi productPage setelah membuka produk
        productPage = new ProductPage(driver);
    }

    @When("I add it to the cart")
    public void addToCart() {
        productPage.addToCart();
    }

    @Then("the product should be present in the cart")
    public void verifyInCart() {
        // Tunggu dan klik cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur"))).click();

        // Verifikasi ada produk di cart (tunggu element cart loaded)
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".success-msg, .table tbody tr")
        ));

        assertTrue(driver.findElement(By.tagName("body")).getText().contains("Product") ||
                driver.findElement(By.tagName("body")).getText().contains("Delete"));

        driver.quit();
    }

    // Hooks untuk cleanup
    @io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}