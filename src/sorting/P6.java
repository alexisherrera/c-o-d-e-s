package sorting;

import java.util.ArrayList;

/**
 * Created by alexisherrera on 9/11/17.
 */
public class P6 {

    //merging intervals

    //this is essentially the union of intervals problem. we are given a an array of disjoint closed intervals
    //in ascending order. we are also given a new interval, which we must union with the array of intervals.

    public static ArrayList<int[]> mergeIntervals(ArrayList<int[]> intervals, int[] interval) {
        //we want to find the largest element smaller than the left value of the given interval in the intervals array
        //and then do the same for the right hand side

        int leftLimit = -1;
        int rightLimit = intervals.size();

        //find left limit. left maximal min or eq
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i)[0] <= interval[0]) {
                leftLimit = i;
            }
            else if (intervals.get(i)[0] > interval[0]) {
                break;
            }
        }

        //find right limit. right minimum max or eq
        for (int i = leftLimit; i < intervals.size(); i++) {
            if (intervals.get(i)[1] <= interval[1]) {
                rightLimit = i;
            }
            else if (intervals.get(i)[1] > interval[1]) {
                break;
            }
        }

        //error made no interval found
        if (leftLimit == -1 || rightLimit == intervals.size()) { return null; }

        int[] intervalToAdd = {intervals.get(leftLimit)[0], intervals.get(rightLimit)[1] };

        ArrayList<int[]> updatedIntervals = new ArrayList<>();

        for (int[] i: intervals) {
            if (i[0] < intervalToAdd[0] && i[1] < intervalToAdd[1]) { updatedIntervals.add(i); }
            else if (i[0] > intervalToAdd[0] && i[1] > intervalToAdd[1]) { updatedIntervals.add(i); }
            else if (updatedIntervals.get(updatedIntervals.size() - 1)[0] != intervalToAdd[0]
                    && updatedIntervals.get(updatedIntervals.size() - 1)[1] != intervalToAdd[1]) {
               updatedIntervals.add(intervalToAdd);
            }
        }

        return updatedIntervals;
    }

    //this is the way that it is done in EPI
    public static ArrayList<int[]> mergingIntervalsEPI(ArrayList<int[]> intervals, int[] interval) {

    }

    public static void main(String[] args) {
        int[][] intervals = {{-4, -1}, {0, 2}, {3, 6}, {7, 9}, {11, 12}, {14, 17} };
        ArrayList<int[]> list = new ArrayList<>();

        for (int[] i : intervals) {
            list.add(i);
        }
        System.out.println("original intervals");

        for (int[] i : intervals) {
            System.out.print("[" + i[0] + "], [" + i[1] + "]    ");
        }
        System.out.println("");
        int[] interval = {0, 13};

        ArrayList<int[]> updatedList = mergeIntervals(list, interval);

        for (int[] i : updatedList) {
            System.out.print("[" + i[0] + "], [" + i[1] + "]    ");
        }

     }
}
