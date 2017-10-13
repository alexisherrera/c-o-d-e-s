package leetcode;

/**
 * Created by alexisherrera on 10/13/17.
 */
public class MinSizeSubArr {
    public int minSubArrayLen(int s, int[] nums) {
        //brute force: find the total cont subarrays --> O(n^2)
        //better: keep a running sum and two pointers (start/end). While running sum is less than target
        //move end to the right. when RS is larger than s start moving start to the right until no longer larger than RS
        //O(n) time --> both pointers at worst will move n spots space is O(1)

        int start = 0;
        int shortestLength = Integer.MAX_VALUE;
        int runningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            runningSum = runningSum + nums[i];

            //RS larger than s
            while (runningSum >= s) {
                runningSum = runningSum - nums[start];
                shortestLength = Math.min(shortestLength, (i - start) + 1);
                start++;

            }
        }

        return (shortestLength == Integer.MAX_VALUE) ? 0 : shortestLength;
    }
}
