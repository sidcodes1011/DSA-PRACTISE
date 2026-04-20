import java.util.*;

/*
Problem : Longest Substring with At Most K Distinct Characters
Leetcode : 340

Given a string s and an integer k, find the length of the longest substring 
that contains at most k distinct characters.

A substring is a contiguous sequence of characters within a string.

Return the length of the longest such substring.

If no such substring exists, return 0.
*/

public class LongestSubarraywithkDistinctelem {

    // Brute Force Approach Time Complexity : O(N^2)
    // public static int LongestSubarraywithkDistinctelemCheck(String s, int k) {
    // int maxLength = 0;
    // for (int i = 0; i < s.length(); i++) {
    // Map<Character, Integer> map = new HashMap<>();

    // for (int j = i; j < s.length(); j++) {
    // char ch = s.charAt(j);
    // map.put(ch, map.getOrDefault(ch, 0) + 1);

    // if (map.size() > k) {
    // break;
    // }

    // if (map.size() <= k) {
    // maxLength = Math.max(maxLength, j - i + 1);
    // }
    // }
    // }
    // return maxLength;
    // }

    // Optimized code With Time Complexity O(n)
    public static int LongestSubarraywithkDistinctelemCheck(String s, int k) {

        if (s == null || k == 0 || s.length() == 0)
            return 0;

        int maxLength = 0;
        // We use two pointer approach so
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {
            char leftChar = s.charAt(left);
            map.put(leftChar, map.get(leftChar) - 1);

            if (map.get(leftChar) == 0) {
                map.remove(leftChar);
            }
            left++;

            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return 1;
    }

    public static void main(String[] args) {

        System.out.println("Working !!!");
        String s = "aaabb";
        int k = 3;

        int result = LongestSubarraywithkDistinctelemCheck(s, k);

        System.out.println(
                "The length of the longest substring that contains at most k distinct characters is ::: " + result);
    }
}

/*
Recap (Sliding Window - At Most K Distinct):

1) Use two pointers (left, right) to maintain a dynamic window.
2) Expand window by moving right and adding characters to map (frequency count).
3) If distinct characters exceed k → shrink window from left
   until map.size() <= k (use while, not if).
4) Update maxLength whenever window is valid.
5) Each character is added/removed at most once → O(N) time.

Key Idea:
Never break the window, always adjust it to make it valid.

Note:
Return maxLength (not 1).
*/

