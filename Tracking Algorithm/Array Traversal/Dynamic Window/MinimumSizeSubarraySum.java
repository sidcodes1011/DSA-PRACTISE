
/*
 Problem : Minimum Size Subarray Sum
 Leetcode : 209

Given an array of positive integers nums and a positive integer target, 
return the minimal length of a subarray whose sum is greater than or equal to target. 

If there is no such subarray, return 0 instead.

A subarray is a contiguous non-empty sequence of elements within an array.

 */
public class MinimumSizeSubarraySum {

    // Brute Force Approach Time Complexity O(n^2) 
    // public static int minSubArrayLen(int target, int[] nums) {
    //     int minlength = Integer.MAX_VALUE;
    //     for (int i = 0; i < nums.length; i++) {
    //         int sum = 0;
    //         for (int j = i; j < nums.length; j++) {
    //             sum += nums[j];
    //             if (sum >= target) {
    //                 minlength = Math.min(minlength, j - i + 1);
    //                 break;
    //             }
    //         }
    //     }
    //     return minlength == Integer.MAX_VALUE ? 0 : minlength;
    // }
    
    //Optimized Approach Time Complexity O(n)
    public static int minSubArrayLen(int target, int[] nums) {

        int minLenWindow = Integer.MAX_VALUE;
        int sum = 0;
        int pointerA = 0;
        int pointerB = 0;

        while (pointerA < nums.length) {

            sum += nums[pointerA];
            pointerA++;

            while (sum >= target) {

                int CurrentWindowSize = pointerA - pointerB;
                minLenWindow = Math.min(minLenWindow, CurrentWindowSize);

                sum -= nums[pointerB];
                pointerB++;
            }
        }

        return minLenWindow == Integer.MAX_VALUE ? 0 : minLenWindow;
    }

    public static void main(String[] args) {
        System.out.println("Working !!!");

        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;

        int resultLength = minSubArrayLen(target, nums);

        System.out.println("The minimium size of Subarray of sum " + target + " is ::: " + resultLength);
    }
}

/*
===================== 🔥 QUICK RECAP =====================

✔ Problem Type:
- Contiguous subarray
- Find MINIMUM length
→ Use Sliding Window (Variable Window)

✔ Key Idea:
- Expand window (pointerA) to increase sum
- When sum >= target → shrink window (pointerB)
- Update minimum length while shrinking

✔ Why it works:
- All numbers are POSITIVE
→ Sum only increases when expanding
→ Safe to shrink greedily

✔ Complexity:
- Time → O(n)
- Space → O(1)

✔ One Line Intuition:
→ "Expand to reach target, shrink to minimize length"

==========================================================
 */
