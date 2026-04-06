/* Question 1 ::: Binary Tree Level Order Traversal (Simple BFS)
Problem Statement :::

Given the root of a binary tree, return the values of the nodes in level order traversal from left to right.
*/
import java.util.*;

public class SimpleBFS {

    public static String printQueue(Queue<TreeNode> queue) {
        List<Integer> list = new ArrayList<>();

        for (TreeNode node : queue) {
            list.add(node.val);
        }

        return list.toString();
    }

    public static List<Integer> bfs(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        System.out.println("Initial Queue: " + printQueue(queue));

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            System.out.println("Removed: " + current.val);

            result.add(current.val);

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }

            System.out.println("Queue Now: " + printQueue(queue));
        }

        return result;
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(bfs(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

/*
========================================
SHORT RECAP
========================================

What this code does:
- Performs BFS (Breadth First Search) traversal on a Binary Tree.
- Visits nodes level by level from left to right.

How it works:
1. Put root node into queue.
2. While queue is not empty:
   - Remove front node
   - Add its value to result
   - Add its left child to queue if exists
   - Add its right child to queue if exists

Why queue is used:
- BFS always works using FIFO (First In First Out).
- The first node inserted should be processed first.

Traversal Order for this tree:
        1
       / \
      2   3
     / \   \
    4   5   6

Output:
[1, 2, 3, 4, 5, 6]

Important points to remember:
- BFS = Queue
- DFS = Stack / Recursion
- Always check if root is null
- Left child is added first, then right child
- Queue stores nodes, not values

Time Complexity:
- O(n) -> every node is visited once

Space Complexity:
- O(n) -> queue may store many nodes

Use BFS when:
- You need level order traversal
- You need shortest path in unweighted graph
- You need nearest/closest node type problems

========================================
*/
