package com.peoplehumtest.tests;

import com.peoplehumtest.models.LeavePolicyData;
import com.peoplehumtest.pages.LeavePolicyPage;
import com.peoplehumtest.pages.LoginPage;
import com.peoplehumtest.utils.ConfigReader;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.peoplehumtest.base.TestBase;

public class LeavePolicyTest extends TestBase {
    private LeavePolicyPage leavePolicyPage;

    @BeforeMethod
    public void setUpPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());
        leavePolicyPage = new LeavePolicyPage(driver);
    }

    @Test
    public void testCreateLeavePolicy() {
        leavePolicyPage.clickProfileDropdown();
        leavePolicyPage.navigateToLeavePolicy();
        LeavePolicyData data = new LeavePolicyData(
                "SickPolicy4",
                "SickPolicy4 description",
                "SickCategory1",
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
}
