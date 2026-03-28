
/*
Question:

Given a string s, return true if it can become a palindrome
after deleting at most one character. Otherwise, return false.

A palindrome is a string that reads the same forward and backward.

Examples:
Input: "aba"   → Output: true
Input: "abca"  → Output: true
Input: "abc"   → Output: false

** Asked in Meta 40 times**
 */
public class ValidPalindrome2 {

    public static boolean validPalindrome(String s) {
        return helper(s, 0, s.length() - 1, false);
    }

    public static boolean helper(String s, int left, int right, boolean deleted) {

        if (left >= right) {
            return true;
        }

        if (s.charAt(left) == s.charAt(right)) {
            return helper(s, left + 1, right - 1, deleted);
        }

        if (deleted) {
            return false;
        }

        return helper(s, left + 1, right, true) || helper(s, left, right - 1, true);
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));   // true
        System.out.println(validPalindrome("abca"));  // true
        System.out.println(validPalindrome("abc"));   // false
    }
}

/*
Short Recap:

- Use two pointers: left and right
- If characters match, move inward
- If mismatch occurs:
    try deleting left OR deleting right
- Only one deletion is allowed
- If any one path works, return true
 */
