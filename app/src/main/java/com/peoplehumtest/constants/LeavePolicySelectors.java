package com.peoplehumtest.constants;

public class LeavePolicySelectors {
    // Navigation selectors
    public static final String ORGANIZATION_SETTINGS = "//a[contains(text(),'Organization settings')]";
    public static final String SEARCH_SETTINGS = "//input[@placeholder='Search settings']";
    public static final String LEAVE_CATEGORY_LINK = "//div[contains(text(),'Leave category')]";
    public static final String LEAVE_POLICY_LINK = "//div[contains(text(),'Leave policy')]";

    // Leave Category Creation
    public static final String NEW_LEAVE_CATEGORY_BUTTON = "//button[contains(.,'New leave category')]";
    public static final String CATEGORY_NAME_INPUT = "//input[@placeholder='Enter category name']";
    public static final String CATEGORY_CODE_INPUT = "//input[@placeholder='Enter Category code']";
    public static final String LEAVE_DESCRIPTION_INPUT = "//textarea[@placeholder='Enter leave description']";
    public static final String UPLOAD_IMAGE_BUTTON = "//input[@type='file' and @id='uploadBar']";
    public static final String UNPAID_LEAVE_TOGGLE = "//span[contains(text(), 'Unpaid leave')]";
    public static final String NEXT_STEP_BUTTON = "//span[text()='Next step']";
    public static final String SAVE_BUTTON = "//button[text()='Save']";

    // Success message

    public static final String  CATEGORY_SUCCESS_MESSAGE = "//*[contains(text(),'Leave category created successfully')]";

    // Leave Policy Creation
    public static final String NEW_LEAVE_POLICY_BUTTON = "//button[contains(.,'New leave policy')]";
    public static final String POLICY_NAME_INPUT = "//input[@placeholder='Enter leave policy name']";
    public static final String POLICY_DESCRIPTION_INPUT = "//textarea[@placeholder='Enter leave policy description']";
    public static final String CATEGORY_SELECT = "//div[contains(@class,'ng-select-container')]";
    public static final String CUSTOM_RADIO = "//span[contains(text(),'Custom')]";
    public static final String ACCRUAL_TYPE_SELECT = "(//span[text()='Accrual period']/following::div[contains(@class,'ng-select')])[1]";
    public static final String ACCRUAL_YEARLY_OPTION = "//span[contains(text(),'Yearly')]";
    public static final String ACCRUAL_LEAVE_COUNT = "//input[@name='accrualLeaveCount']";
    public static final String ACCRUAL_START_SELECT = "(//span[text()='Leave to be given on']/following::div[contains(@class,'ng-select')])[1]";
    public static final String START_OF_PERIOD_OPTION = "//span[contains(text(),'Start of Period')]";
    public static final String SIMULTANEOUS_LEAVE_INPUT = "//input[@name='numberOfSimultaneousLeave']";
    public static final String MANUAL_ADJUSTMENT_TOGGLE = "//span[contains(text(),'Yes, allow manual adjustments')]";
    public static final String MANAGER_ADD_TOGGLE = "//span[contains(text(),'Yes, allow manager to add leave for their reportees')]";
    public static final String RESTRICT_TOGGLE_TEXT = "//div[contains(text(),'Do you want to restrict submission of leave requests for past dates?')]/following-sibling::div//span[text()='No']";
    public static final String THRESHOLD_DAYS_INPUT = "//input[@placeholder='Enter number of days']";
    public static final String WEEKLY_TOGGLE = "//div[contains(text(),'Do you want to include weekly off between leave days in leave count?')]/following-sibling::div//span[text()='No']";
    public static final String WEEKLY_VALUE_INPUT = "//input[@placeholder='Enter a value']";
    public static final String HOLIDAY_TOGGLE = "//div[contains(text(),'Do you want to include holiday between leave days in leave count?')]/following-sibling::div//span[text()='No']";
    public static final String HOLIDAY_THRESHOLD_INPUT = "//input[@name='thresholdToIncludeHoliday']";
    public static final String POLICY_SUCCESS_MESSAGE = "//span[text()='Leave policy added successfully']";
}
