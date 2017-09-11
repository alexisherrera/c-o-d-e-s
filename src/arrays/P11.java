package arrays;

import java.util.Arrays;

/**
 * Created by alexisherrera on 8/29/17.
 */
public class P11 {

    //next permutation

    //this algorithm tries to increase the value of the permutation minimally by finding the point

    //what we do is we find the pivot point where there is no longer a a decreasing streak from pivot point + 1
    //to the end of the array. this decreasing sequence shows the largest permutation using this sequence. So to
    //increase the permutation by 1, we need to modify something to the left of this suffix in order to increment
    //the permutation minimally. to increment global value minimally we ought to get the value that is
    //larger but smallest to the pivot in the decreasing suffix and swap it. once swapped we have to minimize this suffix.
    //We do this by sorting in ascending order the suffix (larger values should have less weight and be in the back)

    public static int[] nextPermutation(int[] permutation) {
        //find the pivot element
        int pivotIndex = permutation.length - 1;
        while(pivotIndex > 0 && (permutation[pivotIndex - 1] >= permutation[pivotIndex])) {
            pivotIndex--;
        }

        //check if the pivot index is 0 (if it is then the permutation given is actually the largest creatable
        if (pivotIndex == 0) { return permutation; }

        pivotIndex--;

        int minMaximalIndex = 0;

        //now we need to find the element in the suffix that is minimally larger than the pivot
        for (int i = pivotIndex + 1; i < permutation.length; i++) {
            if (permutation[i] > permutation[pivotIndex]) { minMaximalIndex = i; }
        }

        //swap values
        swap(permutation, pivotIndex, minMaximalIndex);


        //sort in ascending order elements pivotIndex + 1 till end
        Arrays.sort(permutation, pivotIndex + 1, permutation.length);

        return permutation;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        //O(n) time. O(1) space
    }

}
