import java.util.Scanner;

/**
 * A class designed to test the functionality of a Sudoku puzzle solver
 * by reading a puzzle from a file, solving it using the SudokuSolver,
 * and displaying the result.
 */
public class SudokuTest {

    /**
     * The main method serves as the entry point for the application. It prompts the user
     * for the filename of a Sudoku puzzle, reads the puzzle from the specified file,
     * solves it using the SudokuSolver, and outputs the result.
     *
     * @param args command-line arguments passed to the application; not used in this method
     */
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = "puzzles/" + s.nextLine();

        System.out.print("Enter solution file name: ");
        String solFileName = "puzzles/" + s.nextLine();

        s.close();

        SudokuPuzzle puzzle = new SudokuPuzzle(fileName);
        SudokuPuzzle solution = new SudokuPuzzle(solFileName);

        System.out.println(SudokuSolver.solve(puzzle));
        System.out.println(puzzle.equals(solution));
    }
}
