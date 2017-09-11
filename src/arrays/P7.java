package arrays;

/**
 * Created by alexisherrera on 8/27/17.
 */
public class P7 {

    //buy and sell stock twice

    //the main approach of this problem is to use the same technique as in buy and sell stock once.

    //the solution of this problem is very clever. What we essentially end up doing is calculate the max profit we
    //can make from iterating from 0 to the end. At each index we can make a certain profit. We can mark this.

    //that is essentially the buy and sell stock once problem. From there, we do those calculations but in reverse
    //order (starting at the end of the array). when finding the max profit.


    public static int[] maxProfitForwardIteration(int[] arr) {
        int profit = 0;
        int minIndex = 0;
        int[] result = new int[arr.length];
        result[0] = 0;
        //start at index one
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[minIndex] > profit) { profit = arr[i] - arr[minIndex]; }
            if (arr[i] < arr[minIndex]) { minIndex = i; }
            result[i] = profit;
        }

        //works for arrays of size 1, profit is 0.
        return result;
    }


    public static int[] maxProfitBackwardIteration(int[] arr) {

        //this method will essentially determine the maximum profit we can make by figuring the maximum value from
        //the right most of the array to our given index.

        int profit = 0;
        int maxIndex = arr.length - 1;
        int[] result = new int[arr.length];
        result[arr.length - 1] = 0;
        //start at index one
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[maxIndex] - arr[i] > profit) { profit = arr[maxIndex] - arr[i]; }
            if (arr[i] > arr[maxIndex]) { maxIndex = i; }
            result[i] = profit;
        }

        //works for arrays of size 1, profit is 0.
        return result;
    }

    public static int maxProfitForTwo(int[] numsF, int[] numsB) {
        //iterate through the two arrays. but note that we must buy one before another. In the way which we
        //have framed the problem we must first buy a stock in the forward iteration and then buy one in the
        //backwards iteration. Therefore, when iterating from index 0 -> n-1. Note that there are two edge cases:
        //index 0 and index n-1. At index n-1, we cannot buy two stocks. we buy one at index n-1 and then the min
        //element before index n-1 (this is the buy one stock problem), therefore, we can disregard the last index.

        int maxProfit = 0;

        for (int i = 0; i < numsF.length - 1; i++) {
            int profit = numsF[i] + numsB[i + 1];
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] nums = {12, 11, 13, 9, 12, 8, 14, 13, 15};
        int[] forwardNums = maxProfitForwardIteration(nums);
        int[] backwardNums = maxProfitBackwardIteration(nums);
        for (int i = 0; i < forwardNums.length; i++) {
            System.out.print(forwardNums[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i < forwardNums.length; i++) {
            System.out.print(backwardNums[i] + " ");
        }
        System.out.println("");
        System.out.println("Max Profit buying 2 stocks is: " + maxProfitForTwo(forwardNums, backwardNums));
    }
}
