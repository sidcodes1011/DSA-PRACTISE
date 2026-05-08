/* 
Problem Statement :
Given an array of integers arr[] and a number k, 
the task is to count the number of subarrays having XOR of their elements as k.

Input: arr[] = [4, 2, 2, 6, 4], k = 4
Output: 4
Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6].

Input: arr[] = [5, 6, 7, 8, 9], k = 5
Output: 2
Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9].

*/

import java.util.*;

public class CountXorEqualsK {

    // Brute force Time complexity : O(n^2)
    public static int xorEqualKOn2 (int []arr , int target ){
        int count = 0;
        int xor = 0;

        for(int i = 0 ; i < arr.length;i++){
            xor= 0;
            for(int j = i ; j< arr.length;j++){
                
                xor ^= arr[j];
                if (xor == target){
                    count++;
                }
            }
        }
        return count;
    }
    // Optimized code Time Complexity : O(n)
    public static int xorEqualK (int []arr , int target ){

        int count = 0;
        int xor = 0;
        Map <Integer,Integer> st = new HashMap<>();
        st.put(0,1);

        for(int i = 0; i < arr.length;i++){
            xor ^= arr[i];
            int need = xor ^ target;     
            if(st.containsKey(need)){
                count += st.get(need);
            }
            st.put(xor,st.getOrDefault(xor,0)+1);
        }
        return count;
    }
    public static void main (String args []){

        int [] arr ={4, 2, 2, 6, 4};
        int target = 4;

        int result = xorEqualK(arr,target);

        System.out.println("The No of subarrays whose xor is " +target+ " is " + result);

    }
}

/*
XOR Subarray with Target - Prefix XOR + HashMap

Core Idea:
-----------
Instead of calculating XOR for every subarray,
we use PREFIX XOR.

Formula:
---------
subarrayXor = currentPrefixXor ^ previousPrefixXor

If:
currentPrefixXor ^ previousPrefixXor = target

Then:
the subarray between them has XOR = target.

---------------------------------------------------

Mental Approach:
----------------

1) Traverse array and keep calculating PREFIX XOR.

2) At every index ask:

   "What previous prefix XOR do I need
    so that together with current XOR
    it becomes target?"

3) Needed XOR is:

   need = currentXor ^ target

4) Check hashmap:
   
   If 'need' already exists,
   then valid subarray(s) found.

5) Why count += map.get(need)?

   Because same prefix XOR may appear
   multiple times earlier.

   Every occurrence forms one valid subarray.

6) Store current prefix XOR into hashmap
   so future indices can use it.

---------------------------------------------------

Why Formula Works:
------------------

prefix[R]     = a ^ b ^ c ^ d ^ e
prefix[L - 1] = a ^ b

XOR them:

(a ^ b ^ c ^ d ^ e) ^ (a ^ b)

Same values cancel:

a ^ a = 0
b ^ b = 0

Remaining:

c ^ d ^ e

which is subarray XOR.

---------------------------------------------------

Important:
-----------

Map stores:
"How many times each PREFIX XOR occurred"

NOT subarray XORs.
*/
