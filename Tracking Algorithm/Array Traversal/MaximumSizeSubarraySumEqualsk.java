/*
Problem : Maximum Size Subarray Sum Equals k
Leetcode : 325 

Given an integer array nums and an integer k, 
return the maximum length of a contiguous subarray that sums to k.
If there is no such subarray, return 0.

A subarray is a contiguous part of an array.
 */

import java.util.*;

public class MaximumSizeSubarraySumEqualsk {

    // Brute forcwe approach Time Complexity O(n^2)
    // public static int maxSubArrayLen(int[] nums, int k) {
    //     int maxLength = 0;
    //     int lengthTemp = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         int sum = 0;
    //         for (int j = i; j < nums.length; j++) {
    //             sum += nums[j];
    //             if (sum == k) {
    //                 lengthTemp = j - i + 1;
    //                 if (lengthTemp >= maxLength) {
    //                     maxLength = lengthTemp;
    //                 }
    //             }
    //         }
    //     }
    //     return maxLength;
    // }
    public static int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (map.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - k));
            }
            map.putIfAbsent(prefixSum, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {

        int[][] testCases = {
            {1, -1, 5, -2, 3},
            {-2, -1, 2, 1},
            {1, 2, 3},
            {2, 3, -2, 5},
            {3},
            {0, 0, 0, 0},
            {-1, 2, 3, -2, 5, -3}
        };

        int[] sums = {3, 1, 7, 8, 3, 0, 5};

        for (int i = 0; i < testCases.length; i++) {
            int result = maxSubArrayLen(testCases[i], sums[i]);
            System.out.println("Test " + (i + 1) + " Output: " + result);
        }
    }
}
