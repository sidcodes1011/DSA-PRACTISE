/*
Question:
LeetCode 704 - Binary Search

Given a sorted (ascending) integer array nums and an integer target,
return the index of target if it exists, otherwise return -1.

You must write an algorithm with O(log n) runtime complexity.

Example:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4

Example:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
*/


public class BinarySearch {
    
    public static int Binarysearch (int[] nums,int target){

        int index= -1;
        int leftPointer = 0;
        int rightPointer = nums.length -1 ;

        while (leftPointer <= rightPointer){

            int mid = (leftPointer + rightPointer)/ 2;

            if (nums[mid] == target){
                return mid;
            }
            else if(nums[mid]< target) {
                leftPointer++;
            }
            else{
                rightPointer--;
            }
        }
    
        return index;
    }
      public static void main(String[] args) {

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        int result = Binarysearch(nums, target);

        System.out.println("Index: " + result);
    }

}

/*
Recap:

- Use Binary Search (divide and conquer)
- Maintain two pointers:
    left = 0
    right = n - 1

- While left <= right:
    mid = left + (right - left) / 2   // avoid overflow

    if nums[mid] == target → return mid
    if nums[mid] < target → search right half → left = mid + 1
    if nums[mid] > target → search left half → right = mid - 1

- If not found → return -1

- Time Complexity: O(log n)
- Space Complexity: O(1)

Key Idea:
At every step → eliminate half of the array
*/

