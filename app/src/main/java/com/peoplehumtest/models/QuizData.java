package com.peoplehumtest.models;

import java.util.List;

public class QuizData {
    private String quizName;
    private String quizDescription;
    private String chooseTemplate;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private int timeLimitHours;
    private int timeLimitMinutes;
    private int timeLimitSeconds;
    private boolean unlimitedAttempts;
    private String numberOfAttempts;
    private String passPercentage;
    private boolean displayResultToUsers;
    private boolean viewSubmittedResponses;
    private boolean randomizeQuestions;
    private boolean randomizeOptions;
    private String inviteApplicability;
    private List<String> filterByType;
    private List<String> filterType;
    private List<String> addUsers;
    private List<String> addTeams;

    private QuizData(Builder builder) {
        this.quizName = builder.quizName;
        this.quizDescription = builder.quizDescription;
        this.chooseTemplate = builder.chooseTemplate;
        this.startDate = builder.startDate;
        this.startTime = builder.startTime;
        this.endDate = builder.endDate;
        this.endTime = builder.endTime;
        this.timeLimitHours = builder.timeLimitHours;
        this.timeLimitMinutes = builder.timeLimitMinutes;
        this.timeLimitSeconds = builder.timeLimitSeconds;
        this.unlimitedAttempts = builder.unlimitedAttempts;
        this.numberOfAttempts = builder.numberOfAttempts;
        this.passPercentage = builder.passPercentage;
        this.displayResultToUsers = builder.displayResultToUsers;
        this.viewSubmittedResponses = builder.viewSubmittedResponses;
        this.randomizeQuestions = builder.randomizeQuestions;
        this.randomizeOptions = builder.randomizeOptions;
        this.inviteApplicability = builder.inviteApplicability;
        this.filterByType = builder.filterByType;
        this.filterType = builder.filterType;
        this.addUsers = builder.addUsers;
        this.addTeams = builder.addTeams;
    }

    // Getters
    public String getQuizName() { return quizName; }
    public String getQuizDescription() { return quizDescription; }
    public String getChooseTemplate() { return chooseTemplate; }
    public String getStartDate() { return startDate; }
    public String getStartTime() { return startTime; }
    public String getEndDate() { return endDate; }
    public String getEndTime() { return endTime; }
    public int getTimeLimitHours() { return timeLimitHours; }
    public int getTimeLimitMinutes() { return timeLimitMinutes; }
    public int getTimeLimitSeconds() { return timeLimitSeconds; }
    public boolean isUnlimitedAttempts() { return unlimitedAttempts; }
    public String getNumberOfAttempts() { return numberOfAttempts; }
    public String getPassPercentage() { return passPercentage; }
    public boolean isDisplayResultToUsers() { return displayResultToUsers; }
    public boolean isViewSubmittedResponses() { return viewSubmittedResponses; }
    public boolean isRandomizeQuestions() { return randomizeQuestions; }
    public boolean isRandomizeOptions() { return randomizeOptions; }
    public String getInviteApplicability() { return inviteApplicability; }
    public List<String> getFilterByType() { return filterByType; }
    public List<String> getFilterType() { return filterType; }
    public List<String> getAddUsers() { return addUsers; }
    public List<String> getAddTeams() { return addTeams; }

    public static class Builder {
        private String quizName;
        private String quizDescription;
        private String chooseTemplate;
        private String startDate;
        private String startTime;
        private String endDate;
        private String endTime;
        private int timeLimitHours;
        private int timeLimitMinutes;
        private int timeLimitSeconds;
        private boolean unlimitedAttempts;
        private String numberOfAttempts;
        private String passPercentage;
        private boolean displayResultToUsers;
        private boolean viewSubmittedResponses;
        private boolean randomizeQuestions;
        private boolean randomizeOptions;
        private String inviteApplicability;
        private List<String> filterByType;
        private List<String> filterType;
        private List<String> addUsers;
        private List<String> addTeams;

        public Builder withQuizName(String quizName) { this.quizName = quizName; return this; }
        public Builder withQuizDescription(String quizDescription) { this.quizDescription = quizDescription; return this; }
        public Builder withChooseTemplate(String chooseTemplate) { this.chooseTemplate = chooseTemplate; return this; }
        public Builder withStartDate(String startDate) { this.startDate = startDate; return this; }
        public Builder withStartTime(String startTime) { this.startTime = startTime; return this; }
        public Builder withEndDate(String endDate) { this.endDate = endDate; return this; }
        public Builder withEndTime(String endTime) { this.endTime = endTime; return this; }
        public Builder withTimeLimitHours(int hours) { this.timeLimitHours = hours; return this; }
        public Builder withTimeLimitMinutes(int minutes) { this.timeLimitMinutes = minutes; return this; }
        public Builder withTimeLimitSeconds(int seconds) { this.timeLimitSeconds = seconds; return this; }
        public Builder withUnlimitedAttempts(boolean unlimited) { this.unlimitedAttempts = unlimited; return this; }
        public Builder withNumberOfAttempts(String attempts) { this.numberOfAttempts = attempts; return this; }
        public Builder withPassPercentage(String passPercentage) { this.passPercentage = passPercentage; return this; }
        public Builder withDisplayResultToUsers(boolean display) { this.displayResultToUsers = display; return this; }
        public Builder withViewSubmittedResponses(boolean view) { this.viewSubmittedResponses = view; return this; }
        public Builder withRandomizeQuestions(boolean randomize) { this.randomizeQuestions = randomize; return this; }
        public Builder withRandomizeOptions(boolean randomize) { this.randomizeOptions = randomize; return this; }
        public Builder withInviteApplicability(String applicability) { this.inviteApplicability = applicability; return this; }
        public Builder withFilterByType(List<String> filterByType) { this.filterByType = filterByType; return this; }
        public Builder withFilterType(List<String> filterType) { this.filterType = filterType; return this; }
        public Builder withAddUsers(List<String> addUsers) { this.addUsers = addUsers; return this; }
        public Builder withAddTeams(List<String> addTeams) { this.addTeams = addTeams; return this; }
        public QuizData build() { return new QuizData(this); }
    }
}
