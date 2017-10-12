package leetcode;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by alexisherrera on 10/12/17.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        //general approach is to start with a given interval and expand it until there are no intersections.
        //to do this we should sort the intervals from smallest to largest (by first element)

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval one, Interval two) {
                return one.start - two.start;
            }
        });

        List<Interval> results = new ArrayList<>();

        int index = 0;

        while (index < intervals.size()) {
            Interval currInter = intervals.get(index);
            int runningIndex = index + 1;

            while (runningIndex < intervals.size() &&  intersect(currInter, intervals.get(runningIndex))) {
                Interval other = intervals.get(runningIndex);

                merge(currInter, other);

                runningIndex++;
            }

            index = runningIndex;
            results.add(currInter);
        }

        //running time is O(nlgn) space is O(1).
        return results;
    }


    public boolean intersect(Interval left, Interval right) {
        if (left.end >= right.start) { return true; }
        return false;
    }

    //will always merge into the left interval
    public void merge(Interval left, Interval right) {
        left.start = Math.min(left.start, right.start);
        left.end = Math.max(left.end, right.end);
    }
}
