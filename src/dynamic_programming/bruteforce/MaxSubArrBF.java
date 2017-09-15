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

    public static void main(String[] args) {
        int[] nums = {904, 40, 523, 12, -335, -385, -124, 481, -31};
        int maxSum = maxSub(nums);
        System.out.println(maxSum);
    }
}
