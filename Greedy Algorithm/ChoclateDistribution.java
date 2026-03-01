// Questioon

// Given an array arr[] of positive integers, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. 
// There are m students, the task is to distribute chocolate packets among m students such that -
// i. Each student gets exactly one packet.
// ii. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum and 
// return that minimum possible difference.

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