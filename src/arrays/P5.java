package arrays;

import java.util.Collections;

/**
 * Created by alexisherrera on 8/26/17.
 */

//delete duplicates from a sorted array
public class P5 {

    public static void deleteDups(int[] arr) {
        //first approach I can think of is to find the first index of a unique element and keep another pointer
        //to iterate over that same element until we reach a new element. When we find that new element we simply swap
        //the first pointer + 1 and the second pointer and we are done. We keep doing this until we reach an unsorted
        //element or the end of the array.


        int arrayIndex = 0;
        int nextElement = 1;
        while (arrayIndex < arr.length && nextElement < arr.length) {
            while(nextElement < arr.length && (arr[nextElement] <= arr[arrayIndex])) { nextElement++; }
            if (nextElement == arr.length) { break; }
            swap(arr, arrayIndex + 1, nextElement);
            arrayIndex++;
        }
        System.out.println("index " + arrayIndex);

    }


    public static void deleteDupsEPI(int[] nums) {
        //the epi approach is simple. we keep a pointer of the next element and keep increasing it until we reach a
        //value that is no longer the same as the element we are on. Once we find a different element we overwrite the index
        //we are at.

        //This is not EPIs method but mine slightly modified. In this method I have a write index where we
        //will begin constructing our newly sorted array. we start at index 1 because we know that index 0 is the same.
        //if the i and write index are distinct then we update the writeIndex + 1 (b.c. this is the new entry) with nums[i].
        int writeIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[writeIndex] != nums[i]) {
                nums[writeIndex + 1] = nums[i];
                writeIndex++;
            }
        }
    }


    public static void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,1, 2,3 ,4,4,4,4, 5, 7,7 };
        deleteDups(nums);
        for (int i = 0;i < nums.length;i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
