
/*
Problem: Longest Subarray of 1's After Deleting One Element (LeetCode 1493)

Given a binary array nums (only 0s and 1s),
you must delete exactly one element.

Return the length of the longest non-empty subarray
containing only 1's after deleting one element.

Note:
- You must delete one element (even if all are 1's)
- Subarray must be contiguous
 */
class LongestSubarrayDelteing1 {

    public static int longestSubarray(int[] nums) {
        int left = 0, right = 0;
        int zeroCount = 0;
        int maxLen = 0;

        while (right < nums.length) {

            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left);
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 0, 1, 0, 1};

        int result = longestSubarray(nums);

        System.out.println("Longest subarray after deleting one element: " + result);
    }
}

/*
Approach (Sliding Window):

- Use two pointers (left, right) to form a window
- Allow at most one 0 in the window
- Expand right pointer to include elements
- If zeros > 1 → move left to shrink window
- Length = right - left (since one element is deleted)

Key Idea:
- One 0 in window represents the element we delete

Time: O(n)
Space: O(1)
 */
