/*
Question:
LeetCode 33 - Search in Rotated Sorted Array

Given an integer array nums sorted in ascending order, but rotated at some pivot unknown to you beforehand,
and an integer target, return the index of target if it exists in the array. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

A rotated array means the array was originally sorted, but then shifted at some pivot.
Example: [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]

Example:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example:
Input: nums = [1], target = 0
Output: -1
*/


public class RotatedArraySort {
    
    public static int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length -1;
        while(low <= high){

            int mid = (low + high)/2;

            if (nums[mid] == target){
                return mid;
            }

            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <=nums[mid]){
                    high = mid -1;
                }
                else{
                    low = mid +1;
                }
            }
            else{
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid -1;
                }
            }
        }

        return -1;
    }

  
    public static void main(String[] args) {
        
        System.out.println("Inside Main");
        int [] nums ={4,5,6,7,0,1,2};
        int target = 4;

        int result = search(nums,target);

        System.out.println("The target is found at " + result+ " index");
        
    }
}

// Recap:
// If left half (low → mid) is sorted AND target is NOT in that range,
// then we ignore the left half and move to the right side.
// So we do: low = mid + 1
//
// Condition:
// nums[low] <= nums[mid]  → left side sorted
// BUT target < nums[low] OR target > nums[mid]
//
// Meaning:
// Target must be in right half

