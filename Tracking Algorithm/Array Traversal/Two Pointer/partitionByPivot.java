/*
Question:
LeetCode 2161 - Partition Array According to Given Pivot

Given a 0-indexed integer array nums and an integer pivot, rearrange the array such that:

1. All elements less than pivot come first.
2. All elements equal to pivot come next.
3. All elements greater than pivot come last.

Additionally, the relative order of elements less than pivot and greater than pivot must be maintained.

Return the rearranged array.

Example:
Input: nums = [9,12,5,10,14,3,10], pivot = 10
Output: [9,5,3,10,10,12,14]
*/

import java.util.Arrays;

class partitionByPivot {

    public static int[] pivotArray(int[] nums, int pivot) {

        int lowCount = 0, pivotCount = 0;

        for (int num : nums) {
            if (num < pivot) lowCount++;
            else if (num == pivot) pivotCount++;
        }

        int startIndex = 0;                  
        int pivotIndex = lowCount;             
        int greaterIndex = lowCount + pivotCount;    

        int[] result = new int[nums.length];

        for (int num : nums) {
            if (num < pivot) {
                result[startIndex] = num;
                startIndex++;
            } else if (num > pivot) {
                result[greaterIndex] = num;
                greaterIndex++;
            } else {
                result[pivotIndex] = num;
                pivotIndex++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;

        int[] result = pivotArray(nums, pivot);

        System.out.println("Result: " + Arrays.toString(result));
    }
}

/*
Recap:
- Count elements < pivot and == pivot to determine starting indices
- Use 3 pointers:
    i → for elements < pivot
    j → for elements == pivot
    k → for elements > pivot

- Traverse array once more:
    → if num < pivot → place at i++
    → if num == pivot → place at j++
    → if num > pivot → place at k++

- Maintains relative order (stable)
- Time Complexity: O(n)
- Space Complexity: O(n)
*/

