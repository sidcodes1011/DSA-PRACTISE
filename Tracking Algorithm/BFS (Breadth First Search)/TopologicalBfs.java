
import java.util.*;

/* Question 6 : Topological Sort (Kahn's Algorithm / Course Schedule)

Problem Statement

You are given:
- An integer numCourses representing total number of courses
- A 2D array prerequisite where:
  prerequisite[i] = {a, b} means:
  → To take course 'a', you must first complete course 'b'

Return true if it is possible to finish all courses.
Return false if it is not possible.

------------------------------------------------------------

Key Conditions:

- Courses are labeled from 0 to numCourses - 1
- You can only take a course when all its prerequisites are completed

------------------------------------------------------------

Goal:

- Determine whether you can complete all courses
- If there is a cycle → return false
- If no cycle → return true

------------------------------------------------------------

*/


public class TopologicalBfs {

 public static boolean canFinish(int numCourse, int[][] prerequesite) {
   
     List<List<Integer>> adj = new ArrayList<>();
     for (int i = 0; i < numCourse; i++) {
         adj.add(new ArrayList<>());
     }
     System.out.println("Adjecency list ::: "+ adj); 
     int[] indegree = new int[numCourse];
     System.out.println("Indegree array ::: "+ Arrays.toString(indegree));
    
     
     for (int[] arr : prerequesite) {
         int course = arr[0];
         int pre = arr[1];
         adj.get(pre).add(course);   
         indegree[course]++;        
     }
     System.out.println("Adjecency list after traverse ::: "+ adj);
     System.out.println("Indegree array after traverse ::: "+ Arrays.toString(indegree));

     Queue<Integer> q = new LinkedList<>(); 
     for (int i = 0; i < numCourse; i++) {
         if (indegree[i] == 0) {
             q.offer(i);
         }
     }
     int count = 0;
     while (!q.isEmpty()) {
         int curr = q.poll();
         count++;

         for (int next : adj.get(curr)) {
             indegree[next]--;

             if (indegree[next] == 0) {
                 q.offer(next);
             }
         }
     }
     return count == numCourse;
 }
 
 public static void main(String[] args) {
     // Type 1
//	 int numCourse =2;
//     int prerequesite[][] = {{1,0},{0,1}};

     // Type 2
//     int numCourse =3;
//     int prerequesite[][] = {{1,0},{0,1}};

     // Type 3
     int numCourse =3;
     int prerequesite[][] = {{1,0}};

     Boolean result = canFinish(numCourse,prerequesite);
     System.out.println("Loop found ::: " + result);
 }

}

/*
################################################################
     KEY POINTS : TOPOLOGICAL BFS (Kahn's Algorithm)
################################################################

1) Problem Type:
- Used for Directed Graph (DAG)
- Mainly for ordering tasks with dependencies
- Also used to detect cycle

------------------------------------------------------------

2) Core Idea:
- Process nodes having indegree = 0
- Reduce indegree of dependent nodes
- Repeat using BFS

------------------------------------------------------------

3) Important Data Structures:

a) Adjacency List:
   - Stores: from prerequisite → course
   - Meaning: what gets unlocked after completing a node

b) Indegree Array:
   - indegree[i] = number of prerequisites for course i

c) Queue:
   - Stores nodes with indegree = 0 (ready to process)

------------------------------------------------------------

4) Algorithm Steps:

1. Build adjacency list
2. Fill indegree array
3. Add all nodes with indegree = 0 into queue
4. Run BFS:
     - Take node from queue
     - Reduce indegree of its neighbors
     - If indegree becomes 0 → add to queue
     - Increment count

------------------------------------------------------------

5) Cycle Detection:

- Maintain count of processed nodes

IF (count == numCourses)
    → No cycle (Valid Topological Order)

ELSE
    → Cycle exists (Some nodes stuck)

------------------------------------------------------------

6) Key Intuition:

- indegree = pending dependencies
- queue = nodes ready to execute
- BFS = processing order
- count = final validation

------------------------------------------------------------

7) Important Rule:

- Cycle means:
  → No node with indegree 0 (or)
  → Some nodes never reach indegree 0

------------------------------------------------------------

8) Time & Space Complexity:

- Time: O(V + E)
- Space: O(V + E)

------------------------------------------------------------

9) Use Cases:

- Course Schedule problems
- Task scheduling with dependencies
- Build systems (compilers, package managers)

------------------------------------------------------------

10) One-Line Summary:

→ "Process nodes with 0 indegree, reduce dependencies,
   and if all nodes processed → no cycle"

*/














