/*
Problem : Maximum Sum Subarray of Size K

Given an array of integers arr and an integer k, 
find the maximum sum of any contiguous subarray of size k.

A subarray is a contiguous part of the array.

Return the maximum possible sum.

Example:
Input: arr = [2, 1, 5, 1, 3, 2], k = 3  
Output: 9  
Explanation: Subarray [5,1,3] has the maximum sum = 9
*/

public class MaximumsumofsizeK {
    
    // Brute Force Time Complexity O(n^2)
    // public static int helprFn(int [] nums,int target){
    //     int maxSum = 0;
    //     for(int i = 0 ; i <= nums.length - target;i++){
    //         int prefixSum =0;
    //         int count =0;
    //         for(int j = i;j < i+target ;j++){
    //             prefixSum+= nums[j];
    //             count++;
    //             if(count == target){
    //                 maxSum = Math.max(maxSum, prefixSum);
    //             }
    //         }
    //     }
    //     return maxSum;
    // }

    // Optimized Code with Time Complexity O(n)
    public static int helprFn(int [] nums,int target){
        int right = 0;
        int sum = 0;

        while(right < target){
            sum+= nums[right];
            right++;
        }
        int maxSum = sum;
        right = target;
        while (right < nums.length) {
            sum += nums[right] - nums[right - target];
            maxSum = Math.max(maxSum, sum);
            right ++;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        
       int  target =  3;
       int [] nums = {2, 1, 5, 1, 3, 2};

       int result = helprFn(nums,target);

       System.out.println("Result ::: " + result);
    }
}


/*
Approach: Fixed Sliding Window

1. Window size k is fixed (target), it never changes.
2. First, calculate sum of first k elements (initial window).
3. Then slide the window:
   - Add next element (nums[right])
   - Remove previous element (nums[right - k])
4. Update maxSum at each step.
5. Time Complexity: O(n), Space: O(1)
*/

