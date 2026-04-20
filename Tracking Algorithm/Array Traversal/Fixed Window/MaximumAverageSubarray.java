/*
Problem : Maximum Average Subarray I
Leetcode : 643

Given an integer array nums consisting of n elements, and an integer k, 
Find a contiguous subarray whose length is equal to k that has the maximum average value.

Return this maximum average value.

Any answer with a calculation error less than 10^-5 will be accepted.

A subarray is a contiguous sequence of elements within an array.

*/

public class MaximumAverageSubarray {

    // Brute force Time Complexsity O(n^2)
    // public static double getMaxSum(int[] nums, int k) {
    // double maxAvg = Double.NEGATIVE_INFINITY;
    // for (int i = 0; i <= nums.length - k; i++) {

    // double sum = 0.0;
    // int count = 0;

    // for (int j = i; j < nums.length; j++) {
    // sum += nums[j];
    // count++;

    // if (count == k) {
    // double avg = sum / k;
    // maxAvg = Math.max(maxAvg, avg);
    // break;
    // }

    // }
    // }

    // return maxAvg;
    // }

    public static double getMaxSum(int[] nums, int k) {

        int right = 0;
        Double sum = 0.0;

        while (right < k) {
            sum += nums[right];
            right++;
        }
        Double maxAvg = sum / k;

        right = k;
        while (right < nums.length) {
            sum += nums[right] - nums[right - k];
            maxAvg = Math.max(maxAvg, sum / k);
            right++;
        }
        return maxAvg;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 12, -5, -6, 50, 3 };
        int k = 4;

        double result = getMaxSum(nums, k);
        System.out.println("Maximum average value is ::: " + result);
    }
}

/*
Approach : Fixed Sliding Window

- Window size is fixed (k), so we don't expand/shrink dynamically
- First, calculate sum of first k elements (initial window)
- Then slide the window one step at a time:
    - Add next element (nums[right])
    - Remove previous element (nums[right - k])
- At each step, update max result (sum or average)

Key Idea:
- Window size always remains k
- No need of left pointer explicitly
- No while loop needed (unlike variable window)

Time Complexity : O(n)
Space Complexity : O(1)

Important Line:
sum += nums[right] - nums[right - k];

*/ 

