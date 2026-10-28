# main.java.Tournament Bracket Engine (Java CLI)

A single-elimination tournament management engine, developed in Java as a Command Line Interface (CLI) application.

This project allows you to create a tournament, dynamically register teams via the console, arbitrate matches manually, and track the progression of a tournament bracket until a champion is crowned. It includes advanced handling of edge cases, robust user input validation, and automatic results export.

## Features

* **Interactive CLI Menu:** Fluid console interface to create a tournament, set the cash prize, and register teams (supporting multi-word team names).

* **Automated Matchmaking:** Random shuffling of teams during the first round to ensure a fair draw.

* **Bye Management:** If the number of teams is odd, the algorithm automatically generates a "Bye". The team without an opponent automatically qualifies for the next round with a forfeit score (13-0).

* **Manual Score Arbitration:** Interactive score entry for each match (CS2 MR12 format inspired, up to 13 points), with strict enforcement against draws.

* **Robust Input Validation:** Exception handling (`try-catch` with buffer flushing) preventing application crashes when users input invalid data types or attempt to start tournaments with fewer than 2 teams.

* **File Export:** Automatic saving of the complete tournament history and final winner to a `tournament_result.txt` file upon tournament completion.

* **Complete History:** In-memory tracking of all rounds and matches played, with a full summary displayed in the terminal.

* **Unit Testing:** Comprehensive test coverage for all core domain models (`main.java.Player`, `main.java.Team`, `main.java.Match`, `main.java.Tournament`) using JUnit 5.

## Object-Oriented Architecture

The project is built around solid OOP principles, ensuring encapsulation and separation of concerns:

* `main.java.Tournament`: The main controller. It manages the list of active teams, match history, score entry routines, and export operations.

* `main.java.Team`: Represents a team, managing its players list and capacity limits.

* `main.java.Player`: Represents individual team members.

* `main.java.Match`: Handles the clash between two `main.java.Team` instances, stores scores, and exposes logical methods like `getWinner()` and `getLooser()`.

* `main.java.Main`: The CLI entry point, driving user navigation through interactive menus.

## How to run the project

Ensure you have [Java (JDK 21 or higher recommended)](https://www.oracle.com/java/technologies/downloads/) installed on your machine.

1. Clone this repository:

   ```bash
   git clone https://github.com/maxence-beauvais/tournament-bracket-engine.git
   ```

2. Navigate to the project folder:

   ```bash
   cd app-tournament
   ```

3. Compile the Java files:

   ```bash
   javac *.java
   ```

4. Run the application:

   ```bash
   java main.java.Main
   ```

## Running Unit Tests

To run the test suite with JUnit 5 (if using Maven or Gradle):

* **Maven:** `mvn test`
* **Gradle:** `./gradlew test`

## Future Improvements (Roadmap)

* [x] Fix the Scanner buffer to allow input of multi-word team names (with spaces).
* [x] Manual score entry by an administrator (replacing random simulation).
* [x] Export results to a text file.
* [x] Unit test suite with JUnit 5.
* [ ] Add a local database (SQLite) to persist tournament sessions.
* [ ] Display the tournament bracket as an ASCII chart in the console.

*Project developed as part of an in-depth learning of Java architecture, data structures, and software engineering best practices.*