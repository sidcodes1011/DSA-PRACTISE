// Question
// Given an array, arr[] of rope lengths, connect all ropes into a single rope with the minimum total cost. The cost to connect two ropes is the sum of their lengths. 

import java.util.PriorityQueue;

public class minCostOfRope {
     public static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int val : arr) {
            pq.add(val);
        }
        int minCost = 0;
        while (pq.size() > 1) {            
            int first = pq.poll();   
            int second = pq.poll();  
            int sum = first + second;
            minCost += sum;
            pq.add(sum);
        }
        return minCost;
    }
}
