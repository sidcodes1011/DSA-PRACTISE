/* Question 4 ::: BFS With state 
 Problem statement : 
 
You are given a 4-wheel lock starting at "0000".
Each wheel can be turned one step forward or backward.

You are also given:
- deadends = blocked lock states
- target = final lock state to reach

Return the minimum number of moves needed to reach the target.
If it is not possible, return -1.
 */
import java.util.*;

public class OpenTheLock {
	
	 public static List<String> getNeighbors(String lock){
		 List<String> result = new ArrayList<>();
		 char[] chars = lock.toCharArray();
		 
		 for (int i = 0; i < 4; i++) { // Itterate the size of dial ie 4 dial 
			  char original = chars[i];// Get the individual dial
			  
			  // Check once for clockwise 
			  chars[i] = (original == '9') ? '0' : (char)(original + 1);
	          result.add(new String(chars));
	          
	          // Check once for anti-clockwise 
	          chars[i] = (original == '0') ? '9' : (char)(original - 1);
	          result.add(new String(chars));
	          
	          chars[i] = original;
		 }
		 
		 return result;
	 }
	
	public static int openLock(String[] deadends, String target) {

		Set<String> dead = new HashSet<>(Arrays.asList(deadends));// To store the value of Deadends
		Set<String> visited = new HashSet<>();
		
		 Queue<String> queue = new LinkedList<>();
		
		   String start = "0000";
		   
		   if (dead.contains(start)) {
	            return -1;
	        }	   
		   	queue.offer(start); // Adding value in queue
	        visited.add(start); // Check state if alredy visited
		   
	        int moves = 0;
	        while (!queue.isEmpty()) { // check if not empty
	        	int size = queue.size(); // gets size for loop
	        		        	
	        	for (int i = 0; i < size; i++) {
	        		String current = queue.poll(); // Stores in local variable

	                if (current.equals(target)) { // if base case then print moves
	                    return moves;
	                }

	                List<String> neighbors = getNeighbors(current); // get all possible next moves

	                for (String next : neighbors) {
	                    if (!dead.contains(next) && !visited.contains(next)) { // the value we get should not be in deadend or visited alredy
	                        queue.offer(next); // Add in queue for next ittiration
	                        visited.add(next); // Add the element state in visited if alredy done
	                    }
	                }
	        	}
	        	  moves++;
	        }
	        
		return -1;
	}
	
	

	 public static void main(String[] args) {
	       // String[] deadends = {"0201","0101","0102","1212","2002"};
	      //  String target = "0202";
	        String[] deadends = {};
	        String target = "0002";
	        System.out.println("Minimum moves = " + openLock(deadends, target));
	    }
}

/*
====================================================
QUESTION: Open the Lock
====================================================

You have a lock with 4 circular wheels.

Each wheel has digits from:
0 to 9

The lock starts at:
"0000"

Each move consists of turning one wheel:
- one step forward
or
- one step backward

Examples:
- '0' forward becomes '1'
- '9' forward becomes '0'
- '0' backward becomes '9'

You are given:
1. deadends -> a list of forbidden lock states
2. target -> the final lock state you want to reach

Rules:
- If lock enters a deadend state, it gets stuck
- You cannot move through deadend states

Return:
- minimum number of moves required to reach target
- return -1 if it is impossible

Example:
Input:
deadends = []
target = "0002"

Output:
2

Explanation:
"0000" -> "0001" -> "0002"

So minimum moves = 2

Why BFS?
- BFS is used because every move costs the same (1 move)
- First time target is reached = shortest path

====================================================
*/

