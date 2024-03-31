# Quiz Application with Timer in Java

This project is a simple quiz application implemented in Java. It includes classes for representing quiz questions, managing the quiz, and handling user input.

## Project Structure

The project consists of the following classes:
- `Question`: Represents each quiz question with options and correct answers.
- `Quiz`: Manages quiz operations such as displaying questions, handling user input, calculating scores, and ending the quiz.

## Features

- Displays quiz questions one by one with multiple-choice options.
- Implements a timer for each question to limit the time for answering.
- Calculates the user's score based on correct answers.
- Provides feedback on correct and incorrect answers.
- Ends the quiz when all questions are answered.

## How to Run

1. Clone or download the project files to your local machine.
2. Open a terminal or command prompt.
3. Navigate to the directory containing the Java files (`Main.java`, `Question.java`, `Quiz.java`).
4. Compile the Java files using the `javac` command:
```
javac Main.java
```
5. Run the compiled program using the `java` command:
```
java Main
```
## Usage

- Upon running the program, the quiz will start automatically.
- Answer each question by typing the corresponding letter (A, B, C, etc.) for your choice.
- The program will provide feedback on your answers and calculate the final score at the end of the quiz.

## Notes

- Ensure valid input (single letters corresponding to answer choices an is  UPPERCASE ) during the quiz.
- The timer for each question is set to 15 seconds (adjust as needed in the code).
- Additional questions can be added to the `questions` array in `Main.java`.

