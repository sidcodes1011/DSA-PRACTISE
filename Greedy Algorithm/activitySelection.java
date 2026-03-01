// Question 
// You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the start time of meeting i and end[i] 
// is the finish time of meeting i. Return the maximum number of meetings that can be accommodated in a single meeting room, 
// when only one meeting can be held in the meeting room at a particular time. 

// Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class activitySelection {

    public static void main(String[] args){
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end   = {2, 4, 6, 7, 9, 9};
        System.out.println("DSA : activity Selection code :::");
        int n = start.length;
        Vector<Meeting> meetings = new Vector<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }
        System.out.println("Meeting vetor ::"+meetings);
        Collections.sort(meetings, Comparator.comparingInt(m -> m.end));
        System.out.println("Meeting vetor after sort::"+meetings);
        int count = 1;
        int lastEnd = meetings.get(0).end;
        for (Meeting size : meetings) {
             if (size.start > lastEnd) {
        count++;
        lastEnd = size.end;
    }
        }
        System.out.println("The maximum meeting that can be held is :"+ count);
    }
    static class Meeting {
        int start, end;
        Meeting(int s, int e) {
            start = s;
            end = e;
        }
    @Override
    public String toString() {
        return "(" + start + ", " + end + ")";
    }
    }
 }

