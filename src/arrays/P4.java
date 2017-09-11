package arrays;

/**
 * Created by alexisherrera on 8/26/17.
 */

//advance through an array
public class P4 {

    public static boolean advance(int[] nums) {
        return advanceIterative(nums);
    }

    public static boolean advanceRecursive(int[] nums, int start) {
        System.out.println("Start value: " + start);
        if (start >= nums.length - 1) {
            return true;
        }

        int numSteps = nums[start];
        for (int i = numSteps; i > 0; i--) {
            boolean val = advanceRecursive(nums, start + i);
            if (val) {
                return true;
            }
        }
        return false;

        //the running time of this recursive algorithm is O(n) and the space complexity is O(n).
    }



    public static boolean advanceIterative(int[] nums) {
        //we know that the entries denote the total possible steps which we could take. This means that
        //we can advance a total number of the value at a given index of the array OR (if the entry at the
        //array is over 0, to the next index.). we do this until our largest path is == or greater than nums.length - 1 or
        //we can no longer advance in iteration, we encounter a 0 element.

        //we know that we need to reach the end of the array to be able to return true. One way to do this
        //is to iterate through the values in the array and keep track of the furthest index which we can reach.
        //we figure out this index by either keeping the previous maximumIndexReachable or currentIndex + nums[i],
        //whichever is larger.
        // If the longestIndexReachable is equal to longestIndexReachable of a given index (i.e. after this max
        // is computed), we know we can no longer advance past this point in the array, and we must therefore return false
        // This translate to code like this:

        int longestIndexReachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (longestIndexReachable >= nums.length - 1) { return true; }
            longestIndexReachable = Math.max(longestIndexReachable, i + nums[i]);
            if (longestIndexReachable == i) { return false; }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1, 4, 1, 1, 2, 0, 0};
        System.out.println(advance(nums));
    }
}
