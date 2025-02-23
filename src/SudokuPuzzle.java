import java.io.File;
import java.util.Scanner;

/**
 * Represents a Sudoku puzzle with dimensions 9x9, supporting initialization from a file,
 * validation of moves, and operations to manipulate or compare puzzles.
 * The puzzle is stored internally as a 2D array of integers, where 0 represents an empty cell.
 */
public class SudokuPuzzle {

    private static final int NUM_ROWS = 9;
    private static final int NUM_COLS = 9;
    private static final int BOX_EDGE = 3;
    private final int [][] puzzle = new int[NUM_ROWS][NUM_COLS];

    /**
     * Constructs a SudokuPuzzle object by reading a Sudoku puzzle from a file.
     * The constructor initializes the puzzle grid with integers present in the file.
     * If the file contains invalid data or does not exist, an error message is printed
     * and the program exits.
     *
     * @param name the name of the file containing the Sudoku puzzle to be loaded
     * @throws IllegalArgumentException if the file contains invalid data
     */
    public SudokuPuzzle(String name) {

        try {
            Scanner f = new Scanner(new File(name));

            for (int r = 0; r < NUM_ROWS; r++) {
                for (int c = 0; c < NUM_COLS; c++) {
                    if (!f.hasNextInt()) {
                        f.close();
                        throw new IllegalArgumentException("Invalid input in file.");
                    }

                    puzzle[r][c] = f.nextInt();
                }
            }
            f.close();

        } catch (Exception e) {
            System.out.println("File not found or invalid.");
            System.exit(0);
        }
    }

    /**
     * Determines whether placing a given digit at the specified row and column
     * in the Sudoku puzzle is valid based on the puzzle's constraints.
     *
     * @param row the row index where the digit is to be placed
     * @param col the column index where the digit is to be placed
     * @param digit the digit to be validated for placement
     * @return true if the digit can be placed at the specified position without
     *         violating Sudoku rules; false otherwise
     */
    public boolean isValid(int row, int col, int digit) {

        if ( ((NUM_ROWS * NUM_COLS) % BOX_EDGE) != 0) {
            System.out.println("Invalid box size for puzzle dimensions.");
            return false;
        }

        int boxRowStart = (row / BOX_EDGE) * BOX_EDGE;
        int boxColStart = (col / BOX_EDGE) * BOX_EDGE;

        for (int i = 0; i < NUM_ROWS; i++) {
            if (puzzle[row][i] == digit || puzzle[i][col] == digit) {
                return false;
            }
        }

        for (int i = boxRowStart; i < boxRowStart + BOX_EDGE; i++) {
            for (int j = boxColStart; j < boxColStart + BOX_EDGE; j++) {
                if (puzzle[i][j] == digit) {
                    return false;
                }
            }
        }

        // if the row, column or the box does not contain the digit, move is valid.
        return true;
    }

    /**
     * Retrieves the digit at the specified position in the Sudoku puzzle grid.
     *
     * @param row the row index of the digit to retrieve
     * @param col the column index of the digit to retrieve
     * @return the digit at the specified position in the puzzle
     */
    public int getDigit(int row, int col) {
        return puzzle[row][col];
    }

    /**
     * Sets the specified digit at the given row and column positions in the Sudoku puzzle grid.
     *
     * @param row the row index where the digit should be placed
     * @param col the column index where the digit should be placed
     * @param digit the digit to be placed at the specified position
     */
    public void setDigit(int row, int col, int digit) {
        puzzle[row][col] = digit;
    }

    /**
     * Determines whether the specified object is equal to this SudokuPuzzle.
     * Two SudokuPuzzle objects are considered equal if they have the same
     * grid dimensions and the contents of the grid are identical.
     *
     * @param obj the object to be compared for equality with this SudokuPuzzle
     * @return true if the specified object is equal to this SudokuPuzzle; false otherwise
     */
    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof SudokuPuzzle)) {
            return false;
        }

        SudokuPuzzle o = (SudokuPuzzle) obj;

        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLS; c++) {
                if (getDigit(r, c) != o.getDigit(r, c)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Returns a string representation of the Sudoku puzzle. Each row of the puzzle
     * is represented as a line of space-separated integers, with rows separated by
     * newline characters.
     *
     * @return the string representation of the Sudoku puzzle
     */
    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();

        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLS; c++) {
                s.append(puzzle[r][c]);
                s.append(" ");
            }
            s.append("\n"); //adds a space after the puzzle was printed.
        }

        return s.toString();
    }
}