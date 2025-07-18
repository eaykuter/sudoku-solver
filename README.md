# Java Sudoku Solver

A classic 9x9 Sudoku puzzle solver built in Java. This project uses a recursive backtracking algorithm to efficiently find a valid solution for any given puzzle loaded from a text file.

---

## Features

* **Efficient Solving**: Implements a highly efficient, stack-based backtracking algorithm.
* **File Input**: Loads Sudoku puzzles directly from `.txt` files for easy testing.
* **Object-Oriented**: Built with a clean, object-oriented design that separates the puzzle logic, data model, and solver engine.
* **Validation**: Includes robust logic to validate each move against Sudoku rules (row, column, and 3x3 box).

---

## Core Concepts

This solver is built around two key computer science principles:

### 1. Backtracking Algorithm

Backtracking is a recursive technique for solving problems by trying to build a solution incrementally. If at any point the current path cannot lead to a valid solution, it "backtracks" to the previous step and tries a different path.

The process for this solver is:
1.  Find the first empty cell on the board.
2.  Try placing a digit from 1 to 9 in that cell.
3.  For each attempt, check if the move is **valid** (i.e., the digit doesn't already exist in the same row, column, or 3x3 box).
4.  If the move is valid, place the digit and recursively move to the next empty cell.
5.  If any recursive step fails (i.e., it hits a dead end with no valid moves), **backtrack** by resetting the cell to empty (0) and try the next digit in the current cell.
6.  If all digits (1-9) have been tried and none lead to a solution, return failure to the previous call, forcing it to backtrack as well.

This implementation uses an explicit `ArrayDeque` (acting as a stack) to manage the recursive states, which is a memory-efficient alternative to native function call recursion.

### 2. Object-Oriented Design

The code is separated into logical classes to improve readability and maintainability:
* `SudokuMove.java`: A simple **data object** to represent a potential move (row, column, digit).
* `SudokuPuzzle.java`: The **model**. It represents the Sudoku board itself, holding the 2D array and methods for getting/setting digits and checking move validity.
* `SudokuSolver.java`: The **engine**. It contains the core `solve()` method that implements the backtracking logic.
* `SudokuTest.java`: The **driver**. It handles user input, file loading, and initializes the solving process.

---

## How to Run

You will need the Java Development Kit (JDK) installed on your system.

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/eaykuter/sudoku-solver.git]
    cd [sudoku-solver/src]
    ```

2.  **Compile the Java files:**
    ```bash
    javac *.java
    ```

3.  **Run the program:**
    ```bash
    java SudokuTest
    ```

4.  **Provide the Input File:**
    The program will prompt you to enter the name of a puzzle file. The puzzle file should be a text file containing 9 lines of 9 space-separated integers, where `0` represents an empty cell. There are some test files placed inside the `puzzles/` directory.

    **Example `puzzles/puzzle1.txt`:**
    ```
    4 3 5 2 6 9 7 8 1
    6 0 2 5 7 0 4 9 3
    1 9 7 8 3 4 5 6 2
    8 2 6 0 9 5 3 4 7
    3 7 4 6 8 2 9 1 5
    9 5 1 7 4 3 6 0 8
    5 0 9 3 2 6 8 7 4
    2 4 8 0 5 7 1 3 6
    7 6 3 4 1 8 2 5 9
    ```
