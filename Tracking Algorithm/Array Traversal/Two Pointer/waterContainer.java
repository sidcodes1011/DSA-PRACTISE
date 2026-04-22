/*
Problem : Container With Most Water
Leetcode : 11

You are given an integer array height of length n. 
There are n vertical lines drawn such that the two endpoints 
of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, 
such that the container contains the most water.

Return the maximum amount of water a container can store.

Note:
- You may not slant the container.
- Water level is determined by the shorter line.
*/

public class waterContainer {
    

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;
        int prefixArea = 0;

        while(left < right){
            int leftHeight = height[left];
            int rightHeight = height[right];
            int finalHeight = Math.min(leftHeight, rightHeight);
            int width = right - left;
            prefixArea = Math.max(prefixArea, (finalHeight)*(width));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return prefixArea;
    }
    public static void main(String[] args) {
        
        System.out.println("Inside main !!!");

        int[] height ={1,8,6,2,5,4,8,3,7};

        int result = maxArea(height);
        System.out.println("The Max area the container hold is " + result);
    }
}

/*
Approach: Two Pointer

- Start with left = 0 and right = n - 1
- Calculate area:
    height = min(height[left], height[right])
    width = right - left
    area = height * width

- Track maximum area

- Move pointer with smaller height:
    if(height[left] < height[right]) left++
    else right--

Why?
- Area depends on smaller height
- Moving larger height won’t help
- Moving smaller height may increase area

Time Complexity: O(n)
Space Complexity: O(1)
*/

