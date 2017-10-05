package hashtables;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by alexisherrera on 10/5/17.
 */
public class P10 {
    //length of longest contained interval

    //take set of integers, find largest subset of integers in array that have property that if two integers
    //are in the subset, so are all integers in between. return length.
    public static int largestContinousSubset(int[] nums) {

        //brute force is to sort and find largest sequential block --> O(nlgn) time tho

        //we can solve this in O(n) time by utilizing a hashset and populating it with the elements and retrieve
        //and element from it and then expanding on it from both sides of the element until the set no longer contains
        //the elements. This will constitute our longest length

        Set<Integer> elements = new HashSet<>();

        //step1: create our hashset
        for (Integer i : nums) {
            elements.add(i);
        }

        //step2: find the longest sequence
        int maxLength = 0;

        //will do by iterating through array or while elements is not empty
        int index = 0;
        while (index < nums.length && !elements.isEmpty()) {
            int numAtIndex = nums[index];
            int l = 0;

            //left handside
            while (elements.contains(numAtIndex)) {
                l++;
                elements.remove(numAtIndex);
                numAtIndex--;
            }

            numAtIndex = nums[index] + 1;

            //right hand side
            while (elements.contains(numAtIndex)) {

                l++;
                elements.remove(numAtIndex);
                numAtIndex++;
            }

            //update our max
            maxLength = Math.max(maxLength, l);
            index++;
        }

        return maxLength;

        //the complexity is at most O(n), because we touch each element only once. O(n) space
    }


    public static void main(String[] args) {
        int[] nums = {3, -2, 7, 9, 8, 1, 2, 0, -1, 5, 8};

        //should be 6
        System.out.println(largestContinousSubset(nums));

        int[] nums2 = {10, 5, 3, 11, 6, 100, 4};

        //should be 4
        System.out.println(largestContinousSubset(nums2));
    }
}
