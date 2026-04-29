/*

Leetcode 1482 : Minimum Number of Days to Make m Bouquets 

You are given an integer array bloomDay, where bloomDay[i] represents
the day on which the ith flower will bloom.

You are also given two integers:
m = number of bouquets you need to make
k = number of adjacent flowers required for one bouquet

Rules:
- A flower can only be used once.
- Each bouquet must contain exactly k *adjacent* flowers.
- You can only use flowers that have bloomed on or before a given day.

Return the minimum number of days required to make m bouquets.
If it is not possible, return -1.

Example:
Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3

Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
Output: -1

*/


public class MinDayForBouquete {

    public static Boolean isPossible(int[] bloomDay, int m, int k, int mid) {
        int count = 0;
        int bouquets = 0;
        for (int irr : bloomDay) {

            if (irr <= mid) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                bouquets++;
                count = 0;
            }
        }
        return bouquets >= m;
    }

    public static int minDays(int[] bloomDay, int m, int k) {

        if ((long)m * k > bloomDay.length) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int irr : bloomDay) {
            min = Math.min(min, irr);
            max = Math.max(max, irr);
        }

        while (min < max) {

            int mid = min + (max - min) / 2;

            if (isPossible(bloomDay, m, k, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {

        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3;
        int k = 1;

        int result = minDays(bloomDay, m, k);

        System.out.println("Minimum days required: " + result);
    }
}

/*
Recap (Binary Search on Answer):

1. Edge Case:
   - If (m * k > bloomDay.length) → not enough flowers → return -1

2. Search Space:
   - low = minimum bloom day
   - high = maximum bloom day

3. Binary Search:
   - mid = candidate day

4. Feasibility Check (isPossible):
   - Traverse bloomDay
   - Count consecutive flowers where bloomDay[i] <= mid
   - When count == k → form 1 bouquet, reset count
   - Keep forming bouquets

5. Decision:
   - If bouquets >= m → possible
       → try smaller day (high = mid)
   - Else → not possible
       → increase day (low = mid + 1)

6. Final Answer:
   - The smallest day where we can form m bouquets

Time Complexity: O(n log range)

Key Insight:
"Find minimum day such that condition becomes true"
→ Binary Search on Answer
*/

