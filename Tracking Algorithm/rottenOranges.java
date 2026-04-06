/* Question 5 : Multi-Source BFS 
Problem Statement

You are given a grid where:
- 0 = empty cell
- 1 = fresh orange
- 2 = rotten orange

Every minute, any fresh orange adjacent
(up, down, left, right) to a rotten orange becomes rotten.

Return the minimum number of minutes needed
to rot all oranges.

If it is impossible to rot all oranges, return -1.
*/
import java.util.*;

public class rottenOranges {
	
	public static void printQueue(Queue<int[]> queue) {
	    System.out.print("Queue = [ ");

	    for (int[] item : queue) {
	        System.out.print("[" + item[0] + "," + item[1] + "," + item[2] + "] ");
	    }

	    System.out.println("]");
	}


    public static int rottenOrangeCalculator(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;	// To rack how many fresh oranges are left.
        int minutes = 0; 	// Stores total time taken.

        // Step 1: Put all rotten oranges in queue and count fresh oranges
        
        // This is logic which makes it Symbolise why its multiSource BFS 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0}); // row, col, time
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        // The end of this loop will keep track how many source point is there and how many fresh oranges are there 

        if (freshCount == 0) {
        	return 0;
        	}
        // Returns 0 since if no fresh oranges then nothing will rott

        // Step 2: BFS Real logic
        while (!queue.isEmpty()) {
        	System.out.println("Queue Before poll ::: ");
        	 printQueue(queue);
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int time = current[2];

            minutes = time;

            freshCount = spreadRot(grid, row, col, time, queue, freshCount);
           System.out.println("Queue after spreadROt::: ");
       	 	printQueue(queue);
        }

        return freshCount == 0 ? minutes : -1;
    }

    public static int spreadRot(int[][] grid, int row, int col, int time,
                                Queue<int[]> queue, int freshCount) {

        int[][] directions = {
                {-1, 0}, // up
                {1, 0},  // down
                {0, -1}, // left
                {0, 1}   // right
        };

        int rows = grid.length;
        int cols = grid[0].length;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (isValid(grid, newRow, newCol, rows, cols)) {
                grid[newRow][newCol] = 2;
                queue.offer(new int[]{newRow, newCol, time + 1});
                freshCount--;
            }
        }

        return freshCount;
    }

    public static boolean isValid(int[][] grid, int row, int col, int rows, int cols) {
        return row >= 0 && row < rows &&
               col >= 0 && col < cols &&
               grid[row][col] == 1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        System.out.println("Time taken for rotting all oranges is ::: " + rottenOrangeCalculator(grid));
    }
}

/*
====================================================
SHORT RECAP
====================================================

What this code does:
- Finds minimum time required to rot all fresh oranges
  in a grid using BFS.

Grid values:
- 0 = empty cell
- 1 = fresh orange
- 2 = rotten orange

How it works:
1. Add all rotten oranges into queue
2. Count all fresh oranges
3. Start BFS from all rotten oranges together
4. Spread rot to adjacent fresh oranges
5. Track time for each rotting step
6. If all fresh oranges become rotten, return time
7. If some fresh oranges are still left, return -1

Why this is Multi-Source BFS:
- Because BFS starts from multiple rotten oranges at once
- All rotten oranges act as starting points

Why BFS is used:
- Rot spreads level by level (minute by minute)
- BFS naturally processes nearest cells first

Important points to remember:
- Queue stores {row, col, time}
- Fresh oranges count is used to know if all got rotten
- Use 4 directions only (up, down, left, right)
- Mark fresh orange rotten immediately when added to queue

Time Complexity:
- O(rows * cols)

Space Complexity:
- O(rows * cols)

====================================================
*/
