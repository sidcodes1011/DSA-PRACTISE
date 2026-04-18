/* Question 3 : Shortest Path in Binary Matrix
Problem Statement

Given an n x n binary matrix grid, return the length of the shortest clear path from top-left (0,0) to bottom-right (n-1,n-1).
 */
import java.util.*;

public class ShortestPathInBinaryMatrix {

    public static int shortestPathBinaryMatrix(int[][] matrix) {

        // Base Case
        if (matrix[0][0] == 1 || matrix[matrix.length - 1][matrix[0].length - 1] == 1) {
            return -1;
        }
        // Direction 2d-array
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
        };

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0, 1}); // Row , col , steps
        matrix[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int step = cell[2];
            System.out.println("row :::" + row + "col :::" + col + "Step :::" + step);

            if (row == matrix.length - 1 && col == matrix[0].length - 1) {
                return step;
            }

            int count = 0;
            for (int[] direction : directions) {
                count++;
                System.out.println("For direction ::: " + count);
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                System.out.println("New row :::" + newRow + "New col :::" + newCol);
                System.out.println("\033[32mTrying for direction " + direction[0] + " " + direction[1] + "\033[0m");
                System.out.println();

                if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length && matrix[newRow][newCol] == 0) {

                    System.out.println("Queue addition done for direction " + direction[0] + " " + direction[1]);
                    System.out.println();

                    matrix[newRow][newCol] = 1;
                    queue.add(new int[]{newRow, newCol, step + 1});
                    System.out.println("Steps done till now :::" + (step + 1));
                }
            }
            System.out.println("-----------------------------------------------");

        }

        return -1;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0},};

        System.out.println("SHORTEST DISTANCE ::: " + shortestPathBinaryMatrix(matrix));

    }
}

/*
========================================
SHORT RECAP
========================================

What this code does:
- Finds the shortest path from top-left to bottom-right in a binary matrix.
- Uses BFS because BFS always gives shortest path in unweighted grid problems.

Rules:
- 0 = open cell (can move)
- 1 = blocked cell (cannot move)
- Can move in 8 directions

How it works:
1. Check if start or end is blocked
2. Put starting cell (0,0) into queue with step = 1
3. While queue is not empty:
   - Remove current cell
   - If destination reached, return step
   - Try all 8 directions
   - If valid and unvisited, add to queue with step + 1
4. If destination never reached, return -1

Why BFS works:
- BFS explores nearest cells first
- First time destination is reached = shortest path

Important points to remember:
- BFS = Queue
- Grid shortest path (equal cost) = BFS
- Mark visited immediately when adding to queue
- Use directions array to move in grid
- Here movement is in 8 directions, not 4

Time Complexity:
- O(n * n) -> every cell visited at most once

Space Complexity:
- O(n * n) -> queue may store many cells

Use this pattern when:
- Finding shortest path in grid
- Minimum steps in maze
- Rotten oranges / nearest exit / islands / matrix BFS problems

========================================
 */
