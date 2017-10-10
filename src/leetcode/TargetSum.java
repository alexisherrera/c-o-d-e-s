package leetcode;
import java.util.HashMap;

/**
 * Created by alexisherrera on 10/9/17.
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        //if we note, all combinations are equivilant.
        //at most, we can have nums.length - 1 positive nums or negative nums.
        HashMap<String, Integer> memo = new HashMap<>();
        return helper(nums, S, 0, 0, memo, 0);
    }

    //use a depth first search backtracking approach
    //if we think about it, we don't take advantage of previous computation
    public int helper(int[] nums, int S, int index, int currSum, HashMap<String, Integer> memo, int count) {
        //basecase
        if (index >= nums.length) {
            if (currSum == S) { count++; }
            return count;
        }
        String key = index + "-" + currSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        //general case
        //update the sum by the positive version of the index and the negative version of the index
        int addition = helper(nums, S, index + 1, currSum + nums[index], memo, count);
        int subtraction = helper(nums, S, index + 1, currSum - nums[index], memo, count);
        memo.put(key, addition + subtraction);
        return addition + subtraction;
    }

    //memozation via  a hash map.
    //the running time is simply the number of subproblems and their complexity, O
}
