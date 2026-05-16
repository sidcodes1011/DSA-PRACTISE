/*
Question:
LeetCode 1074 - Number of Submatrices That Sum to Target

Given a 2D matrix and an integer target,

Count the number of non-empty submatrices
whose sum is exactly equal to target.

A submatrix is any rectangular area
inside the matrix defined by:

- Top-left corner     -> (row1, col1)
- Bottom-right corner -> (row2, col2)

Return:
- Total count of all submatrices
  having sum == target

Two submatrices are different if
any of their coordinates are different.
 */

import java.util.*;

public class SubmatrixSumEqualsK {

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;
        int row = matrix.length;
        int col = matrix[0].length;

        for (int top = 0; top < row; top++) {
            int[] currMatrix = new int[col];
            for (int bottom = top; bottom < row; bottom++) {

                for (int i = 0; i < col; i++) {
                    currMatrix[i] += matrix[bottom][i];
                }

                System.out.println("Current Matrix ::: " + Arrays.toString(currMatrix));
                Map<Integer, Integer> counter = new HashMap<>();
                counter.put(0, 1);
                int prefixSum = 0;

                for (int val : currMatrix) {

                    prefixSum += val;

                    if (counter.containsKey(prefixSum - target)) {
                        count += counter.get(prefixSum - target);
                    }

                    counter.put(prefixSum, counter.getOrDefault(prefixSum, 0) + 1);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int matrix[][] = {
            {1, -1},
            {-1, 1}
        };
        int target = 0;

        int result = numSubmatrixSumTarget(matrix, target);
        System.out.println("The count of target " + target + " in given submatrix is ::: " + result);

    }
}

/*
Solution Idea:

1) Fix top row and bottom row.

2) Compress rows into a 1D array:
   currMatrix[col] stores the vertical
   sum between top and bottom rows.

3) Now the problem becomes:
   "Count subarrays with sum = target"

4) Use Prefix Sum + HashMap to count
   subarrays efficiently in O(col).

5) Every valid subarray found in the
   compressed array represents a valid
   submatrix in the original matrix.

6) Repeat for all possible
   (top, bottom) row pairs.
 */
