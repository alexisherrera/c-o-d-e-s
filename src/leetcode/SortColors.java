package leetcode;

/**
 * Created by alexisherrera on 10/12/17.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        //red -- > 0, white --> 1, blue -->
        //put all reds first then whites then blues will naturally be in the back

        int redI = 0;
        //first pass sort reds first
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, redI);
                redI++;
            }
        }

        int whiteI = redI;
        //deal with the whites
        for (int i = whiteI; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, whiteI);
                whiteI++;
            }
        }
        //O(n) time complexity and O(1) space

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
