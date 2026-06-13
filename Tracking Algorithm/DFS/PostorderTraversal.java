
import java.util.ArrayList;
import java.util.List;

/*
Question:
LeetCode 145 - Binary Tree Postorder Traversal

Given the root of a binary tree, return the postorder traversal
of its nodes' values.

Postorder Traversal Order:

Left → Right → Root

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
[3,2,1]

Explanation:

Left of 1 -> null
Go to right child 2
Visit left child 3
Visit 3
Visit 2
Visit 1
 */
public class PostorderTraversal {

    // Definition for a binary tree node.
    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        dfs(rs, root);
        return rs;
    }

    public static void dfs(List<Integer> rs, TreeNode root) {

        if (root == null) {
            return;
        }
        dfs(rs, root.left);
        dfs(rs, root.right);
        rs.add(root.val);
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

        List<Integer> result = postorderTraversal(root);

        System.out.println(result); // [3, 2, 1]
    }
}

/*
Short Recap:

1. Traverse the entire left subtree.
2. Traverse the entire right subtree.
3. Visit the current node.
4. Use DFS recursion.
5. Base case: if node is null, return.

Time Complexity:
O(n)

Space Complexity:
O(h)
where h = height of tree
(O(n) in worst case)
 */
