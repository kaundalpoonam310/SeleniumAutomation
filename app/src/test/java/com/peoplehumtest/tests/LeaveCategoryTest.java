package com.peoplehumtest.tests;

import com.peoplehumtest.models.LeaveCategoryData;
import com.peoplehumtest.pages.LeavePolicyPage;
import com.peoplehumtest.pages.LoginPage;
import com.peoplehumtest.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.peoplehumtest.base.TestBase;

public class LeaveCategoryTest extends TestBase {
    private LeavePolicyPage leavePolicyPage;
    private long testStartTime;

    @BeforeMethod
    public void setUpPage() {
        testStartTime = System.currentTimeMillis();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());
        leavePolicyPage = new LeavePolicyPage(driver);
    }

    @Test
    public void testCreateLeaveCategory() {
        leavePolicyPage.clickProfileDropdown();
        leavePolicyPage.navigateToLeaveCategory();
        LeaveCategoryData data = new LeaveCategoryData(
                "SickCategory20",
                "SickCategory20",
                "SickCategory20 description",
                "/Users/poonamkaundal/Documents/PeoplehumProjects/PeopleHumProjects/seleniumuiautomation/app/src/test/resources/Flag_of_the_Philippines.png",
                true
        );
        
        try {
            leavePolicyPage.createLeaveCategory(data);
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            Assert.fail("Test interrupted during leave category creation: " + e.getMessage());
        }
        
        Assert.assertTrue(leavePolicyPage.isCategoryCreatedSuccess(), "Category created success message not found!");
    }
    
    @AfterMethod
    public void tearDown() {
        long testEndTime = System.currentTimeMillis();
        long duration = testEndTime - testStartTime;
        System.out.println("Test execution time: " + duration + " ms");
        // Use BasePage's closeBrowser method to close the browser after each test
        if (leavePolicyPage != null) {
            leavePolicyPage.closeBrowser();
        } else if (driver != null) {
            driver.quit();
        }
    }
}
