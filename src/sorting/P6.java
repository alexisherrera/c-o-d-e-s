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
        //this is a 3 step algorithm in which we first consider items that do not intersect
        //with the range provided in the interval. Here we simply add these intervals to the resulting array.
        //in the second phase of the algorithm we "build" our union, by unioning all intervals that
        //intersect with the interval. When nothing intersects anymore, we just place everything else at the
        //end of the array

        ArrayList<int[]> result = new ArrayList<>();
        int index = 0;

        //phase one in the algorithm
        while(index < intervals.size()) {
            //interval we are at has starts and ends before interval we are trying to introduce.
            if (intervals.get(index)[1] < interval[0]) {
                result.add(intervals.get(index));
                index++;
            }
            else {
                break;
            }
        }

        //phase two in the algorithm find unions

        while (index < intervals.size()) {
            if (intervals.get(index)[0] <= interval[1])  {
                interval = union(interval, intervals.get(index));
                index++;
            }
            else {
                break;
            }
        }
        result.add(interval);

        //phase three in the algorithm, finish adding intervals that do not intersect
        while (index < intervals.size()) {
            result.add(intervals.get(index));
            index++;
        }

        return result;
    }

    //function to find the union of two intersecting arrays
    public static int[] union(int[] i1, int[] i2) {
        int[] result= new int[2];

        //basically extending our boundaries to include the different ranges. This works by making the min the smaller
        //of the two values and the max the larger of the two values
        result[0] = Math.min(i1[0], i2[0]);
        result[1] = Math.max(i1[1], i2[1]);
        return result;
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

        ArrayList<int[]> updatedList = mergingIntervalsEPI(list, interval);

        for (int[] i : updatedList) {
            System.out.print("[" + i[0] + "], [" + i[1] + "]    ");
        }

     }
}
