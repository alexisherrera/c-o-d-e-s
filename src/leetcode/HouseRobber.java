package leetcode;

/**
 * Created by alexisherrera on 10/13/17.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        //analagous to most = max(nums[i] + sol(i + 2), sol(i + 1))
        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = -1;
        }
        return h(nums, 0, memo);
    }

    public int h(int[] nums, int i, int[] memo) {
        if (i >= nums.length) { return 0; }
        if (memo[i] != -1) { return memo[i]; }
        int max = Math.max(nums[i] + h(nums, i + 2, memo), h(nums, i + 1, memo));
        memo[i] = max;
        return memo[i];
        //running time is O(n), space is O(n)
    }
}
