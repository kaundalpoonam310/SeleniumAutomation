package com.peoplehumtest.models;

public class LeavePolicyData {
    private String name;
    private String description;
    private String categoryName;
    private String accrualCount;
    private String simultaneousLeaveCount;
    private String thresholdDays;
    private String weeklyValue;
    private String holidayThreshold;
    private String leaveLimit;
    private String minLeaveCount;
    private String atLeastDays;

    public LeavePolicyData(String name, String description, String categoryName, String accrualCount, String simultaneousLeaveCount, String thresholdDays, String weeklyValue, String holidayThreshold, String leaveLimit, String minLeaveCount, String atLeastDays) {
        this.name = name;
        this.description = description;
        this.categoryName = categoryName;
        this.accrualCount = accrualCount;
        this.simultaneousLeaveCount = simultaneousLeaveCount;
        this.thresholdDays = thresholdDays;
        this.weeklyValue = weeklyValue;
        this.holidayThreshold = holidayThreshold;
        this.leaveLimit = leaveLimit;
        this.minLeaveCount = minLeaveCount;
        this.atLeastDays = atLeastDays;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getCategoryName() { return categoryName; }
    public String getAccrualCount() { return accrualCount; }
    public String getSimultaneousLeaveCount() { return simultaneousLeaveCount; }
    public String getThresholdDays() { return thresholdDays; }
    public String getWeeklyValue() { return weeklyValue; }
    public String getHolidayThreshold() { return holidayThreshold; }
    public String getLeaveLimit() { return leaveLimit; }
    public String getMinLeaveCount() { return minLeaveCount; }
    public String getAtLeastDays() { return atLeastDays; }
}
