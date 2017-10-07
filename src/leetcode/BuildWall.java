package leetcode;
import java.util.HashMap;
import java.util.List;

/**
 * Created by alexisherrera on 10/7/17.
 */
public class BuildWall {
    public int leastBricks(List<List<Integer>> wall) {
        //keep a running sum of the endpoints and at the end find the largest endpoint and subtract it from length.
        //we can maintain this in a hashmap
        HashMap<Integer, Integer> indexToCount = new HashMap<>();


        int maxEndpoints = 0;
        for (int i = 0; i < wall.size(); i++) {
            List<Integer> level = wall.get(i);
            int runningSum = 0;

            //we iterate to the second last item, bc running sum will always be the same in the last element in the array
            for (int j = 0; j < level.size() - 1; j++) {
                runningSum = runningSum + level.get(j);
                if (indexToCount.containsKey(runningSum)) {
                    indexToCount.put(runningSum, indexToCount.get(runningSum) + 1);
                    maxEndpoints = Math.max(maxEndpoints, indexToCount.get(runningSum));
                }
                else {
                    indexToCount.put(runningSum, 1);
                    maxEndpoints = Math.max(maxEndpoints, 1);
                }
            }
        }

        return wall.size() - maxEndpoints;

        //takes O(n^h) time, O(n) space at most
        //approach:
        //essentially what this algorithm does is it calculates the end points for all entries in the arrays.
        //when two end points are the same, it indicates that there is a crack between them. Therefore, we want
        //to maximize the number of cracks. To do this, we simply find the maximum number of cracks and then we
        //subtract this from the number of levels. This is the number of "least bricks"
    }
}
