package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by alexisherrera on 9/11/17.
 */
public class P6 {


    public static ArrayList<int[]> mergeIntervals(ArrayList<int[]> intervals, int[] interval) {
        //firstly, we need to sort the intervals arraylist by first value of interval
        Collections.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        ArrayList<int[]> result = new ArrayList<>();

        //secondly, we need to iterate through the given intervals and find intersecting intervals and merge them
        //together

        int[] currInterval = interval;

        int i = 0;

        while (i < intervals.size()) {

            //check current interval
            if (intersect(intervals.get(i), currInterval)) {
                while (i < intervals.size() && intersect(intervals.get(i), currInterval)) {
                    int[] curr = intervals.get(i);
                    currInterval = merge(curr, currInterval);
                    i++;
                }
                result.add(currInterval);
            }

            else {
                int[] curr = intervals.get(i);
                result.add(curr);
                i++;
            }
        }

        return result;

        //the complexity of this algorithm is O(n), space is O(n) for result and new interval
    }

    public static boolean intersect(int[] i1, int[] i2) {
        int[] smallerStart = i1[0] <= i2[0] ? i1 : i2;
        int[] largerStart = i1[0] > i2[0] ? i1 : i2;

        //check whether the end of the smaller start is larger than or equal to the largerStart interval
        return smallerStart[1] >= largerStart[0];

    }

    //find the intersect of the two arrays
    public static int[] merge(int[] i1, int[] i2) {
        int[] result = new int[2];

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
        int[] interval = {0, 10};

        System.out.println("Updated list: ");

        ArrayList<int[]> updatedList = mergeIntervals(list, interval);

        for (int[] i : updatedList) {
            System.out.print("[" + i[0] + "], [" + i[1] + "]    ");
        }
    }
}
