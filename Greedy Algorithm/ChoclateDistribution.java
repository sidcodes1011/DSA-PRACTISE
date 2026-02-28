import java.util.*;
public class ChoclateDistribution {
    static List<Integer> differneceCount = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int student = 3;
        ArrayList<Integer> list = new ArrayList<>();
        for (int val : arr) {
            list.add(val);
        }
       int result=findMinDiff(list, student);
        System.out.println("differneceCount ::: " + result);
    }
    
    public static int findMinDiff(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        if (m == 0 || n == 0 || m > n) {
            return 0;
        }
        Collections.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i + m - 1 < n; i++) {
            int diff = arr.get(i + m - 1) - arr.get(i);
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }
  
}