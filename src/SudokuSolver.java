import java.util.*;

/**
 * The SudokuSolver class provides functionality to solve a given Sudoku puzzle.
 * It uses a backtracking algorithm to fill in the empty spots in the puzzle with
 * valid digits, ensuring all Sudoku rules are followed.
 */
public class SudokuSolver {

    /**
     * Solves the given Sudoku puzzle by filling in the empty spots using a backtracking algorithm.
     * The method attempts to place valid digits in empty cells of the puzzle, ensuring compliance
     * with Sudoku rules.
     *
     * @param puzzle the Sudoku puzzle to be solved, represented as an instance of SudokuPuzzle
     * @return the solved Sudoku puzzle if a solution is found, otherwise null if no solution exists
     */
    public static SudokuPuzzle solve(SudokuPuzzle puzzle){

        ArrayList<SudokuMove> emptyCoords = new ArrayList<>(emptySpots(puzzle));
        ArrayDeque<SudokuMove> stack = new ArrayDeque<>();

        if(emptyCoords.isEmpty()) {
            System.out.println("Puzzle has no empty spots, it is solved already.");
            return puzzle;
        }

        int index = 0;
        stack.push(emptyCoords.get(index)); //pushing the first empty spot

        //continues until we've reached the last empty spot
        while (!stack.isEmpty()) {

            SudokuMove current = stack.pop(); //retrieves the first empty spot's coordinates
            int r = current.getRow();
            int c = current.getCol();
            int digit = current.getDigit();
            boolean foundMove = false;

            //if we have reached the last empty spot
            if(index == emptyCoords.size()) {
                return puzzle;
            }

            // trying digits on the current empty spot, by incrementing the digit inside.
            for (int d = digit + 1; d <= 9; d++) {
                if (puzzle.isValid(r, c, d)){

                    //making a valid move
                    puzzle.setDigit(r, c, d);
                    stack.push(new SudokuMove(r, c, d));
                    index++;

                    //advancing to the next empty spot, if there is one
                    if(index < emptyCoords.size()) {
                        stack.push(emptyCoords.get(index));
                    }

                    foundMove = true;
                    break;
                }
            }

            //if there is no possible digit to be placed, resetting the current one, and moving
            // to the previous one, backtracking
            if(!foundMove) {
                puzzle.setDigit(r, c, 0);
                if (index > 0) {
                    index--;
                } else {
                    return null; // No solution exists
                }
            }
        }

        return null; //if there wasn't any possible solution to return
    }

    /**
     * Identifies all empty spots in a given Sudoku puzzle and returns them as a list of
     * SudokuMove objects. Each empty spot is represented by a SudokuMove object with the row,
     * column, and digit set to 0.
     *
     * @param puzzle the Sudoku puzzle to search for empty spots, represented as an instance of
     *               SudokuPuzzle.
     * @return a list of SudokuMove objects representing all empty spots in the puzzle
     */
    public static ArrayList<SudokuMove> emptySpots(SudokuPuzzle puzzle){
        ArrayList<SudokuMove> spots = new ArrayList<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (puzzle.getDigit(r, c) == 0){
                    spots.add(new SudokuMove(r, c, 0));
                }
            }
        }

        return spots;
    }
}
