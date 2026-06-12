/*

Question:
LeetCode 144 - Binary Tree Preorder Traversal
Given the root of a binary tree, return the preorder traversal
of its nodes' values.

Preorder Traversal follows:
Root → Left → Right
Example 1:

Input:
root = [1,null,2,3]

Tree:

    1
     \
      2
     /
    3

Output:
[1,2,3]



Constraints:

- The number of nodes in the tree is in the range [0, 100].
- -100 <= Node.val <= 100

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preordertraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            result.add(curr.val);

            if (curr.right != null) {
                st.push(curr.right);
            }
            if (curr.left != null) {
                st.push(curr.left);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(9);

        List<Integer> op = preorderTraversal(root);

        System.out.println("The op list is  ::: " + op);
    }
}

/*
Recap:

Preorder Traversal:
Root → Left → Right

Iterative Approach:

1. Create an empty stack.
2. Push root into the stack.
3. While stack is not empty:
   - Pop a node.
   - Add its value to the result.
   - Push its right child first.
   - Push its left child second.

Why push right before left?

Stack follows LIFO (Last In First Out).

Push:
Right → Left
Pop:
Left → Right
This maintains preorder traversal:
Root → Left → Right
Time Complexity:
O(n)
Space Complexity:
O(n)
*/
