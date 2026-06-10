
/*
Question:
LeetCode 104 - Maximum Depth of Binary Tree

Given the root of a binary tree,

Return its maximum depth.

The maximum depth is the number of nodes
along the longest path from the root node
down to the farthest leaf node.

Example 1:

Input:
root = [3,9,20,null,null,15,7]

        3
       / \
      9   20
         /  \
        15   7

Output:
3

Explanation:
Longest path:
3 -> 20 -> 15
or
3 -> 20 -> 7

Number of nodes = 3

*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftD = maxDepth(root.left);
        int rightD = maxDepth(root.right);
        return 1 + Math.max(leftD, rightD);
    }
}

public class MaxDepthBinaryTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution sol = new Solution();

        int depth = sol.maxDepth(root);

        System.out.println("Maximum Depth of the tree: " + depth); // Output: 3
    }
}

/*
Recap:

1. Definition
   Maximum Depth = Number of nodes in the longest path
   from the root node to any leaf node.

2. Key Insight

   At every node:
   - Find the depth of the left subtree
   - Find the depth of the right subtree
   - Take the larger depth
   - Add 1 for the current node

   Formula:

   depth(node) = 1 + max(leftDepth, rightDepth)

3. DFS Approach (Recursive)

   Base Case:
   - If node is null, return 0

   Recursive Case:
   - Recursively find left depth
   - Recursively find right depth
   - Return 1 + max(leftDepth, rightDepth)

4. Example

           3
          / \
         9   20
            /  \
           15   7

   Node 9  -> depth = 1
   Node 15 -> depth = 1
   Node 7  -> depth = 1

   Node 20 -> 1 + max(1,1) = 2

   Node 3  -> 1 + max(1,2) = 3

   Answer = 3

5. Complexity

   Time  : O(n)
   Space : O(h)

   n = number of nodes
   h = height of tree
*/
