/*
     * Question:
     * Given a 2D grid of '1' (land) and '0' (water),
     * count how many islands are present.
     * An island is formed by connecting adjacent lands
     * horizontally or vertically.
 */
public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    // [DFS : Dept first search]
    public static void dfs(char[][] grid, int i, int j) {

        // Boundary check + water/visited check
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        // Visit all 4 directions
        // down
        dfs(grid, i + 1, j);
        // up
        dfs(grid, i - 1, j);
        // right
        dfs(grid, i, j + 1);
        // left
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        System.out.println("Number of Islands: " + numIslands(grid));
    }

    /*
     * Short Recap:
     *
     * 1. Traverse each cell of grid.
     * 2. If cell is '1', it means new island found.
     * 3. Increase count.
     * 4. Use DFS to visit all connected land cells.
     * 5. Mark visited land as '0' to avoid recounting.
     * 6. DFS explores 4 directions only:
     *    up, down, left, right.
     */
}
