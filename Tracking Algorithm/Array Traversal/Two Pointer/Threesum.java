/*
Problem : 3Sum
Leetcode : 15

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
such that:
    i != j, i != k, and j != k
    nums[i] + nums[j] + nums[k] == 0

The solution set must not contain duplicate triplets.

Example:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2], [-1,0,1]]
*/

import java.util.*;

public class Threesum {

    public static List<List<Integer>> threeSumCalculator(int[] nums){

        if (nums == null || nums.length < 3) return new ArrayList<>(); 
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length; i++){

            int left = i + 1;
            int right = nums.length -1;
            while (left < right) {            
                int prefixSum =  nums[i] + nums[left] + nums[right];
                if (prefixSum == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left ++;
                    right--;
                }
                else if (prefixSum < 0){
                    left ++;
                }
                else {
                    right --;
                }
            }     
        }
        return new ArrayList<>(result);
    }


    public static void main(String[] args) {
        System.out.println("Inside main");

        int [] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> result = threeSumCalculator(nums);

        System.out.println("All the triplets in given array is ::: " + result );

    }
}

/*
Approach: Sorting + Two Pointer

1. Sort the array

2. Fix one element (i)
   → Now problem becomes 2Sum for remaining array

3. Use two pointers:
   left = i + 1
   right = n - 1

4. Check sum:
   sum = nums[i] + nums[left] + nums[right]

   if sum == 0 → add triplet, move both pointers
   if sum < 0 → increase sum → left++
   if sum > 0 → decrease sum → right--

5. Skip duplicates:
   - Skip same i values
   - Skip same left/right values after finding triplet

Time Complexity: O(n²)
Space Complexity: O(1) (excluding output)
*/

