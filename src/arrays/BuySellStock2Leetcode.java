package arrays;

/**
 * Created by alexisherrera on 8/28/17.
 */
public class BuySellStock2Leetcode {
    //we are allowed an unlimited amount of transactions, only that we need to make sure we buy one stock before
    //we buy another
    public static int maxProfit(int[] nums) {
        //approach. we know that incremental (in the sense that they are next to each other)
        //jumps from minimum values to maximum values will always be at least
        //equal profits made from non-incremental jumps from minimum values to maximum values. It is important to
        //note however that more profit can be made when there are minimum/max fluctuations between two minimum
        // and maximums that are not next to each other (because of minimum fluctuations allowing us to double
        // dip on the profit by a price slightly sinking). Therefore, a good approach is to find all
        //of the instances where there is a maximum and a minimum and then add the differences. THis will
        //yield our largest profit. But easier is to iterate through the array and add all instances in which
        //nums[i] < nums[i + 1] and then add the difference to a variable which holds the profit

        int profit = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                profit = profit + nums[i + 1] - nums[i];
            }
        }
          return profit;
    }


    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));
    }

}
