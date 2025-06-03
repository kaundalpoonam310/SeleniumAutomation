package com.peoplehumtest.constants;

public class QuizSelectors {
    public static final String EMAIL_INPUT = "//input[@type='email']";
    public static final String PASSWORD_INPUT = "//input[@type='password']";
    public static final String SIGN_IN_BUTTON = "//button[@type='submit']";
    public static final String ENGAGE_PILLAR = "//a[@id='engageModules']/parent::li";
    public static final String QUIZ_MENU_ITEM = "//span[@class='menu-text' and contains(text(),'Quiz')]";
    public static final String QUIZ_LIST = "//a[contains(text(),'Quiz List')]";
    public static final String NEW_QUIZ_BUTTON = "//button[normalize-space()='New Quiz']";
    public static final String PROCEED_BUTTON = "//button[normalize-space()='Proceed']";
    public static final String QUIZ_NAME_INPUT = "//input[@placeholder='Enter a unique quiz name']";
    public static final String QUIZ_DESCRIPTION_INPUT = "//textarea[@placeholder='Enter template description']";
    public static final String TEMPLATE_NAME_INPUT = "//span[text()='Type ahead to select a quiz template']";
    public static final String START_DATE_INPUT = "//span[text()='Start Date']/parent::label/following-sibling::input";
    public static final String START_TIME_INPUT = "//span[text()='Start Time']/parent::label/following-sibling::input";
    public static final String END_DATE_INPUT = "//span[text()='End Date']/parent::label/following-sibling::input";
    public static final String END_TIME_INPUT = "//span[text()='End Time']/parent::label/following-sibling::input";
    public static final String HOURS_INPUT = "//input[@name='hours']";
    public static final String MINUTES_INPUT = "//input[@name='minutes']";
    public static final String SECONDS_INPUT = "//input[@name='seconds']";
    public static final String UNLIMITED_ATTEMPTS_LABEL = "//label[text()='Unlimited Attempts']";
    public static final String NUMBER_OF_ATTEMPTS_INPUT = "//input[@name='number_of_attempt']";
    public static final String PASS_PERCENTAGE_INPUT = "//span[contains(text(), ' correct answers required')]/preceding-sibling::input";
    public static final String DISPLAY_RESULT_YES = "//span[text()='Do you want to display the result of the quiz to the users?']/parent::div/descendant::label[text()='Yes']";
    public static final String VIEW_SUBMITTED_RESPONSES_END = "//span[text()='Do you want the users to view their submitted responses for the quiz?']/parent::div/descendant::label[text()='End of quiz']";
    public static final String RANDOMIZE_QUESTIONS_YES = "//span[text()='Do you want to randomize the order of quiz questions?']/parent::div/descendant::label[text()='Yes']";
    public static final String RANDOMIZE_OPTIONS_YES = "//span[text()='Do you want to randomize the order of options for all questions?']/parent::div/descendant::label[text()='Yes']";
    public static final String PEOPLE_VIEW_LABEL = "//label[text()='People View']";
    public static final String TEAM_VIEW_LABEL = "//label[text()='Team View']";
    public static final String SELECT_TYPE_SPAN = "//span[text()='Select Type']";
    public static final String TYPE_DROPDOWN = "//span[contains(@class,'ui-select-choices-row-inner')]/child::div[contains(text(),'Type')]";
    public static final String SEARCH_PEOPLE_INPUT = "//input[@placeholder='Type ahead to search users']";
    public static final String SEARCH_JOB_FUNCTION_INPUT = "//input[@placeholder='Search by Job Function']";
    public static final String SEARCH_TEAM_INPUT = "//input[@placeholder='Type Team Name']";
}
