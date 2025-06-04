package com.peoplehumtest.pages;

import com.peoplehumtest.constants.LeavePolicySelectors;
import com.peoplehumtest.models.LeaveCategoryData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;

public class LeavePolicyPage extends BasePage {
    public LeavePolicyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickProfileDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'profile-pic-dropdown')]"))).click();
    }

    public void navigateToLeaveCategory() {
        // Assumes already logged in and on dashboard
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.ORGANIZATION_SETTINGS))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeavePolicySelectors.SEARCH_SETTINGS))).sendKeys("Leave");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.LEAVE_CATEGORY_LINK))).click();
    }

    public void createLeaveCategory(LeaveCategoryData data) throws InterruptedException {
        // Wait for and click New Leave Category
        
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        // Removed stray closing brace here

        WebElement newButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.NEW_LEAVE_CATEGORY_BUTTON)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", newButton);
        newButton.click();

        // Fill form
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeavePolicySelectors.CATEGORY_NAME_INPUT))).sendKeys(data.getName());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeavePolicySelectors.CATEGORY_CODE_INPUT))).sendKeys(data.getCode());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeavePolicySelectors.LEAVE_DESCRIPTION_INPUT))).sendKeys(data.getDescription());

        // Upload image if provided
        if (data.getImagePath() != null && !data.getImagePath().isEmpty()) {
            Thread.sleep(1000);
            WebElement uploadInput = driver.findElement(By.xpath(LeavePolicySelectors.UPLOAD_IMAGE_BUTTON));
            File file = new File(data.getImagePath());
            uploadInput.sendKeys(file.getAbsolutePath());
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(LeavePolicySelectors.NEXT_STEP_BUTTON)).click();

        // Unpaid leave toggle
        if (data.isUnpaidLeave()) {
            WebElement unpaidToggle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.UNPAID_LEAVE_TOGGLE)));
            unpaidToggle.click();
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.NEXT_STEP_BUTTON))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.SAVE_BUTTON))).click();
    }

    public boolean isCategoryCreatedSuccess() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeavePolicySelectors.CATEGORY_SUCCESS_MESSAGE))).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }



    public void navigateToLeavePolicy() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.ORGANIZATION_SETTINGS))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeavePolicySelectors.SEARCH_SETTINGS))).sendKeys("Leave");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.LEAVE_POLICY_LINK))).click();
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
        
    }

    public void createLeavePolicy(com.peoplehumtest.models.LeavePolicyData data) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.NEW_LEAVE_POLICY_BUTTON))).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (driver.findElements(By.xpath("(//button[normalize-space()='Proceed anyway'])[1]")).size() > 0) {
            try{
            Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
            }   
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Cancel'])[2]"))).click();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeavePolicySelectors.POLICY_NAME_INPUT))).sendKeys(data.getName());
        driver.findElement(By.xpath(LeavePolicySelectors.POLICY_DESCRIPTION_INPUT)).sendKeys(data.getDescription());

        // Select category
        WebElement categorySelect = driver.findElement(By.xpath(LeavePolicySelectors.CATEGORY_SELECT));
        categorySelect.click();
        WebElement categoryOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '" + data.getCategoryName() + "')]")));
        categoryOption.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeavePolicySelectors.NEXT_STEP_BUTTON))).click();
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
        System.out.println("Next Step");   
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeavePolicySelectors.NEXT_STEP_BUTTON))).click();
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
        System.out.println("Next Step"); 
        System.out.println("Custom button");  
        // Accrual Settings
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.CUSTOM_RADIO))).click();
        try
        {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }

        System.out.println("Accrual Type Select");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.ACCRUAL_TYPE_SELECT))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.ACCRUAL_YEARLY_OPTION))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.ACCRUAL_LEAVE_COUNT))).sendKeys(data.getAccrualCount());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.ACCRUAL_START_SELECT))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.START_OF_PERIOD_OPTION))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.SIMULTANEOUS_LEAVE_INPUT))).sendKeys(data.getSimultaneousLeaveCount());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.MANUAL_ADJUSTMENT_TOGGLE))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.MANAGER_ADD_TOGGLE))).click();
        try{Thread.sleep(100);} catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
        System.out.println("Next Step");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.NEXT_STEP_BUTTON))).click();
        try{Thread.sleep(500);} catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.NEXT_STEP_BUTTON))).click();
        try{Thread.sleep(500);} catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.NEXT_STEP_BUTTON))).click();
        try{Thread.sleep(500);} catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'form-group')]/following::span[contains(@class,'ph-icon-wrapper')])[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Cancel']"))).click();
        // Skipping ng-select dropdowns and cancel clicks for brevity
       
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.NEXT_STEP_BUTTON))).click();
        try{Thread.sleep(500);} catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }

         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'ng-input')]/following::span[contains(@class,'icon-ph')]/parent::span[contains(@class,'ph-icon')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Cancel']"))).click();

         try{Thread.sleep(500);} catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.NEXT_STEP_BUTTON))).click();
        // Configure additional settings
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.RESTRICT_TOGGLE_TEXT))).click();
         try{Thread.sleep(500);} catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.THRESHOLD_DAYS_INPUT))).sendKeys(data.getThresholdDays());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.WEEKLY_TOGGLE))).click();
         try{Thread.sleep(500);} catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.WEEKLY_VALUE_INPUT))).sendKeys(data.getWeeklyValue());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.HOLIDAY_TOGGLE))).click();
         try{Thread.sleep(500);} catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.HOLIDAY_THRESHOLD_INPUT))).sendKeys(data.getHolidayThreshold());
         try{Thread.sleep(500);} catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.NEXT_STEP_BUTTON))).click();
         try{Thread.sleep(500);} catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
        // Replaced Thread.sleep with explicit wait for the next step button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.NEXT_STEP_BUTTON))).click();
         try{Thread.sleep(500);} catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,\"form-group\")]/following::span[contains(@class,\"ph-icon-wrapper\")])[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Cancel']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.NEXT_STEP_BUTTON))).click();
         try{Thread.sleep(500);} catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.NEXT_STEP_BUTTON))).click();
         try{Thread.sleep(500);} catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LeavePolicySelectors.SAVE_BUTTON))).click();
    }

    public boolean isPolicyCreatedSuccess() {
        try {
            try{Thread.sleep(200);} catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LeavePolicySelectors.POLICY_SUCCESS_MESSAGE))).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
