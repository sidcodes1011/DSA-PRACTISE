import java.util.HashMap;
import java.util.Map;

/*
 Problem : Subarray Sums Divisible by K
 Leetcode : 974 

Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
A subarray is a contiguous part of an array.

*/

public class SubarraySumDivisibleK {

	public static int subarrayDiVCount(int[] nums, int k) {
	    Map<Integer, Integer> map = new HashMap<>();
	    map.put(0, 1); // Hashing

	    int prefixSum = 0;
	    int count = 0;

	    for (int num : nums) {
	        prefixSum += num;
	        
	        int remainder = (prefixSum % k + k) % k ;
	        
	        if (map.containsKey(remainder)) {
	            count += map.get(remainder);
	        }

	        map.put(remainder, map.getOrDefault(remainder, 0) + 1);
	    }
	    return count;
	}
	
//	public static int subarrayDiVCount(int[] nums, int k) {
//		
//		int count =0;
//		for (int i = 0; i < nums.length; i++) {
//
//			int sum = 0;
//
//			for (int j = i; j < nums.length; j++) {
//				sum += nums[j];
//
//				if (sum % k == 0) {
//					count++;
//				}
//			}
//		}
//		return count;
//	}
	
	public static void main(String[] args) {
		
		
		int nums[] = {4,5,0,-2,-3,1};
		int divFactor = 5;
		int result =subarrayDiVCount(nums,divFactor);
		
		System.out.println("The count of subArray who are divisible by " +divFactor+ " is ::: " + result );
	}
}

/*
====================== 🔥 SHORT RECAP ======================

1. Core Idea:
   If (prefixSum[i] % k == prefixSum[j] % k)
   → subarray (i to j) sum is divisible by k

2. Trick:
   Convert prefixSum into remainder space:
   remainder = (prefixSum % k + k) % k

3. Why HashMap?
   Store frequency of remainders
   Same remainder → valid subarray count increases

4. Key Line:
   count += map.get(remainder);

5. Initialization:
   map.put(0, 1); 
   → handles subarrays starting from index 0

6. Time & Space:
   Time: O(n)
   Space: O(k) (in worst case)

7. Mental Model:
   Not checking subarrays directly,
   counting equal remainders

============================================================
*/


