package com.peoplehumtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisteredEntityPage extends BasePage {
    
    @FindBy(css = "div.profile-pic-dropdown > .dropdown-toggle")
    private WebElement profileDropdown;
    
    @FindBy(xpath = "//a[contains(text(),'Organization settings')]")
    private WebElement organizationSettings;
    
    @FindBy(xpath = "//div[text()='Registered entity']")
    private WebElement registeredEntity;
    
    @FindBy(xpath = "//button[contains(text(),'New entity')]")
    private WebElement newEntityButton;
    
    @FindBy(xpath = "//button[contains(text(),' Upload Image')]")
    private WebElement uploadImageButton;
    
    @FindBy(css = "textarea[placeholder='Enter name']")
    private WebElement entityNameInput;
    
    @FindBy(css = "textarea[placeholder='Description']")
    private WebElement descriptionInput;
    
    @FindBy(xpath = "//div[contains(@class,'ng-select-container')][contains(.,'Select Currency')]")
    private WebElement currencySelect;
    
    @FindBy(css = "[role='combobox']")
    private WebElement currencyInput;
    
    @FindBy(css = "textarea[placeholder='Address line1']")
    private WebElement addressLine1Input;
    
    @FindBy(css = "textarea[placeholder='Address line2']")
    private WebElement addressLine2Input;
    
    @FindBy(xpath = "//div[contains(@class,'ng-select-container')][contains(.,'Select country')]")
    private WebElement countrySelect;
    
    @FindBy(xpath = "//div[contains(@class,'ng-select-container')][contains(.,'Select emirate')]")
    private WebElement emirateSelect;
    
    @FindBy(xpath = "//div[contains(@class,'ng-select-container')][contains(.,'Select city')]")
    private WebElement citySelect;
    
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    private WebElement addButton;
    
    @FindBy(css = "[aria-label='close']")
    private WebElement closeButton;
    
    @FindBy(xpath = "//div[contains(text(),'Registered entity added')]")
    private WebElement successMessage;

    public RegisteredEntityPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToRegisteredEntity() {
        click(profileDropdown);
        click(organizationSettings);
        click(registeredEntity);
    }

    public void createRegisteredEntity(String name, String description, String currency, 
                                     String addressLine1, String addressLine2, String country, 
                                     String emirate, String city) {
        // Click New Entity button
        click(newEntityButton);

        // Fill basic details
        sendKeys(entityNameInput, name);
        sendKeys(descriptionInput, description);

        // Select currency
        click(currencySelect);
        sendKeys(currencyInput, currency);
        click(driver.findElement(By.xpath("//div[contains(@class, 'ng-option')]//span[text()='" + currency + "']")));

        // Fill address details
        sendKeys(addressLine1Input, addressLine1);
        sendKeys(addressLine2Input, addressLine2);

        // Select country
        click(countrySelect);
        sendKeys(currencyInput, country);
        click(driver.findElement(By.xpath("//div[contains(@class, 'ng-option')]//span[text()='" + country + "']")));

        // Select emirate
        click(emirateSelect);
        click(driver.findElement(By.xpath("//text[contains(.,'" + emirate + "')]")));

        // Select city
        click(citySelect);
        wait.until(ExpectedConditions.elementToBeClickable(
            driver.findElement(By.cssSelector("div.ng-select-container:has-text('Select city') input[role='combobox']")))
        ).sendKeys(city);
        click(driver.findElement(By.xpath("//div[contains(@class,'ng-option')][contains(text(),'" + city + "')]")));

        // Click Add button
        click(addButton);

        // Wait for success message
        waitForElementToBeVisible(successMessage);

        // Close the dialog
        click(closeButton);
    }
}