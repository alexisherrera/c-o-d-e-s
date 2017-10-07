package leetcode;
import java.util.HashMap;

/**
 * Created by alexisherrera on 10/7/17.
 */
public class ContiguousSubarrayBinary {

    public int findMaxLength(int[] nums) {
        //brute force: calculate all subarrays and check if satisfy condition ---> O(n^3)
        //better: grow subarrays from an index. Potentially O(n^2)
        //other: maintain a running sum of 1s in a map at a particular index.


        int maxLength = 0;
        int count = 0;
        HashMap<Integer, Integer> countToIndex = new HashMap<>();

        //include the case where our subarray starts at the first index
        countToIndex.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) { count++; }
            else { count--; }

            if (countToIndex.containsKey(count)) {
                maxLength = Math.max(maxLength, i - countToIndex.get(count));
                //we do not want to update countToIndex with this new index because we are concerned with the
                //largest maximum subarray. If we were to update the index then we subsequent indices with the same
                //count would calculate a subarray based off this new index, which will always be smaller than original
                //occurance of index
            }
            else {
                countToIndex.put(count, i);
            }
        }
        return maxLength;
    }
}
