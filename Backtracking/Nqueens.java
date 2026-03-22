
// N-queens puzzle
// Place queens on an n x n chessboard such that no two queens attack each other.
// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Nqueens {

    public static boolean isSafe(Vector<String> board, int row, int col, int n) {
        // For horizontal check
        for (int i = 0; i < n; i++) {
            if (board.get(row).charAt(i) == 'Q') {
                return false;
            }
        }
        // For vertical check 
        for (int i = 0; i < n; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        // For Left diagonal check
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        // For Right diagonal check
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void nqueen(Vector<String> board, int row, int n, List<List<String>> ans) {
        if (row == n) {
            ans.add(new ArrayList<>(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                char[] chars = board.get(row).toCharArray();
                chars[col] = 'Q';
                board.set(row, new String(chars));
                nqueen(board, row + 1, n, ans);
                chars[col] = '.';
                board.set(row, new String(chars));
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        Vector<String> board = new Vector<>(Collections.nCopies(n, ".".repeat(n)));
        List<List<String>> ans = new ArrayList<>();
        nqueen(board, 0, n, ans);
        System.out.println("Result :::" + ans);
    }
}


/*
====================== QUICK RECAP / REVISION NOTES ======================

Problem:
Place n queens on an n x n board such that no two queens attack each other.

Attack rules:
A queen can attack in:
1. Same row
2. Same column
3. Left diagonal
4. Right diagonal

--------------------------------------------------------------------------

CORE IDEA:
Try to place one queen in each row.

For every row:
- try all columns
- if a position is safe, place queen
- move to next row
- after recursion, remove queen (backtrack)

--------------------------------------------------------------------------

RECURSION FLOW:
nqueen(board, row, n, ans)

1. Base case:
   If row == n
   → all queens placed successfully
   → store current board in answer

2. Recursive case:
   For each column in current row:
   - check if (row, col) is safe
   - place 'Q'
   - call recursion for next row
   - remove 'Q' after returning

--------------------------------------------------------------------------

WHY BACKTRACKING IS NEEDED:
After exploring one possibility, we must undo the change
so we can try the next column in the same row.

This part does that:

chars[col] = '.';
board.set(row, new String(chars));

Without this, old queen placement would remain on board.

--------------------------------------------------------------------------

isSafe() LOGIC:
Before placing a queen at (row, col), check:

1. Horizontal row
2. Vertical column
3. Upper-left diagonal
4. Upper-right diagonal

If any place already has 'Q', return false.
Otherwise return true.

--------------------------------------------------------------------------

IMPORTANT POINTS TO REMEMBER:

1. Board is stored as Vector<String>
   - each string = one row
   - '.' means empty cell
   - 'Q' means queen

2. String is immutable in Java
   - cannot directly modify one character
   - so convert row string to char array
   - update character
   - convert back to String
   - set it again in board

Example:
char[] chars = board.get(row).toCharArray();
chars[col] = 'Q';
board.set(row, new String(chars));

3. One recursive level = one row

4. One loop inside recursion = trying all columns of that row

5. Base case row == n means one valid solution found

--------------------------------------------------------------------------

TIME COMPLEXITY:
Roughly O(N!)
because for each row we try columns with safety checks

SPACE COMPLEXITY:
O(N) recursion stack
+ answer storage

--------------------------------------------------------------------------

PATTERN TO REMEMBER:
Backtracking template:

for every choice
    if valid
        make choice
        recurse
        undo choice

This problem follows exactly that pattern.

==========================================================================
 */
