package com.peoplehumtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import com.peoplehumtest.constants.QuizSelectors;
import com.peoplehumtest.models.QuizData;

public class QuizPage extends BasePage {
    @FindBy(xpath = QuizSelectors.ENGAGE_PILLAR)
    private WebElement engagePillar;

    @FindBy(xpath = QuizSelectors.QUIZ_MENU_ITEM)
    private WebElement quizMenuItem;

    @FindBy(xpath = QuizSelectors.QUIZ_LIST)
    private WebElement quizList;

    @FindBy(xpath = QuizSelectors.NEW_QUIZ_BUTTON)
    private WebElement newQuizButton;

    @FindBy(xpath = QuizSelectors.PROCEED_BUTTON)
    private WebElement proceedButton;

    @FindBy(xpath = QuizSelectors.QUIZ_NAME_INPUT)
    private WebElement quizNameInput;

    @FindBy(xpath = QuizSelectors.QUIZ_DESCRIPTION_INPUT)
    private WebElement quizDescriptionInput;
    WebDriverWait wait;

    public QuizPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
         wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void navigateToQuiz() {
        hoverOnElement(engagePillar);
        waitForElementToBeClickable(quizMenuItem);
        click(quizMenuItem);
        waitForURLContains("quiz");
        waitForElementToBeClickable(quizList);
        click(quizList);
        waitForPageLoad();
    }

    public void createQuiz(QuizData quiz) {
        wait.until(ExpectedConditions.elementToBeClickable(newQuizButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(proceedButton)).click();
        wait.until(ExpectedConditions.visibilityOf(quizNameInput)).sendKeys(quiz.getQuizName());
        waitForElementToBeVisible(quizDescriptionInput);
        sendKeys(quizDescriptionInput, quiz.getQuizDescription());

        // Template selection logic
        WebElement templateDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Type ahead to select a quiz template']")));
        templateDropdown.click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Type ahead to select a quiz template']"))).sendKeys("Basic Template");
        
        WebElement templateOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Basic Template')]")));
        templateOption.click();

        scrollByJust10();
        // Set dates and times
        WebElement startDateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QuizSelectors.START_DATE_INPUT)));
        startDateInput.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            // Optionally log or handle the exception
        }
        scrollIntoViewAndClick(By.xpath("//button[text()='Today']"));

        WebElement startTimeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QuizSelectors.START_TIME_INPUT)));
        startTimeInput.click();
        scrollIntoViewAndClick(By.xpath("//button[text()='Now']"));

        WebElement endDateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QuizSelectors.END_DATE_INPUT)));
        endDateInput.click();
        java.util.List<WebElement> todayButtons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='15']")));
        if (!todayButtons.isEmpty()) {
            todayButtons.get(0).click();
        }

        WebElement endTimeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QuizSelectors.END_TIME_INPUT)));
        endTimeInput.click();
        java.util.List<WebElement> nowButtons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='Now']")));
        if (!nowButtons.isEmpty()) {
            nowButtons.get(0).click();
        }

        // Time limit
        WebElement hoursInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QuizSelectors.HOURS_INPUT)));
        sendKeys(hoursInput, String.valueOf(quiz.getTimeLimitHours()));
        WebElement minutesInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QuizSelectors.MINUTES_INPUT)));
        sendKeys(minutesInput, String.format("%02d", quiz.getTimeLimitMinutes()));
        WebElement secondsInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QuizSelectors.SECONDS_INPUT)));
        sendKeys(secondsInput, String.valueOf(quiz.getTimeLimitSeconds()));

        // Pass percentage
        WebElement passPercentageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QuizSelectors.PASS_PERCENTAGE_INPUT)));
        sendKeys(passPercentageInput, quiz.getPassPercentage());

        // Unlimited attempts or number of attempts
        if (quiz.isUnlimitedAttempts()) {
            WebElement unlimitedAttemptsLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(QuizSelectors.UNLIMITED_ATTEMPTS_LABEL)));
            click(unlimitedAttemptsLabel);
        } else if (quiz.getNumberOfAttempts() != null) {
            WebElement numberOfAttemptsInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QuizSelectors.NUMBER_OF_ATTEMPTS_INPUT)));
            scrollIntoView(numberOfAttemptsInput);
            sendKeys(numberOfAttemptsInput, quiz.getNumberOfAttempts());
        }

        // Display options
        if (quiz.isDisplayResultToUsers()) {
            WebElement displayResultYes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(QuizSelectors.DISPLAY_RESULT_YES)));
            click(displayResultYes);
        }
        if (quiz.isViewSubmittedResponses()) {
            WebElement viewSubmittedResponsesEnd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(QuizSelectors.VIEW_SUBMITTED_RESPONSES_END)));
            click(viewSubmittedResponsesEnd);
        }
        if (quiz.isRandomizeQuestions()) {
            WebElement randomizeQuestionsYes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(QuizSelectors.RANDOMIZE_QUESTIONS_YES)));
            click(randomizeQuestionsYes);
        }
        if (quiz.isRandomizeOptions()) {
            WebElement randomizeOptionsYes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(QuizSelectors.RANDOMIZE_OPTIONS_YES)));
            click(randomizeOptionsYes);
        }
        
        WebElement Users = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QuizSelectors.SEARCH_PEOPLE_INPUT)));
        scrollIntoView(Users);
        sendKeys(Users, "Google user 1");
        WebElement spanUser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Google User 1']")));
        spanUser.click();

        // Click Create button
        WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Create']")));
        click(createButton);
    }
}
