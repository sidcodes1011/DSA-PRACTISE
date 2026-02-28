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
