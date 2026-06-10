/*

Question:
LeetCode 797 - All Paths From Source to Target

Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n-1, 
represented as an adjacency list where graph[i] is a list of all nodes 
j such that there is a directed edge from node i to node j, 

Return all possible paths from node 0 to node n-1. You may return the paths in any order.

Example 1:

Input:
graph = [[1,2],[3],[3],[]]

Output:
[[0,1,3],[0,2,3]]

Explanation:
Two paths from node 0 to node 3: 
0 → 1 → 3
0 → 2 → 3

*/

import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget {

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        int n = graph.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int neighbour : graph[i]) {
                adj.get(i).add(neighbour);
            }
        }

          System.out.println("Adjecency list ::: " + adj); 

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(adj, 0, n - 1, path, result);

        return result;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj,int start, int end, List<Integer> path,List<List<Integer>> result) {

        path.add(start);

        if (start == end) {
            result.add(new ArrayList<>(path));
        } else {

            for (int neighbour : adj.get(start)) {
                dfs(adj, neighbour, end, path, result);
            }
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
          int[][] graph = {
                {1, 2},
                {3},
                {3},
                {}
        };

        List<List<Integer>> ans = allPathsSourceTarget(graph);

        System.out.println(ans);
    }
}
/*
Recap:

1. Definition
   Find all possible paths from source (0) to target (n-1) 
   in a directed acyclic graph (DAG).

2. Key Insight

   - Use DFS to explore all paths.
   - Keep track of current path in a list.
   - When you reach the target node, add a copy of the path to the result.
   - Backtrack by removing the last node to explore other paths.

3. DFS Approach (Recursive)

   dfs(node):
     - Add node to current path
     - If node == target, add path to result
     - Else, for each neighbor:
         dfs(neighbor)
     - Remove node from path (backtrack)

4. Example

   graph = [[1,2],[3],[3],[]]

   Paths:
   - Start at 0
   - 0 → 1 → 3 → add [0,1,3] to result
   - Backtrack to 0
   - 0 → 2 → 3 → add [0,2,3] to result

   Result = [[0,1,3],[0,2,3]]

5. Complexity

   Time  : O(2^n * n)
     - Worst case: exponential number of paths
     - Each path can have up to n nodes

   Space : O(n)
     - Recursion stack + current path
*/
