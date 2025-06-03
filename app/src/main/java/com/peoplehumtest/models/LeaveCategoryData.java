package com.peoplehumtest.models;

public class LeaveCategoryData {
    private String name;
    private String code;
    private String description;
    private String imagePath;
    private boolean isUnpaidLeave;

    public LeaveCategoryData(String name, String code, String description, String imagePath, boolean isUnpaidLeave) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.imagePath = imagePath;
        this.isUnpaidLeave = isUnpaidLeave;
    }

    public String getName() { return name; }
    public String getCode() { return code; }
    public String getDescription() { return description; }
    public String getImagePath() { return imagePath; }
    public boolean isUnpaidLeave() { return isUnpaidLeave; }
}
