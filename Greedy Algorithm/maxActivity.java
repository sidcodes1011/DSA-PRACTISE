import java.util.*;

class maxActivity {

    public static int activitySelection(int[] start, int[] finish) {
        
        int n = start.length;
        
        int[][] activities = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = finish[i];
        }
        
        // Sort by finish time (ascending)
        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 1;
        int lastFinish = activities[0][1];
        
        for (int i = 1; i < n; i++) {
            if (activities[i][0] > lastFinish) {  // Strict condition
                count++;
                lastFinish = activities[i][1];
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        
        int[] start = {1, 3, 2, 5};
        int[] finish = {2, 4, 3, 6};
        
        int result = activitySelection(start, finish);
        
        System.out.println("Maximum activities that can be performed: " + result);
    }
}
