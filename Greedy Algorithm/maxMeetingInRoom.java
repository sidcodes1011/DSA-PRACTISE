// Question 
// There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is the start time of meeting i and F[i]
//  is the finish time of meeting i. The task is to find the maximum number of meetings that can be accommodated in the meeting room. 
//  You can accommodate a meeting if the start time of the meeting is strictly greater than the finish time of the previous meeting. Print all meeting numbers.

// Note: If two meetings can be chosen for the same slot then choose meeting that finishes earlier.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class maxMeetingInRoom {
 
    public static void main(String[] args) {
        
        int S [] = {1,3,0,5,8,5};
        int F [] = {2,4,6,7,9,9} ;
        int N = 6;
        ArrayList<Integer> result = maxMeetings(N, S, F);
        System.out.println("Meeting numbers :::" + result);
    }

      public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {

        ArrayList<Integer> maxIntegers = new ArrayList<>();
        Vector<Vector<Integer>> combined= new Vector<>();
        int startTime;
        int endTime;

        for (int i = 0; i < N; i++) {
            Vector<Integer> store = new Vector<>();
            store.add(S[i]);
            store.add(F[i]);
             store.add(i + 1);
            combined.add(store);
        }
        combined.sort((a, b) -> {
        return Integer.compare(a.get(1), b.get(1));
        });  
        System.out.println("Vector ::: " + combined);
        
        int lastFinishTime = combined.get(0).get(1);
        maxIntegers.add(combined.get(0).get(2));

        for (int i = 0; i < combined.size(); i++) {
            startTime = combined.get(i).get(0);
            endTime = combined.get(i).get(1);

            if (startTime > lastFinishTime ) {
                maxIntegers.add(combined.get(i).get(2));
                lastFinishTime = endTime;
            }
        }
        Collections.sort(maxIntegers);
        return  maxIntegers;
    }
}
