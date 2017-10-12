package leetcode;

/**
 * Created by alexisherrera on 10/11/17.
 */
public class IncreasingTripletSubsequence {

    public boolean betterComplexity(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            //new smallest element
            if (min >= nums[i]) {
                min = nums[i];
            }
            //new secMin
            else if (secMin > nums[i]) {
                secMin = nums[i];
            }
            //we found the thirdMaxValue
            else if (nums[i] > secMin) {
                return true;
            }

        }

        return false;
        //just find smallest element then a larger element and a larger.
    }


    public boolean increasingTriplet(int[] nums) {
        return helper(nums, 0, -1, 0);
    }

    public boolean helper(int[] nums, int index, int prev, int count) {
        if (count == 3) { return true; }
        if (index >= nums.length) { return false; }

        boolean with = false;
        boolean without = false;
        //general case
        if (prev == - 1 || nums[index] > nums[prev]) {
            with = helper(nums, index + 1, index, count + 1);
        }
        without = helper(nums, index + 1, prev, count);
        return with || without;
    }
}
