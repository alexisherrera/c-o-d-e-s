package leetcode;

/**
 * Created by alexisherrera on 10/13/17.
 */
public class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        //approach: after seeing two elements, move everything else to the back
        int index = 0;
        int runner = 0;

        //each iteration corresponds to a new element value
        while (runner < nums.length) {

            //build: case 1 --> multiple elements, grab two
            if (runner + 1 < nums.length && nums[runner] == nums[runner + 1]) {
                nums[index] = nums[runner];
                index++;
                runner++;
                nums[index] = nums[runner];
            }
            //build: case 2 --> different elements, add 1
            else {
                nums[index] = nums[runner];

            }

            //update pointers
            index++;
            runner++;
            while (runner < nums.length && nums[runner] == nums[runner - 1]) {
                runner++;
            }
        }
        //time complexity is O(n) because runner iterataes at most N spots (same with index)
        return index;
    }
}
