/*
Question:
LeetCode 75 - Sort Colors

Given an array nums with n objects colored red, white, or blue, 
sort them in-place so that objects of the same color are adjacent, 
with the colors in the order red (0), white (1), and blue (2).

You must solve this problem without using the library's sort function.

Example:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example:
Input: nums = [2,0,1]
Output: [0,1,2]
*/

import java.util.Arrays;

public class sortColor {

    public static void swap(int[] arr, int vara, int varb) {

        int temp = arr[vara];
        arr[vara] = arr[varb];
        arr[varb] = temp;
    }

    public static int[] sortColorHelper(int[] arr) {

        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while (mid <= right) {

            switch (arr[mid]) {
                case 0:
                    swap(arr, mid, left);
                    left++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    swap(arr, mid, right);
                    right--;
                    break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] nums = { 2, 0, 2, 1, 1, 0 };

        int[] result = sortColorHelper(nums);

        System.out.println(Arrays.toString(result));
    }
}


/*
Recap:
- Use 3 pointers: left (for 0), mid (current), right (for 2)
- Traverse while mid <= right

- If nums[mid] == 0:
    → swap with left
    → left++, mid++

- If nums[mid] == 1:
    → just move mid++

- If nums[mid] == 2:
    → swap with right
    → right-- (do NOT increment mid here)

- This is called Dutch National Flag Algorithm
- Time Complexity: O(n)
- Space Complexity: O(1)
*/

