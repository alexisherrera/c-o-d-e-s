package leetcode;
import java.util.Map;
import java.util.HashMap;


/**
 * Created by alexisherrera on 10/9/17.
 */
public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        //brute force, O(n^2);
        //create a running sum map
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int runningSum = 0;
        int subArrayCount = 0;
        for (int i = 0; i < nums.length; i++) {
            //if the running sum - k exists in hashmap. This implies that there is a subarray with a sum of k. We add it by
            //we use a map to keep track of the number of indices with a particular running sum as there could be multiple
            runningSum = runningSum + nums[i];
            if (map.containsKey(runningSum - k)) {
                subArrayCount = subArrayCount + map.get(runningSum - k);
            }
            //update the count of running sum at this particular index
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }
        return subArrayCount;

        //complexity is O(n) running time (1 pass). Space is O(n) can be different runnning sums, consider all positive
        //entries
    }
}
