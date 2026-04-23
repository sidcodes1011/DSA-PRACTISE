/*
Question:
LeetCode 283 - Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining 
the relative order of the non-zero elements.

You must do this in-place without making a copy of the array.

Example:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example:
Input: nums = [0]
Output: [0]
*/

import java.util.Arrays;

public class MoveZeroes {

    public static int[] moveZerosAtEnd(int[] nums) {

        int left = 0;
        for (int right = 0 ; right < nums.length; right ++){
            if (nums[right] != 0){               
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp; 
                left++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {

        int[] arr = { 0, 1, 0, 3, 12 };

        int [] result = moveZerosAtEnd(arr);

        System.out.println("The array with shifted zero is " + Arrays.toString(result));

    }
}

/*
Recap - Move Zeroes (LeetCode 283)

- Goal: Move all 0's to the end of the array while keeping the order of non-zero elements.
- Must be done in-place (no extra array).

Key Idea:
- Use Two Pointers (left & right)

Approach:
- left → position where next non-zero should be placed
- right → scans the entire array

Process:
- If nums[right] != 0:
    → swap nums[right] with nums[left]
    → increment left
- right always moves forward

Why right = 0?
- Because we need to check EVERY element from the start
- Unlike some problems, we are not skipping index 0 here

Result:
- All non-zero elements are shifted to the front
- Zeros naturally move to the end

Time Complexity: O(n)
Space Complexity: O(1)
*/

