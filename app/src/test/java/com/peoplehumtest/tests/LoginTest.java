package com.peoplehumtest.tests;

import com.peoplehumtest.base.TestBase;
import com.peoplehumtest.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    
    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test@example.com", "password123");
        
        // Add assertions here once you have implemented the dashboard page
    }
}
