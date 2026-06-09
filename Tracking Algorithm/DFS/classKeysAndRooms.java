/*
Question:
LeetCode 841 - Keys and Rooms

Given n rooms labeled from 0 to n-1. All rooms are locked
except room 0. Each room may contain keys to other rooms.
You can take all keys from a room when you visit it.

Return true if you can visit all rooms, otherwise false.

Example:

Input:
rooms = [[1],[2],[3],[]]

Output:
true

Input:
rooms = [[1,3],[3,0,1],[2],[0]]

Output:
false

Constraint:
- Solve in O(n + k) time
  where n = number of rooms, k = total keys
*/

import java.util.*;

public classKeysAndRooms {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();

        visited[0] = true;
        for (int i : rooms.get(0)) {
            q.add(i);
            visited[i] = true;
        }

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i : rooms.get(temp)) {

                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }

            }

        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList());

        boolean ans = canVisitAllRooms(rooms);
        System.out.println(ans); // true
    }
}

/*
Approach (BFS)

1. Start from room 0 since it is already unlocked.

2. Mark room 0 as visited and add it to the queue.

3. While the queue is not empty:
   - Remove a room from the queue.
   - Collect all keys present in that room.
   - For each key:
       If the corresponding room is not visited:
       - Mark it as visited.
       - Add it to the queue.

4. After BFS completes,
   check if every room has been visited.

5. If any room is unvisited,
   return false.

6. Otherwise,
   return true.

Time Complexity:
O(n + k)

n = number of rooms
k = total number of keys

Space Complexity:
O(n)

(visited array + queue)
*/
