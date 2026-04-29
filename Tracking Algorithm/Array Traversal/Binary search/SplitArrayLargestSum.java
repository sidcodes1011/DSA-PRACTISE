package localrun;

/*
Question:
LeetCode 410 - Split Array Largest Sum

Given an integer array nums and an integer k, split the array into k non-empty
contiguous subarrays.

Your task is to minimize the largest sum among these k subarrays.

Return the minimized largest sum.

Example:
Input: nums = [7,2,5,10,8], k = 2
Output: 18

Explanation:
The best split is [7,2,5] and [10,8]
First subarray sum = 14
Second subarray sum = 18
Maximum = 18 (minimum possible)

Example:
Input: nums = [1,2,3,4,5], k = 2
Output: 9

Explanation:
Best split is [1,2,3] and [4,5]
Max sum = 9

Example:
Input: nums = [3,6,2,8,4], k = 2
Output: 12
*/

public class SplitArrayLargestSum {

    public static int arraySplitCounter(int[] nums, int mid) {

        int sum = 0;
        int splitArrayCnt = 1;
        for (int num : nums) {

            if (sum + num <= mid) {
                sum += num;
            } else {
                sum = num;
                splitArrayCnt++;
            }
        }
        return splitArrayCnt;
    }

    public static int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;
        for (int l : nums) {
            low = Math.max(low, l);
            high += l;
        }
        System.out.println("low :: " + low);
        System.out.println("high ::" + high);

        while (low < high) {
            int mid = (low + high) / 2;
            int noOfSplitArray = arraySplitCounter(nums, mid);

            if (noOfSplitArray <= k) {

                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {

        int[] nums = { 3, 4, 5, 6, 7 };
        int split = 2;

        int result = splitArray(nums, split);
        System.out.println("The minimized largest sum of the split is " + result);
    }
}

/*
Short Recap:

* Goal: Minimize the maximum subarray sum

* Approach: Binary Search on Answer

Steps:

1. Set range:
   low = max element
   high = sum of array

2. Take mid as candidate max sum

3. Count how many subarrays needed such that
   no subarray sum exceeds mid

4. Decision:
   if splits <= k → valid → try smaller (high = mid)
   else → invalid → increase (low = mid + 1)

Final Answer:
low (or high) gives minimized largest sum

Key Idea:
"Minimize the maximum → Binary Search on Answer"
*/

