/*
Question:
LeetCode 53 - Maximum Subarray

Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

Example:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum = 6.

Example:
Input: nums = [1]
Output: 1

Example:
Input: nums = [5,4,-1,7,8]
Output: 23
*/

public class MaximumSubarray {
    // public static int maxSubArray(int[] nums) {

    //     int currentSum = 0;
    //     int maxSum = Integer.MIN_VALUE;
    //     int pointer = 0;
    //         while(pointer < nums.length){
    //         currentSum = Math.max(nums[pointer], currentSum + nums[pointer]);
    //         maxSum = Math.max(maxSum, currentSum);
    //         pointer++;
    //     }

    //     return maxSum;
    // }

    public static int maxSubArray(int[] nums) {

        int currentSum =0;
        int maxSum = 0;
        int pointer = 0;
        while(pointer < nums.length){
            currentSum = Math.max(nums[pointer], currentSum + nums[pointer]);
            maxSum = Math.max(maxSum, currentSum);
            pointer++;
        }
        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        //int[] nums = {2, -1, 3};
        int result = maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + result);
    }
}

/*
 * Recap (Kadane’s Algorithm):
 * 
 * - Use two variables:
 * currentSum → max sum ending at current index
 * maxSum → overall maximum sum
 * 
 * - Traverse array:
 * currentSum = max(nums[i], currentSum + nums[i])
 * maxSum = max(maxSum, currentSum)
 * 
 * - If current sum becomes worse, start new subarray from current element
 * 
 * - Time Complexity: O(n)
 * - Space Complexity: O(1)
 * 
 * Key Idea:
 * At each index → decide:
 * “Extend previous subarray OR start fresh from here”
 */

