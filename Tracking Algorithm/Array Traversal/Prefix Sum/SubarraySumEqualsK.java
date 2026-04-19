import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 Problem : Subarray Sum Equals K
 Leetcode : 560 

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.

 */

public class SubarraySumEqualsK {

	// Normal approch  Time complexity  ::: O(n^2)
/*	public static int subarraySumCount(int[] nums, int k) {

		int count = 0;

		for (int i = 0; i < nums.length; i++) {

			int sum = 0;

			for (int j = i; j < nums.length; j++) {
				sum += nums[j];

				if (sum == k) {
					count++;
				}
			}
		}
		return count;
	}
*/
	
	// Approach for time complexity O(n)
	public static int subarraySumCount(int[] nums, int k) {
	    Map<Integer, Integer> map = new HashMap<>();
	    map.put(0, 1);

	    int prefixSum = 0;
	    int count = 0;

	    for (int num : nums) {
	        prefixSum += num;

	        if (map.containsKey(prefixSum - k)) {
	            count += map.get(prefixSum - k);
	        }

	        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
	    }
	    return count;
	}
	

	public static void main(String[] args) {

		int nums[] = {0,3,3};
		int sum = 3;
		int result =subarraySumCount(nums,sum);

		System.out.println("The count of pair resulting ::: " +sum+ " is " + result);
	}
}

/*
===================== 🔥 QUICK RECAP =====================

✔ Problem:
Count number of subarrays with sum = k

✔ Key Concept:
Use PREFIX SUM + HASHMAP (frequency map)

✔ Core Logic:
If:
    prefixSum[j] - prefixSum[i] = k
Then:
    prefixSum[i] = prefixSum[j] - k

✔ So:
For every prefixSum,
check if (prefixSum - k) exists in map

✔ Why map.put(0,1)?
Handles subarrays starting from index 0

✔ getOrDefault(prefixSum, 0):
If prefixSum not present → treat frequency as 0

✔ Time Complexity:
O(n)

✔ Space Complexity:
O(n)

✔ Important:
Works with NEGATIVE numbers (Sliding Window fails here)

✔ Pattern:
"Count subarrays" + "Sum = K" → Think PREFIX SUM + HASHMAP

==========================================================
*/


