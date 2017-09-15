package dynamic_programming.bruteforce;

/**
 * Created by alexisherrera on 9/15/17.
 */
public class MaxSubArrBF {
    //brute force for maximum subarray problem

    public static int maxSub(int[] nums) {
        //find all sub arrays and then compute sum. store max in variable
        int max = Integer.MIN_VALUE;

        for (int start = 0; start < nums.length - 1; start++) {
            for (int end = start + 1; end <nums.length; end++) {

                int sum = 0;
                //find sum of subarray
                for (int i = start; i <= end; i++) {
                    sum = sum + nums[i];
                }

                //find max
                max = Math.max(max, sum);
            }
        }
        return max;

        //terrible runtime O(n^3).
    }

    public static int betterMaxSumBruteForce(int[] nums) {
        //this technique will use a running sum technique in which we calculate the running sum for all the
        //numbers in an array. This is useful because we can then find the sum of contiguous subarrays by
        //simply subtracting the (end index of interest) - (start index of interest - 1), where nums[-1] == 0.

        //compute sum
        int[] runningSums = new int[nums.length];

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            runningSums[i] = sum;
        }

        int maxSum = Integer.MIN_VALUE;

        //calculate max sub array using this running sum array
        for (int start = 0; start < nums.length; start++) {
            for (int end = start; end < nums.length; end++) {
                maxSum = Math.max(maxSum, runningSums[end] - (start - 1 < 0 ? 0 :runningSums[start-1]));
            }
        }
        return maxSum;

        //better running time O(n^2), but O(n) space
    }

    public static int maximumSubArrayOptimized(int[] nums) {
        //best way to do this is by building the maximum subarray by looking at the problem as either appending
        //an element to the current maximal contigous subarray OR start from the index in which we are iterating from

        int globalMaxSubarrayLength = Integer.MIN_VALUE;
        int maxSubarraySeenSoFar = 0;
        for (int i = 0; i < nums.length; i++) {
            maxSubarraySeenSoFar = Math.max(maxSubarraySeenSoFar + nums[i], nums[i]);
            globalMaxSubarrayLength = Math.max(globalMaxSubarrayLength, maxSubarraySeenSoFar);
        }
        return globalMaxSubarrayLength;

        //runs in O(n) time and O(1) time
    }

    public static void main(String[] args) {
        int[] nums = {904, 40, 523, 12, -335, -385, -124, 481, -31};
        int maxSum = maximumSubArrayOptimized(nums);
        System.out.println(maxSum);
    }
}
