/*
Question 7 ::: 0-1 BFS
Problem :
You are given an m x n grid where each cell contains a direction:
1 = right, 2 = left, 3 = down, 4 = up

You start from cell (0,0) and want to reach (m-1,n-1).

If you move in the same direction as the current cell’s arrow:
    cost = 0

If you move in a different direction:
    cost = 1
    (because you need to change that cell’s sign)

Return the minimum cost required to make at least one valid path
from top-left to bottom-right.
*/
import java.util.*;
public class MinimumCostGrid {

	// Direction arrays for moving in grid
	// index 0 is kept unused so that direction numbers match directly:
	// 1 = right, 2 = left, 3 = down, 4 = up
	static int[] rowDir = {0, 0, 0, 1, -1}; 
	static int[] colDir = {0, 1, -1, 0, 0}; 

	static class Cell {
		int row;
		int col;
		int cost;

		Cell(int row, int col, int cost) {
			this.row = row;
			this.col = col;
			this.cost = cost;
		}
	}
	public static int getMoveCost(int currentCellDirection, int chosenDirection) {
		return currentCellDirection == chosenDirection ? 0 : 1;
	}

	public static boolean isValid(int row, int col, int rows, int cols) {
		return row >= 0 && row < rows && col >= 0 && col < cols;
	}

	public static int minCost(int[][] grid) {

		int rows = grid.length;          	// Total number of rows
		int cols = grid[0].length;    		// Total number of columns

		int[][] dist = new int[rows][cols]; // Stores the minimum cost to reach each cell

			//Stores all the value as infinity
		for (int i = 0; i < rows; i++) {  
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		Deque<Cell> deque = new ArrayDeque<>();
		dist[0][0] = 0;
		deque.offerFirst(new Cell(0, 0, 0));

		while (!deque.isEmpty()) { // Check for deque is empty [Not empty enters the loop]

			Cell current = deque.pollFirst(); // Remove the first elemts 

			int currentRow = current.row;
			int currentCol = current.col;
			int currentCost = current.cost;

			// Base Case when grid has reached to end point ie. if m X n Then last value is m-1 x n-1
			if (currentRow == rows - 1 && currentCol == cols - 1) {
				return currentCost;
			}
			// To check if current better or to skip it
			if (currentCost > dist[currentRow][currentCol]) {
				continue;
			}
			// To traverse in all 4 direction
			for (int direction = 1; direction <= 4; direction++) {

				int nextRow = currentRow + rowDir[direction];
				int nextCol = currentCol + colDir[direction];

				if (!isValid(nextRow, nextCol, rows, cols)) {
					continue;
				}
				int extraCost = getMoveCost(grid[currentRow][currentCol], direction);

				int newCost = currentCost + extraCost;
				if (newCost < dist[nextRow][nextCol]) {
					dist[nextRow][nextCol] = newCost;
					
					// IF extra cost is minimum add to front of queue else add in last of queue 
					if (extraCost == 0) {
						deque.offerFirst(new Cell(nextRow, nextCol, newCost));
					} else {
						deque.offerLast(new Cell(nextRow, nextCol, newCost));
					}
				}
			}
		}

		return dist[rows - 1][cols - 1];
	}

	public static void main(String[] args) {

		//		1 = right  2 = left  3 = down  4 = up
		int[][] grid = {         
			    {1, 1, 1},
			    {4, 3, 2},
			    {1, 1, 4}
			};
		int answer = minCost(grid);

		System.out.println("Minimum Cost = " + answer);

	}
}

/*
====================================================
SHORT RECAP
====================================================

What this code does:
- Finds the minimum cost required to go from
  top-left cell (0,0) to bottom-right cell (m-1,n-1)

Rule:
- Each cell contains a direction
- If we move in the same direction as the current cell’s arrow:
  cost = 0
- If we move in a different direction:
  cost = 1

How it works:
1. Start from cell (0,0)
2. Try moving in all 4 directions from each cell
3. If chosen direction matches current cell arrow:
   move cost = 0
4. If chosen direction does not match:
   move cost = 1
5. Use deque to always process cheaper paths first
6. Stop when destination cell is reached

Why this is 0-1 BFS:
- Every move has only 2 possible costs:
  0 or 1
- So instead of normal BFS or Dijkstra,
  0-1 BFS is the best fit

Why deque is used:
- cost 0 move → add to FRONT
- cost 1 move → add to BACK
- This ensures lower cost paths are processed first

Important points to remember:
- Cost is decided by CURRENT cell’s arrow,
  not NEXT cell’s arrow
- dist[row][col] stores minimum cost to reach that cell
- Update only if newCost < dist[nextRow][nextCol]
- offerFirst() is used for cheaper move
- offerLast() is used for costly move
- If currentCost > dist[currentRow][currentCol],
  skip it because a better path already exists

Time Complexity:
- O(rows * cols)

Space Complexity:
- O(rows * cols)

====================================================
*/

