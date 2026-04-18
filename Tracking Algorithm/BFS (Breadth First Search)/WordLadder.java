/* Question 6 ::: Bidirectional BFS
You are given:
- beginWord
- endWord
- wordList (dictionary of valid words)

You can change only one letter at a time.

Each transformed word must:
- exist in the wordList

Return the minimum number of transformations
needed to change beginWord into endWord.

If no transformation is possible, return 0.
 */

import java.util.*;

public class WordLadder {

    final static String RED = "\u001B[31m";
    final static String RESET = "\u001B[0m";

    // Generate all words differing by one letter
    private static List<String> getNeighbors(String word) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Original chars: " + Arrays.toString(chars));

        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == original) {
                    continue;
                }
                chars[i] = c;
                neighbors.add(new String(chars));
            }
            chars[i] = original; // restore original char
        }
        System.out.println("Neighbors for \"" + word + "\": " + neighbors);
        System.out.println("----------------------------------------------------------------------------------");

        System.out.println();
        return neighbors;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; 		// endWord must be in the dictionary
        }
        Queue<String> beginQueue = new LinkedList<>(); 	// BFS queue starting from beginWord.
        Queue<String> endQueue = new LinkedList<>(); 	// BFS queue starting from endWord (for bidirectional BFS).
        Set<String> visited = new HashSet<>(); 			//keeps track of words we have already transformed 

        beginQueue.offer(beginWord); 	// Addinging inital value 
        endQueue.offer(endWord); 		// Adding final value

        int step = 1; // Counter for the number of transformation steps.

        int count = 1;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) { // Loops till the queue is empty

            System.out.println(RED + "******************************** Iteration start " + count + " **************************************************************" + RESET);
            System.out.println("Queue before processing Begin: " + beginQueue);
            System.out.println("Queue before processing End: " + endQueue);
            // Swap queues so we always expand the smaller queue.
            if (beginQueue.size() > endQueue.size()) {
                Queue<String> tempQ = beginQueue;
                beginQueue = endQueue;
                endQueue = tempQ;
            }
            // Swap queues so we always expand the smaller queue.

            int size = beginQueue.size(); // Number of nodes at the current BFS level.

            System.out.println("Size :::" + size);
            for (int i = 0; i < size; i++) {
                String word = beginQueue.poll();
                System.out.println("Polled word ::; " + word);
                for (String neighbor : getNeighbors(word)) {
                    if (endQueue.contains(neighbor)) {
                        System.out.println("Found connection via neighbor: " + neighbor);
                        return step + 1; // Found connection
                    }
                    if (wordSet.contains(neighbor) && !visited.contains(neighbor)) {
                        visited.add(neighbor);
                        beginQueue.offer(neighbor);
                    }
                }
            }
            step++;

            System.out.println(RED + "******************************** Iteration Ended " + count + " **************************************************************" + RESET);
            System.out.println();
            count++;

        }

        return 0; // No path found
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println("Minimum number of transformations ::: " + ladderLength(beginWord, endWord, wordList)); // Output: 5
    }
}
/*
====================================================
SHORT RECAP
====================================================

What this code does:
- Finds minimum transformations needed to convert
  beginWord into endWord.

Rule:
- Only one letter can be changed at a time
- Every transformed word must exist in wordList

How it works:
1. Start BFS from beginWord
2. Start reverse BFS from endWord
3. Generate all possible one-letter changes
4. Only valid dictionary words are considered
5. If both BFS sides meet, shortest path is found

Why this is Bidirectional BFS:
- BFS starts from both beginWord and endWord
- This reduces search space and makes it faster

Why BFS is used:
- Each transformation costs exactly 1
- BFS gives shortest transformation path

Important points to remember:
- Queue stores words
- getNeighbors() creates all one-letter-different words
- wordSet is used for fast dictionary lookup
- visited prevents duplicate processing
- endQueue.contains(neighbor) means path is found

Time Complexity:
- O(N * L * 26)
Where:
N = number of words
L = word length

Space Complexity:
- O(N)
====================================================
 */
