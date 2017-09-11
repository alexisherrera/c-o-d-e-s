package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexisherrera on 9/6/17.
 */
public class P5 {

    //subsets of size k


    public static List<List<Integer>> subsetsOfK(int[] nums, int k) {
        List<List<Integer>> results = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        sK(nums, 0, results, current, k);
        return results;
    }

    public static void sK(int[] nums, int index, List<List<Integer>> results, List<Integer> curr, int k) {
        //this must go before the step where we
        if (curr.size() == k) {
            results.add(new ArrayList<>(curr));
            return;
        }
        if (index == nums.length) { return; }

        //System.out.println("index: " + nums[index] );

        //add or do not include element at this iteration
        curr.add(nums[index]);
        sK(nums, index + 1, results, curr, k);
        curr.remove(curr.size() - 1);
        sK(nums, index + 1, results, curr, k);
    }






    public static void main(String[] args) {
        int[] set = {4, 2, 1, 9, 7};
        List<List<Integer>> results = subsetsOfK(set, 2);

        System.out.println(results);
    }

}
