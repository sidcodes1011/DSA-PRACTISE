/*
Problem : Longest Substring Without Repeating Characters
Leetcode : 3

Given a string s, find the length of the longest substring 
without repeating characters.

A substring is a contiguous sequence of characters within a string.

Return the length of the longest such substring.

 */
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    // Brute Force Time complexity O(n^2)
    // public static int checkSubstring(String s) {
    //     int maxLength = 0;
    //     for (int i = 0; i < s.length(); i++) {
    //         Set<Character> seen = new HashSet<>();
    //         int count = 0;
    //         for (int j = i; j < s.length(); j++) {
    //             char ch = s.charAt(j);
    //             if (seen.contains(ch)) {
    //                 break;
    //             }
    //             seen.add(ch);
    //             count++;
    //             maxLength = Math.max(maxLength, count);
    //         }
    //     }
    //     return maxLength;
    // }
    // Optimized Code Time complexity O(n)
    public static int checkSubstring(String s) {

        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int right = 0;
        int left = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";
        int result = checkSubstring(s);
        System.out.println("The Length of longest substring is ::: " + result);
    }
}

/*
===================== 🔥 QUICK RECAP =====================

✔ Problem Type:
- Contiguous substring
- Find LONGEST length without repeating characters
→ Use Sliding Window (Variable Window)

✔ Key Idea:
- Use HashMap to store last index of characters
- Expand window using right pointer
- If duplicate found → jump left to (last index + 1)

✔ Important Trick:
- left = Math.max(left, map.get(ch) + 1)
→ prevents moving left backward

✔ Why it works:
- Window always remains valid (no duplicates)
- No need to shrink step-by-step → direct jump

✔ Complexity:
- Time → O(n)
- Space → O(n)

✔ One Line Intuition:
→ "Expand window, and on duplicate jump left forward"

==========================================================
 */
