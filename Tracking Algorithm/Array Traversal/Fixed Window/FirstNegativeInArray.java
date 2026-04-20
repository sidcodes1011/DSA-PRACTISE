/*
Problem : First Negative Integer in Every Window of Size K

Given an array arr[] and a positive integer k, 
find the first negative integer for each and every window (contiguous subarray) of size k.

For each window of size k:
- If there is a negative integer, return the first negative integer in that window.
- If there is no negative integer, return 0 for that window.

A window is a contiguous subarray of size k.

Return the result as an array containing answers for all windows.

*/

import java.util.*;

public class FirstNegativeInArray {

    // Brute Force with Time Complexity O(n^2)
    // public static List<Integer> getFirstNegativeArray(int arr[],int k){
    //     List<Integer> result = new ArrayList<>();
    //     for (int i = 0; i <= arr.length - k; i++) {
    //         Boolean flag = false;
    //         for (int j = i; j < i + k; j++) {
    //             if (arr[j] < 0) {
    //                 result.add(arr[j]);
    //                 flag = true;
    //             }            
    //         }
    //         if (!flag){
    //             result.add(0);
    //         }
    //     }
    //     return result;
    // }

   // Optimized code with Time complexity O(n)
    public static List<Integer> getFirstNegativeArray(int arr[],int k){
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        int left = 0;
        int right =0;

      while (right < arr.length) {

        if (arr[right] < 0) {
            dq.add(right); 
        }
        if (right - left + 1 == k) {

           
            if (dq.isEmpty()) {
                result.add(0);
            } else {
                result.add(arr[dq.peekFirst()]); 
            }

            // remove if out of window
            if (!dq.isEmpty() && dq.peekFirst() == left) {
                dq.pollFirst();
            }

            left++;
        }
        right++;
    }
        return result;
    }

    
    public static void main(String[] args) {
        
        System.out.println("Inside main!!");
        int arr[] = {-8, -2, 3, -6, 10};
        int  k = 2;

        List<Integer> result;

        result = getFirstNegativeArray(arr,k);

        System.out.println("The result as an array containing first negative are ::: "+result);
        }
}

/*
Approach : Fixed Sliding Window + Deque

- Window size is fixed (k)
- Use Deque to store indices of negative elements

Steps:
1. Traverse array using right pointer
2. If element is negative → store its index in deque
3. When window size == k:
    - If deque is not empty → first negative = arr[dq.peekFirst()]
    - Else → add 0
4. Before sliding window:
    - If dq.peekFirst() == left → remove it (element going out)
5. Move left forward

Key Points:
- Store index, not value
- Deque always holds valid negatives inside window
- Front of deque = first negative in current window

Time Complexity : O(n)
Space Complexity : O(k)

*/

