/*
Question:
LeetCode 560 - Subarray Sum Equals K

** Not a kedan but Concept: Subarray Sum using Prefix + HashMap **

Given an integer array nums and an integer k, return the total number 
of continuous subarrays whose sum equals to k.

A subarray is a contiguous part of an array.

Example:
Input: nums = [1,1,1], k = 2
Output: 2
Explanation: Subarrays are [1,1] and [1,1]

Example:
Input: nums = [1,2,3], k = 3
Output: 2
Explanation: Subarrays are [1,2] and [3]
*/

import java.util.*;

public class SubarraySumK {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;
        for (int num : nums) {
            prefixSum+= num;

            if(map.containsKey(prefixSum -k)){
                count += map.get(prefixSum - k);
            }
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 1, 1 };
        int k = 2;
        int result = subarraySum(nums, k);

        System.out.println("Total subarrays with sum k: " + result);
    }
}

/*
Recap:
- Use Prefix Sum + HashMap

- Idea:
    If prefixSum[j] - prefixSum[i] = k
    → then subarray (i+1 to j) has sum k

- Maintain:
    currentSum = running sum
    map stores (prefixSum → frequency)

- For each element:
    → currentSum += nums[i]
    → check if (currentSum - k) exists in map
        → if yes, add its frequency to count
    → store currentSum in map

- Initialize map with (0 → 1) to handle exact matches

- Time Complexity: O(n)
- Space Complexity: O(n)
*/

