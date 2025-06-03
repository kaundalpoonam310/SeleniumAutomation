package com.peoplehumtest.tests;

import com.peoplehumtest.base.TestBase;
import com.peoplehumtest.pages.LoginPage;
import com.peoplehumtest.pages.RegisteredEntityPage;
import org.testng.annotations.Test;

public class RegisteredEntityTest extends TestBase {
    
    @Test
    public void testCreateNewRegisteredEntity() {
        // First login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("payrollautomationgreythrtest@gmail.com", "Test@123");
        
        // Create new registered entity
        RegisteredEntityPage registeredEntityPage = new RegisteredEntityPage(driver);
        registeredEntityPage.navigateToRegisteredEntity();
        
        registeredEntityPage.createRegisteredEntity(
            "burhani1",               // name
            "burhani",                // description
            "UAE Dirham - AED",       // currency
            "ABC",                    // addressLine1
            "ANBC",                   // addressLine2
            "United Arab Emirates",    // country
            "Abu Dhabi Emirate",      // emirate
            "Abu Dhabi"               // city
        );
    }
}
