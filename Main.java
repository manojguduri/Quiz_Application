package com.project;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

// Question class to represent each quiz question
class Question {
    private String questionText;
    private String[] options;
    private char correctAnswer;

    public Question(String questionText, String[] options, char correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}

// Quiz class to manage quiz operations
class Quiz {
    private Question[] questions;
    private int currentQuestionIndex;
    private int score;
    private Timer timer;
    private boolean answered;

    public Quiz(Question[] questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
        this.timer = new Timer();
    }

    public void startQuiz() {
        displayNextQuestion();
    }

    private void displayNextQuestion() {
        if (currentQuestionIndex < questions.length) {
            Question currentQuestion = questions[currentQuestionIndex];
            System.out.println("\nQuestion " + (currentQuestionIndex + 1) + ": " + currentQuestion.getQuestionText());
            String[] options = currentQuestion.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((char) ('A' + i) + ". " + options[i]);
            }
            startTimer();
            waitForAnswer();
        } else {
            endQuiz();
        }
    }

    private void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!answered) {
                    System.out.println("\nTime's up! Moving to the next question.");
                    currentQuestionIndex++;
                    displayNextQuestion();
                }
            }
        }, 15000); // 15 seconds timer for each question
    }

    private void waitForAnswer() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine().toUpperCase();
        char selectedAnswer = answer.charAt(0);
        if (selectedAnswer >= 'A' && selectedAnswer < 'A' + questions[currentQuestionIndex].getOptions().length) {
            checkAnswer(selectedAnswer);
        } else {
            System.out.println("Invalid input. Please select a valid option.");
            waitForAnswer();
        }
        scanner.close();
    }

    private void checkAnswer(char selectedAnswer) {
        answered = true;
        Question currentQuestion = questions[currentQuestionIndex];
        if (selectedAnswer == currentQuestion.getCorrectAnswer()) {
            score++;
            System.out.println("Correct answer! Your current score: " + score);
        } else {
            System.out.println("Incorrect answer. The correct answer was: " + currentQuestion.getCorrectAnswer());
        }
        timer.cancel(); // Cancel timer for the current question
        currentQuestionIndex++;
        displayNextQuestion();
    }

    private void endQuiz() {
        System.out.println("\nQuiz completed!");
        System.out.println("Your final score: " + score + "/" + questions.length);
        System.exit(0); // End the program
    }
}

public class Main {
    public static void main(String[] args) {
        // Sample quiz questions
        Question[] questions = {
                new Question("What is the capital of France?",
                        new String[]{"Paris", "London", "Berlin", "Rome"}, 'A'),
                new Question("Who wrote Romeo and Juliet?",
                        new String[]{"Shakespeare", "Dickens", "Twain", "Hemingway"}, 'A'),
                new Question("What is the largest planet in our solar system?",
                        new String[]{"Earth", "Jupiter", "Mars", "Saturn"}, 'B'),
                new Question("What is the powerhouse of the cell?",
                        new String[]{"Mitochondria", "Nucleus", "Ribosome", "Endoplasmic Reticulum"}, 'A')
        };

        Quiz quiz = new Quiz(questions);
        quiz.startQuiz();
    }
}
