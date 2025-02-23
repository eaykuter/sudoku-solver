/**
 * Represents a move in a Sudoku game, which includes the row, column, and
 * digit to be placed in the puzzle grid.
 */
public class SudokuMove {
    private int row;
    private int col;
    private int digit;

    /**
     * Constructs a new SudokuMove object that represents a move in the Sudoku game.
     * The move specifies a row, column, and digit to be placed.
     *
     * @param r the row index of the move
     * @param c the column index of the move
     * @param d the digit to be placed at the specified row and column
     */
    public SudokuMove(int r, int c, int d) {
        this.row = r;
        this.col = c;
        this.digit = d;
    }

    /**
     * Retrieves the row index associated with this move in the Sudoku game.
     *
     * @return the row index of the move
     */
    public int getRow() {
        return row;
    }

    /**
     * Retrieves the column index associated with this move in the Sudoku game.
     *
     * @return the column index of the move
     */
    public int getCol() {
        return col;
    }

    /**
     * Retrieves the digit associated with this move in the Sudoku game.
     *
     * @return the digit to be placed in the Sudoku puzzle
     */
    public int getDigit() {
        return digit;
    }

    /**
     * Updates the digit associated with this move in the Sudoku game.
     *
     * @param d the new digit to be set for this move
     */
    public void setDigit(int d) {
        this.digit = d;
    }
}
