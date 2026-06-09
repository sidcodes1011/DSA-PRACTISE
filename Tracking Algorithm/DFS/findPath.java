
/*
Question:
LeetCode - Check Valid Path in Graph

Given a bi-directional graph with n vertices (0 to n-1)
and a list of edges where edges[i] = [u, v] represents
an edge between u and v,

Return true if there is a path from source to destination,
otherwise return false.

Example:

Input:
n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2

Output:
true

Input:
n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5

Output:
false

Constraint:
- Solve it in O(n + e) time
- Where n = number of vertices, e = number of edges
*/
import java.util.*;

public class findPath {

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] i : edges) {
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[adj.size()];
        boolean result = dfs(adj, source, destination, visited);

        return result;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int start, int end, boolean[] visited) {

        if (start == end) {
            return true;
        }

        visited[start] = true;

        for (int neighbour : adj.get(start)) {

            if (!visited[neighbour]) {
                boolean res = dfs(adj, neighbour, end, visited);

                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 3;

        int[][] edges = {
                { 0, 1 },
                { 1, 2 },
                { 2, 0 }
        };

        int source = 0;
        int destination = 2;

        boolean ans = validPath(n, edges, source, destination);

        System.out.println(ans);
    }
}

/*
Approach (DFS)

1. Create an adjacency list from the given edges.
   Since the graph is bi-directional:
   u -> v
   v -> u

2. Create a visited[] array
   to avoid revisiting nodes and getting stuck in cycles.

3. Start DFS from source.

4. Base Case:
   If current node == destination,
   return true.

5. Mark current node as visited.

6. Visit all unvisited neighbours recursively.

7. If any recursive call reaches destination,
   return true.

8. If all possible paths are explored and
   destination is not found,
   return false.

Time Complexity:
O(V + E)

Space Complexity:
O(V)
(visited array + recursion stack)
*/
