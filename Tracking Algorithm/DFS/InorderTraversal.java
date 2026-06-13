import java.util.ArrayList;
import java.util.List;

/*
Question:
LeetCode 94 - Binary Tree Inorder Traversal

Given the root of a binary tree, return the inorder traversal
of its nodes' values.

Inorder Traversal Order:

Left → Root → Right

Example:

Input:
root = [1,null,2,3]

Tree:

    1
     \
      2
     /
    3

Output:
[1,3,2]

*/

public class InorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        dfs(rs, root);
        return rs;
    }

    public static void dfs(List<Integer> rs, TreeNode root) {

        if (root == null) {
            return;
        }

        dfs(rs, root.left);
        rs.add(root.val);
        dfs(rs, root.right);
    }

    public static void main(String[] args) {

        /*
                1
                 \
                  2
                 /
                3
        */

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = inorderTraversal(root);

        System.out.println(result); // [1, 3, 2]
    }
}

/*
Short Recap:

1. Visit the entire left subtree.
2. Visit the current node.
3. Visit the entire right subtree.
4. Use DFS recursion.
5. Base case: if node is null, return.

Time Complexity:
O(n)

Space Complexity:
O(h)
where h = height of tree
(O(n) in worst case)

*/