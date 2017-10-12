package leetcode;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Created by alexisherrera on 10/11/17.
 */
public class SubsetsTwo {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //sort the initial array
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        helper(results, curr, nums, 0);
        return results;
    }


    public void helper(List<List<Integer>> results, List<Integer> curr, int[] nums, int index) {
        if (index >= nums.length) {
            results.add(new ArrayList<>(curr));
            return;
        }

        //general case: include element or not. skip indices until next valid element tho
        int element = nums[index];
        int nextIndex = index;

        //find the next index with distinct character
        while(nextIndex < nums.length && nums[nextIndex] == element) {
            nextIndex++;
        }

        //either include current element or exclude

        //add the amount of same elements
        for (int i = 0; i < (nextIndex - index); i++) {
            curr.add(element);
            helper(results, curr, nums, nextIndex);
        }


        //remove added element
        for (int i = 0; i < (nextIndex - index); i++) {
            curr.remove(curr.size() - 1);
        }

        helper(results, curr, nums, nextIndex);

    }
}
