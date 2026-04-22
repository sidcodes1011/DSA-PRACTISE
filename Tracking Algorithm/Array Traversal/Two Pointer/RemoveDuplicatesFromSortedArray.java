/*
Question:
LeetCode 26 - Remove Duplicates from Sorted Array

Given a sorted integer array nums, remove the duplicates in-place such that 
each unique element appears only once. The relative order of elements should remain the same.

Return the number of unique elements k.

Modify the array such that the first k elements contain the unique elements.
The remaining elements beyond k are not important.

Example:
Input: nums = [1,1,2]
Output: 2  (nums = [1,2,_])

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5  (nums = [0,1,2,3,4,_...])
*/

public class RemoveDuplicatesFromSortedArray {
    
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
        if (nums[j] != nums[i]) {
            i++;
            nums[i] = nums[j];
        }
    }
    return i + 1;
    }

    public static void main(String[] args) {
        
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int result = removeDuplicates(nums);

        System.out.println("The Number of unique elements are " + result);

    }
}

/*
Recap:
- Use Two Pointer approach (Slow pointer i, Fast pointer j)
- j traverses the array, i tracks position of last unique element
- If nums[j] != nums[i], increment i and place nums[j] at nums[i]
- This keeps only unique elements in the front of the array
- Return i + 1 as the count of unique elements (k)
- Only first k elements are important; rest can be ignored
- Time Complexity: O(n)
- Space Complexity: O(1)
*/

