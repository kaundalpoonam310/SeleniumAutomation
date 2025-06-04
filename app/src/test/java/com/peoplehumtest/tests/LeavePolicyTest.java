package com.peoplehumtest.tests;

import com.peoplehumtest.models.LeavePolicyData;
import com.peoplehumtest.pages.LeavePolicyPage;
import com.peoplehumtest.pages.LoginPage;
import com.peoplehumtest.utils.ConfigReader;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.peoplehumtest.base.TestBase;

public class LeavePolicyTest extends TestBase {
    private LeavePolicyPage leavePolicyPage;
    private long testStartTime;

    @BeforeMethod
    public void setUpPage() {
        LoginPage loginPage = new LoginPage(driver);
        testStartTime = System.currentTimeMillis();
        loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());
        leavePolicyPage = new LeavePolicyPage(driver);
    }

    @Test
    public void testCreateLeavePolicy() {
        leavePolicyPage.clickProfileDropdown();
        leavePolicyPage.navigateToLeavePolicy();
        LeavePolicyData data = new LeavePolicyData(
                "SickPolicy19",
                "SickPolicy19 description",
                "SickCategory18",
                "12",
                "5",
                "12",
                "5",
                "5",
                "5",
                "5",
                "5"
        );
        leavePolicyPage.createLeavePolicy(data);
        Assert.assertTrue(leavePolicyPage.isPolicyCreatedSuccess(), "Policy created success message not found!");
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
