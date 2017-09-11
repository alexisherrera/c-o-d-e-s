package arrays;

/**
 * Created by alexisherrera on 8/27/17.
 */
public class P6 {
    //buy and sell stock once

    //this problem revolves around picking two entries in an array such that the second entry minus the first entry
    //is a maximal value. second entry must be larger than first entry.

    //approach: for every index from 1 <-> arr.length - 1, find the minimum to the left of the index. we find the profit
    //index - min. if this profit is larger than our already profit then make it our current profit.

    public static int maxProfit(int[] arr) {
        int profit = 0;
        int minIndex = 0;
        //start at index one
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[minIndex] > profit) { profit = arr[i] - arr[minIndex]; }
            if (arr[i] < arr[minIndex]) { minIndex = i; }
        }

        //works for arrays of size 1, profit is 0.
        return profit;
    }


    public static void main(String[] args) {
        int[] nums = {310, 315, 275, 295, 260,270, 290, 230, 255, 250};
        int profit = maxProfit(nums);
        System.out.println(profit);
    }
}
