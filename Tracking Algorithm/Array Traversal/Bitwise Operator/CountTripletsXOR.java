/*
Question:
LeetCode 1442 - Count Triplets That Can Form Two Arrays of Equal XOR

Given an array of integers arr, return the number of triplets (i, j, k) 
such that 0 <= i < j <= k < arr.length and the XOR of the elements 
from index i to j-1 is equal to the XOR of the elements from index j to k.

In other words, for a valid triplet:
    arr[i] ^ arr[i+1] ^ ... ^ arr[j-1] == arr[j] ^ arr[j+1] ^ ... ^ arr[k]

If this condition holds, then the triplet (i, j, k) is valid.

Return the total number of such triplets.

Example:
Input: arr = [2,3,1,6,7]
Output: 4

Explanation:
Valid triplets are:
(0,1,2), (0,2,2), (2,3,4), (2,4,4)

Example:
Input: arr = [1,1,1,1,1]
Output: 10

Constraints:
- 1 <= arr.length <= 300
- 0 <= arr[i] <= 10^8
*/

import java.util.*;

public class CountTripletsXOR {

// Brute Force ::: Time Complexity : O(n^3)
public static int countTriplets(int[] arr) {
    int count = 0;      // To keep track of counter
    int n = arr.length;// For fixed length of array

    for(int i = 0 ; i < n ; i++){
        for(int j = i+1;j<n ;j++){
            for(int k = j ;k< n ;k++){
                int left = 0;

                for(int x = i;x < j;x++){
                    left ^= arr[x];
                }

                int right = 0;
                for(int x = j;x <= k;x++){
                    right ^= arr[x];
                }

                if(left == right){
                    count++;
                }
            }
        }   
    }

    return count;
}

// Optimized Code ::: Time Complexity : O(n^2)
public static int countTripletsn2(int[] arr) {
    int n = arr.length;
    int count = 0;

    for (int i = 0; i < n; i++) {
         int xor=arr[i];
        for (int k = i +1; k < n; k++) {
            xor ^= arr[k];  // This works becuase if A = B Then A ^ B = 0
            if (xor == 0) {
                count += (k - i);
            }
        }
    }
    return count;
}

// Optimized Code ::: Time Complexity : O(n)
public static int countTripletsOn(int[] arr) {

        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> sum = new HashMap<>();

        int prefix = 0;
        int result = 0;

        freq.put(0, 1);
        sum.put(0, -1);

        for (int i = 0; i < arr.length; i++) {

            prefix ^= arr[i];

            if (freq.containsKey(prefix)) {

                int f = freq.get(prefix);   
                int s = sum.get(prefix);    
                result += (f * i - s - f);  
            }

            freq.put(prefix, freq.getOrDefault(prefix, 0) + 1);
            sum.put(prefix, sum.getOrDefault(prefix, 0) + i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 6, 7};
        int result = countTripletsOn(arr);

        System.out.println("Number of Triplets: " + result);
    }
}

/*
RECAP: Count Triplets That Can Form Two Arrays of Equal XOR

1) Brute Force Approach - O(n^3)
--------------------------------------------------
Idea:
- Try all possible (i, j, k)
- Split array into two parts:
    left  = i → j-1
    right = j → k
- Check if XOR(left) == XOR(right)

Time Complexity: O(n^3)
Why slow? Because we try every possible split point j for every (i, k)

--------------------------------------------------

2) Optimized Brute Force - O(n^2)
--------------------------------------------------
Idea:
- Fix starting point i
- Expand ending point k
- Maintain running XOR from i → k

Key Insight:
If XOR(i → k) == 0
→ then ALL j in (i+1 → k) are valid split points

So:
count += (k - i)

Time Complexity: O(n^2)
Why faster? We eliminated the inner loop j

--------------------------------------------------

3) Optimal Solution (Prefix XOR + HashMap) - O(n)
--------------------------------------------------
Idea:
- Use prefix XOR to detect repeated XOR states
- If prefix[i] == prefix[k]
  → XOR between them is 0

We store:
- freq[prefix] → how many times seen
- sum[prefix]  → sum of indices

Contribution formula:
result += (f * i - s - f)

Where:
- f = frequency of same prefix
- s = sum of indices where it appeared
- i = current index

Time Complexity: O(n)
Why fastest?
Because we convert repeated scanning into constant-time lookup using HashMap

--------------------------------------------------

FINAL SUMMARY:
- O(n^3): try all splits explicitly
- O(n^2): remove j using XOR property
- O(n): remove k using prefix XOR + HashMap
*/

