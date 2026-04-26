
/*
Problem: Maximum Product Subarray (LeetCode 152)

Given an integer array nums, find the contiguous subarray
that has the largest product and return that product.

Note:
- Subarray must be continuous
- Product of single element is also valid
 */
public class MaxProdSubarray {

    public static int maxProduct(int[] nums) {
        int length = nums.length;
        int leftMax = 1;
        int rightMax = 1;
        int pointer = 0;
        int maxProd = Integer.MIN_VALUE;

        while (pointer < length) {

            leftMax *= nums[pointer];
            rightMax *= nums[length - 1 - pointer];

            maxProd = Math.max(maxProd, Math.max(leftMax, rightMax));
            if (leftMax == 0) {
                leftMax = 1;
            }
            if (rightMax == 0) {
                rightMax = 1;
            }
            pointer++;
        }
        return maxProd;
    }

    public static void main(String[] args) {

        System.out.println("Inside main");
        int[] arr = {2, 3, -2, 4};

        int Result = maxProduct(arr);
        System.out.println("The maximum product of subarray is ::: " + Result);
    }
}

/*
Approach (Two Direction Scan):

- Traverse from left → right and right → left
- Keep multiplying elements (leftProd, rightProd)
- Update max with both products
- If product becomes 0 → reset to 1 (start fresh)

Key Idea:
- Negative numbers can flip sign
- So checking both directions ensures we don’t miss max product

Time: O(n)
Space: O(1)
 */
