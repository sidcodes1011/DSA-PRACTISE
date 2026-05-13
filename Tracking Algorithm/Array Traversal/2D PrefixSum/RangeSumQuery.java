/*
Question:
LeetCode 304 - Range Sum Query 2D - Immutable

Given a 2D matrix, handle multiple queries where each query asks for:

"Find the sum of all elements inside a rectangle."

The rectangle is defined by:
- Top-left corner  -> (row1, col1)
- Bottom-right corner -> (row2, col2)

You must make sumRegion() work in O(1) time.

--------------------------------------------------

Example:

Matrix:
[
  [3,0,1,4,2],
  [5,6,3,2,1],
  [1,2,0,1,5],
  [4,1,0,1,7],
  [1,0,3,0,5]
]

Query:
sumRegion(2,1,4,3)

Rectangle:
[
  [2,0,1],
  [1,0,1],
  [0,3,0]
]

Output:
8
*/
public class RangeSumQuery {

    int[][] prefix;

    public RangeSumQuery(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        prefix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                int top = (i > 0) ? prefix[i - 1][j] : 0;

                int left = (j > 0) ? prefix[i][j - 1] : 0;

                int diagonal = (i > 0 && j > 0)
                        ? prefix[i - 1][j - 1]
                        : 0;

                prefix[i][j] = matrix[i][j]
                        + top
                        + left
                        - diagonal;
            }
        }
    }

    public int sumRegion(int row1, int col1,
            int row2, int col2) {

        int total = prefix[row2][col2];

        int top = (row1 > 0)
                ? prefix[row1 - 1][col2]
                : 0;

        int left = (col1 > 0)
                ? prefix[row2][col1 - 1]
                : 0;

        int diagonal = (row1 > 0 && col1 > 0)
                ? prefix[row1 - 1][col1 - 1]
                : 0;

        return total - top - left + diagonal;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                { 3, 0, 1, 4, 2 },
                { 5, 6, 3, 2, 1 },
                { 1, 2, 0, 1, 5 },
                { 4, 1, 0, 1, 7 },
                { 1, 0, 3, 0, 5 }
        };

        RangeSumQuery obj = new RangeSumQuery(matrix);

        System.out.println(
                obj.sumRegion(2, 1, 4, 3)); // Output: 8

        System.out.println(
                obj.sumRegion(1, 1, 2, 2)); // Output: 11

        System.out.println(
                obj.sumRegion(1, 2, 2, 4)); // Output: 12
    }
}

/*
 * --------------------------------------------------
 * Approach:
 * Use 2D Prefix Sum.
 * 
 * prefix[i][j] stores sum of all elements
 * from (0,0) to (i,j).
 * 
 * This allows rectangle sum queries in O(1).
 * 
 * Time Complexity:
 * - Constructor: O(m * n)
 * - sumRegion(): O(1)
 * 
 * Space Complexity:
 * O(m * n)
 */
