package com.peoplehumtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    
    @FindBy(name = "user_name")
    private WebElement emailInput;
    
    @FindBy(css = "input[type='password']")
    private WebElement passwordInput;
    
    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        // Wait for login form to be present and fill in credentials
        waitForElementToBeVisible(emailInput);
        sendKeys(emailInput, email);
        sendKeys(passwordInput, password);
        click(loginButton);
    }
    
    private void waitForLoginToComplete() {
        // Wait for login to process
        try {
            // First wait for login button to disappear
            wait.until(ExpectedConditions.invisibilityOf(loginButton));
            
            // Then wait for either the dashboard content or any error message
            wait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector(".dashboard-content")),
                ExpectedConditions.presenceOfElementLocated(By.cssSelector(".main-navigation")),
                ExpectedConditions.presenceOfElementLocated(By.cssSelector(".error-message"))
            ));
            
            // If there's an error message, throw an exception
            WebElement errorMessage = driver.findElement(By.cssSelector(".error-message"));
            if (errorMessage.isDisplayed()) {
                throw new RuntimeException("Login failed: " + errorMessage.getText());
            }
            
            // Add a small delay to ensure the page is fully loaded
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Login wait was interrupted", e);
        }
    }
}
