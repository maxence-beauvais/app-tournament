# Tournament Bracket Engine (Java CLI)

A single-elimination tournament management engine, developed in Java as a Command Line Interface (CLI) application.

This project allows you to create a tournament, dynamically register teams via the console, and simulate the progression of a tournament bracket until a champion is crowned. It includes advanced handling of edge cases, such as an odd number of participants.

## Current Features

* **Interactive CLI Menu:** Fluid console interface to create a tournament, set the cash prize, and register teams on the fly.

* **Automated Matchmaking:** Random shuffling of teams during the first round to ensure a fair draw.

* **Bye Management:** If the number of teams is odd, the algorithm automatically generates a "Bye". The team without an opponent automatically qualifies for the next round (automatic 13-0 victory).

* **Score Simulation:** Random generation of realistic scores (inspired by the Counter-Strike 2 MR12 format, up to 13), excluding draws.

* **Complete History:** In-memory saving of all rounds and matches played, with a summary display during the final.

## Object-Oriented Architecture

The project is built around solid OOP principles, ensuring encapsulation and separation of concerns:

* `Tournament`: The main controller. It manages the lists of active teams, match history, and the elimination logic loop.

* `Team`: Represents a team, containing a list of players and managing its own maximum capacity.

* `Player`: The core entity representing a participant.

* `Match`: Handles the clash between two `Team` instances, stores scores, and exposes logical methods like `getWinner()` and `getLooser()`.

* `Main`: The entry point of the program, handling user inputs via `Scanner`.

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
   java Main
   ```

## Future Improvements (Roadmap)

* [ ] Fix the Scanner buffer to allow input of multi-word team names (with spaces).
* [ ] Manual score entry by an administrator (replacing random simulation).
* [ ] Add a local database (SQLite) to save tournaments between sessions.
* [ ] Display the tournament bracket as an ASCII chart in the console.

*Project developed as part of an in-depth learning of Java architecture and data structure algorithms.*