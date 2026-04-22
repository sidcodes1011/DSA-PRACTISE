/*
Problem : Two Sum II (Input Array Is Sorted)
Leetcode : 167

Given a 1-indexed array of integers `numbers` that is already sorted 
in non-decreasing order, find two numbers such that they add up to 
a specific `target` number.

Return the indices of the two numbers (1-based index) as an integer 
array [index1, index2] such that:

- index1 < index2
- numbers[index1] + numbers[index2] == target

You may assume that each input would have exactly one solution, 
and you may not use the same element twice.

Your solution must use only constant extra space.

Example:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]

Explanation:
2 + 7 = 9 → indices are 1 and 2

*/

import java.util.Arrays;

public class TwoSum {
    
    public static int[] BruteForce(int [] numbers, int target){
    int [] result = new int[2]; 
    Boolean flag = false;
    for(int i = 0 ; i< numbers.length;i++){
        int prefixSum = 0;
        for(int j = i + 1;j <numbers.length; j++ ){

            prefixSum = numbers[i] + numbers[j];

            if (prefixSum == target){
            result[0] = i + 1;
            result[1] = j + 1;
            flag = true;
            break;
            }
        }
        if(flag){
            break;
        }
    }
    return result;
    }


    // Optimal Approach With time Complexity of O(n)
    public static int[] TwoSumIdentifier(int [] numbers, int target){
        int [] result = new int[2];
        int left = 0;
        int right = numbers.length -1;
        
        while (left < right){
        int prefixSum = 0;
        prefixSum = numbers[right] + numbers[left];
        if(prefixSum > target){
            right--;
        }
        else if(prefixSum < target){
            left++;
        }
        else{
            result[0] = left;
            result[1] = right;
            break;
        }

        }
        return result;
    }

    public static void  main (String args []){

        System.out.println("Inside main ");

        int [] numbers = {2,7,11,15};
        int target = 9;

        int [] result = BruteForce(numbers,target);
        int [] result1 = BruteForce(numbers,target);
        System.out.println("The index of number for sum "+ target + " is " + Arrays.toString(result));
        System.out.println("The index of number for sum "+ target + " is " + Arrays.toString(result1));
    }
}

/*
Recap (Two Sum II - Sorted Array)

- Use Two Pointer approach
    left = 0, right = n - 1

- While left < right:
    sum = numbers[left] + numbers[right]

    if sum == target → return indices (left+1, right+1)
    if sum < target → move left++ (need bigger sum)
    if sum > target → move right-- (need smaller sum)

- Why it works:
    Array is sorted → we can adjust pointers intelligently

- Time Complexity: O(n)
- Space Complexity: O(1)

- Key Points:
    * Always use left < right
    * Return 1-based index
    * Do NOT use same element twice
*/

