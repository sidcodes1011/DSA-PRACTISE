
/*
Question:

Given an n x n integer grid, check whether it represents
a valid knight’s tour on a chessboard.

- The knight starts from cell (0,0) with value 0
- Each next number must be reached using a valid knight move
- All numbers from 0 to n*n - 1 must appear in order

Return true if the grid is a valid knight’s tour, otherwise false.
 */
public class Nknights {

    public static boolean checkValidGrid(int[][] grid, int row, int col, int size, int expValue) {

        if (row < 0 || col < 0 || row >= size || col >= size || grid[row][col] != expValue) {
            return false;
        }

        if (expValue == ((size * size) - 1)) {

            return true;
        }

        boolean ans1 = checkValidGrid(grid, row - 2, col - 1, size, expValue + 1);
        boolean ans2 = checkValidGrid(grid, row - 2, col + 1, size, expValue + 1);
        boolean ans3 = checkValidGrid(grid, row - 1, col - 2, size, expValue + 1);
        boolean ans4 = checkValidGrid(grid, row - 1, col + 2, size, expValue + 1);
        boolean ans5 = checkValidGrid(grid, row + 1, col - 2, size, expValue + 1);
        boolean ans6 = checkValidGrid(grid, row + 1, col + 2, size, expValue + 1);
        boolean ans7 = checkValidGrid(grid, row + 2, col - 1, size, expValue + 1);
        boolean ans8 = checkValidGrid(grid, row + 2, col + 1, size, expValue + 1);

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {0, 3, 6},
            {5, 8, 1},
            {2, 7, 4}
        };
        int row = 0;
        int col = 0;
        int size = grid.length;

        boolean ans = checkValidGrid(grid, row, col, size, 0);

        System.out.println("The given grid Knight result ::: " + ans);
    }
}

/*
Quick Note:

- This solution uses recursion + backtracking style checking.
- We start from (0,0) and expect value 0.
- At every step, we try all 8 possible knight moves.
- If the current cell does not contain the expected value, return false.
- If we successfully reach n*n - 1, return true.
- Final answer is true if any one recursive path works.

 */
