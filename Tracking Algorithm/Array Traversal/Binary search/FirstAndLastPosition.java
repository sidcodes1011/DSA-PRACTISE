/*
Question:
LeetCode 34 - Find First and Last Position of Element in Sorted Array

Given a sorted array nums (ascending) and a target value,
find the starting and ending position of the target.

If target is not found, return [-1, -1].

You must write an algorithm with O(log n) time.

Example:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/

import java.util.*;

public class FirstAndLastPosition {

    public static int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[] { first, last };
    }

    public static int findFirst(int[] nums, int target) {

        int pointerLeft = 0;
        int pointerRight = nums.length -1;
        int result = -1;

        while(pointerLeft <= pointerRight){

            int mid = (pointerLeft + pointerRight)/2;

            if(nums[mid] == target){
                result = mid;
                pointerRight = mid - 1;
            }
            else if(nums[mid]< target){
                pointerLeft = mid + 1;
            }
            else{
                pointerRight = mid -1;
            }
        }
        return result;
    }

    public static int findLast(int[] nums, int target) {

        int pointerLeft = 0;
        int pointerRight = nums.length -1;
        int result = -1;

        while(pointerLeft <= pointerRight){

            int mid = (pointerLeft + pointerRight)/2;

            if(nums[mid] == target){
                result = mid;
                pointerLeft = mid + 1;
            }
            else if(nums[mid]< target){
                pointerLeft =  mid + 1;
            }
            else{
               pointerRight = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        int[] result = searchRange(nums, target);

        System.out.println("Result: " + Arrays.toString(result));
    }
}

/*
Recap:

- Use Binary Search TWICE:
    1. Find FIRST occurrence
    2. Find LAST occurrence

- For first occurrence:
    → move LEFT even after finding target
    → right = mid - 1

- For last occurrence:
    → move RIGHT even after finding target
    → left = mid + 1

- Time Complexity: O(log n)
- Space Complexity: O(1)

Key Idea:
Don’t stop at first match → expand to boundaries using binary search
*/

