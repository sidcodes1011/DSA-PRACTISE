/* Question 2 ::: Binary Tree Level Order Traversal
Problem Statement

Given the root of a binary tree, return the level order traversal of its nodes' values.
 */
import java.util.*;

public class LevelOrderBFS {

    public static String printQueue(Queue<TreeNodeLBS> queue) {
        List<Integer> list = new ArrayList<>();

        for (TreeNodeLBS node : queue) {
            list.add(node.val);
        }

        return list.toString();
    }

    public static List<List<Integer>> levelOrder(TreeNodeLBS root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNodeLBS> queue = new LinkedList<>();
        queue.offer(root);

        System.out.println("Initial Queue: " + printQueue(queue));

        while (!queue.isEmpty()) {

            int size = queue.size(); // number of nodes in current level

            System.out.println("size :::" + size);
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNodeLBS current = queue.poll();
                level.add(current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            result.add(level);
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
        TreeNodeLBS root = new TreeNodeLBS(1);
        root.left = new TreeNodeLBS(2);
        root.right = new TreeNodeLBS(3);
        root.left.left = new TreeNodeLBS(4);
        root.left.right = new TreeNodeLBS(5);
        root.right.right = new TreeNodeLBS(6);

        System.out.println(levelOrder(root));
    }
}

class TreeNodeLBS {

    int val;
    TreeNodeLBS left, right;

    TreeNodeLBS(int val) {
        this.val = val;
    }
}

/*
========================================
SHORT RECAP
========================================

What this code does:
- Performs Level Order Traversal using BFS on a Binary Tree.
- Visits tree level by level from left to right.
- Stores each level separately in a list.

How it works:
1. Put root into queue.
2. While queue is not empty:
   - Find current queue size (this tells how many nodes are in current level)
   - Run loop 'size' times
   - Remove nodes one by one
   - Add their values into current level list
   - Add their children into queue
3. Add current level list into final result

Why 'size' is important:
- It helps us process only one level at a time.
- Without size, all nodes would get mixed together.

Example Output:
[[1], [2, 3], [4, 5, 6]]

Important points to remember:
- BFS = Queue
- Queue stores nodes level by level
- queue.size() tells current level node count
- One while loop = overall BFS
- One for loop = process one level only
- Left child added first, then right child

Time Complexity:
- O(n) -> every node visited once

Space Complexity:
- O(n) -> queue may store many nodes

Use this pattern when:
- You need level-wise output
- You need left view / right view / zigzag traversal
- You need tree depth / level based tree problems

========================================
 */
