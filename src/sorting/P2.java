package sorting;

/**
 * Created by alexisherrera on 9/11/17.
 */
public class P2 {

    //merge two sorted arrays (merge step in mergesort). first array can hold all elements together
    public static void mergeStep(int[] l1, int[] l2, int lengthL1, int lengthL2) {
        //we can do normal merge step but the problem is swaps. we want to minimize swaps and shifting elements
        //doing that increases our time complexity proportional to the length of the combined array.

        //to solve this lets start at the end of l1 and instead of considering what element is the smallest of
        //the two arrays we consider the largest element of the two and put it at the end of l1
    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
