package com.peoplehumtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Set implicit wait globally for all pages
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        this.actions = new Actions(driver);
    }

    protected void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void click(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {
        waitForElementToBeVisible(element);
        return element.getText();
    }

    protected void hoverElement(WebElement element) {
        waitForElementToBeVisible(element);
        actions.moveToElement(element).perform();
    }

    protected void waitForURLContains(String urlPart) {
        wait.until(ExpectedConditions.urlContains(urlPart));
    }

    protected void waitForPageLoad() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
            .executeScript("return document.readyState").equals("complete"));
    }

    protected void hoverOnElement(WebElement element) {
        waitForElementToBeVisible(element);
        actions.moveToElement(element).perform();
    }

    /**
     * Scrolls the element into view (center) and clicks it.
     */
    public void scrollIntoViewAndClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        element.click();
    }

    public void scrollIntoView(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    public void scrollIntoView(WebElement element) {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }
    /**
     * Scrolls the page vertically by 10 pixels using JavaScript.
     */
    public void scrollByJust10() {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollBy(0, 50);");
    }
    /**
     * Dismisses the cookie consent bar if present by clicking the 'Dismiss' button.
     */
    protected void dismissCookieBarIfPresent() {
        try {
            org.openqa.selenium.By dismissButton = org.openqa.selenium.By.xpath("//button[text()='Dismiss']");
            WebElement button = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated(dismissButton));
            if (button.isDisplayed() && button.isEnabled()) {
                button.click();
            }
        } catch (org.openqa.selenium.TimeoutException e) {
            // Cookie bar not present, nothing to do
        }
    }

    /**
     * Closes the browser and quits the WebDriver instance.
     */
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
