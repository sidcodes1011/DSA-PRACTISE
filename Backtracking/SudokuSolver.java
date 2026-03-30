/*
     * Question:
     * Write a program to solve a Sudoku puzzle by filling empty cells.
     * Empty cells are represented by '.'.
     * Rules:
     * 1. Each row must contain digits 1 to 9 only once.
     * 2. Each column must contain digits 1 to 9 only once.
     * 3. Each 3x3 sub-grid must contain digits 1 to 9 only once.
 */
public class SudokuSolver {

    public void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {

            // Print horizontal line after every 3 rows
            if (i % 3 == 0 && i != 0) {
                System.out.println("-----------------------");
            }

            for (int j = 0; j < 9; j++) {

                // Print vertical line after every 3 columns
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }

                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char board[][], int row, int col, char value) {

        // For Row 
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        // For Column		
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == value) {
                return false;
            }
        }

        // For Grid check
        int newRow = (row / 3) * 3;
        int newCol = (col / 3) * 3;

        for (int i = newRow; i < newRow + 3; i++) {
            for (int j = newCol; j < newCol + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean sudokuSolver(char board[][]) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {

                    for (char a = '1'; a <= '9'; a++) {

                        if (isSafe(board, i, j, a)) {
                            board[i][j] = a;

                            if (sudokuSolver(board)) {

                                return true;
                            }

                            board[i][j] = '.';
                        }

                    }

                    return false;

                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("Sudoku bord before solving ::: ");

        SudokuSolver SudokuSOlver = new SudokuSolver();

        SudokuSOlver.printBoard(board);

        System.out.println();
        System.out.println("-------------------------");

        System.out.println("Sudoku bord After solving ::: ");
        System.out.println("-------------------------");

        System.out.println();

        SudokuSOlver.sudokuSolver(board);
        SudokuSOlver.printBoard(board);

    }
}
/*
     * Short Recap:
     *
     * 1. Traverse the board and find an empty cell ('.').
     * 2. Try placing digits '1' to '9'.
     * 3. Before placing, check if it is safe:
     *    - not in same row
     *    - not in same column
     *    - not in same 3x3 grid
     * 4. If safe, place the digit and recursively solve next cells.
     * 5. If solution fails later, undo the placement (backtracking).
     * 6. If no empty cell is left, Sudoku is solved.
     *
     * Core Concept:
     * Backtracking = try -> move ahead -> if wrong -> undo -> try next
 */
