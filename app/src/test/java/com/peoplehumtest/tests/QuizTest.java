package com.peoplehumtest.tests;

import org.testng.annotations.Test;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.peoplehumtest.base.TestBase;
import com.peoplehumtest.pages.LoginPage;
import com.peoplehumtest.pages.QuizPage;
import com.peoplehumtest.models.QuizData;
import com.peoplehumtest.utils.ConfigReader;

public class QuizTest extends TestBase {
    
    @Test(description = "Create a new quiz and verify its creation")
    public void createNewQuizTest() {
        // First login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());
        
        QuizPage quizPage = new QuizPage(driver);
        
        // Navigate to Quiz section
        quizPage.navigateToQuiz();
        
        // Generate a unique quiz name for testing
        String quizName = "Test Quiz " + System.currentTimeMillis();
        String quizDescription = "This is a test quiz description";
        
        // Create quiz data using builder pattern
        QuizData quizData = new QuizData.Builder()
            .withQuizName(quizName)
            .withQuizDescription(quizDescription)
            .withChooseTemplate("Basic Template")
            .withStartDate(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE))
            .withStartTime("10:00:00")
            .withEndDate(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE))
            .withEndTime("11:00:00")
            .withTimeLimitHours(1)
            .withTimeLimitMinutes(0)
            .withTimeLimitSeconds(0)
            .withUnlimitedAttempts(false)
            .withNumberOfAttempts("3")
            .withPassPercentage("60")
            .withDisplayResultToUsers(true)
            .withViewSubmittedResponses(true)
            .withRandomizeQuestions(true)
            .withRandomizeOptions(true)
            .withInviteApplicability("People View")
            .withAddUsers(Arrays.asList("g1 Google User 1"))
            .build();
        
        // Create the quiz
        quizPage.createQuiz(quizData);
        
        // Add assertions as needed
    }
}
