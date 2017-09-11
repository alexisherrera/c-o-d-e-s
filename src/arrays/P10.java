package arrays;

/**
 * Created by alexisherrera on 8/29/17.
 */
public class P10 {
    //permute the elements of an array

    //we are given an array that designates a permutation that an array of integers needs to follow.
    //the permutation array maps the element to the designated location it needs to be at

    //approach: simple. just start at the beginning of the permutation array and then keep the value at that index
    //in a temporary variable. Then jump to the index designated by perm array at that index and keep hopping until we
    //are back to the index we started.

    public static void applyPermutation(int[] permutation, int[] nums) {

        //we will be using the approach of making all elements in a permutation negative if we encounter them
        for (int i = 0; i < permutation.length; i++) {

            int index = i;

            while (permutation[index] >= 0) {
                int upIndex = permutation[index];
                swap(nums, i, index);
                permutation[index] = permutation[index] - permutation.length;
                index = upIndex;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] perm = {3,2,1,5, 4,0};
        int[] a = {1,2,3,4, 23, 5};

        applyPermutation(perm, a);

        for (int i =0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
